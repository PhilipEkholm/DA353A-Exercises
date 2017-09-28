package laboration1;
import gu2.PaintWindow_GU2;
import java.awt.*;

public class Snowflake {
    public Point getTip(int x, int y, int len, int pos) {
        Point res = null;
        switch(pos % 6) {
            case 0 : res = new Point(x + len, y); break;
            case 1 : res = new Point(x + (int)(Math.cos(Math.PI/3)*len), y - (int)(Math.sin(Math.PI/3)*len)); break;
            case 2 : res = new Point(x - (int)(Math.cos(Math.PI/3)*len), y - (int)(Math.sin(Math.PI/3)*len)); break;
            case 3 : res = new Point(x - len, y); break;
            case 4 : res = new Point(x - (int)(Math.cos(Math.PI/3)*len), y + (int)(Math.sin(Math.PI/3)*len)); break;
            case 5 : res = new Point(x + (int)(Math.cos(Math.PI/3)*len), y + (int)(Math.sin(Math.PI/3)*len)); break;
        }
        return res;
    }
    
    public void snowflake( PaintWindow_GU2 frame, int x, int y, int len, Color color ) {
        frame.line(x-len, y, x+len, y, color, 1);
        frame.line(x + (int)(Math.cos(Math.PI/3)*len), y - (int)(Math.sin(Math.PI/3)*len), x - (int)(Math.cos(Math.PI/3)*len), y + (int)(Math.sin(Math.PI/3)*len), color, 1);
        frame.line(x - (int)(Math.cos(Math.PI/3)*len), y - (int)(Math.sin(Math.PI/3)*len), x + (int)(Math.cos(Math.PI/3)*len), y + (int)(Math.sin(Math.PI/3)*len), color, 1);
    }
    
    public Color randomColor() {
        return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }
        
    // Ersätt halvkoden med kod
    public void newSnowflake( PaintWindow_GU2 frame, int x, int y, int len, Color color ) {
        // Om flingans bredd (len) är minst 10
    	Color randColor = this.randomColor();
    	if(len >= 10){
//    	     Rita en flinga genom anrop till metoden snowflake med parametrarnas värden
            //     Generera en slumpfärg genom att anropa metoden randomColor
    		
    		snowflake(frame, x, y, len, randColor);
    		
        	this.newSnowflake(frame, (int)this.getTip(x, y, len, 0).getX(), (int)this.getTip(x, y, len, 0).getY(), len/3, randColor);
        	this.newSnowflake(frame, (int)this.getTip(x, y, len, 1).getX(), (int)this.getTip(x, y, len, 1).getY(), len/3, randColor);
        	this.newSnowflake(frame, (int)this.getTip(x, y, len, 2).getX(), (int)this.getTip(x, y, len, 2).getY(), len/3, randColor);
        	this.newSnowflake(frame, (int)this.getTip(x, y, len, 3).getX(), (int)this.getTip(x, y, len, 3).getY(), len/3, randColor);
        	this.newSnowflake(frame, (int)this.getTip(x, y, len, 4).getX(), (int)this.getTip(x, y, len, 4).getY(), len/3, randColor);
        	this.newSnowflake(frame, (int)this.getTip(x, y, len, 5).getX(), (int)this.getTip(x, y, len, 5).getY(), len/3, randColor);
    	}
        //     Gör sex REKURSIVA anrop till newSnowflake. Vid anropen ska den nyss ritade flingans 
        //     spetsar vara nya positioner (se nedan), och len ska endast vara en 3:e-del mot 
        //     tidigare. Färgen ska vara den nyss genererade slumpfärgen.
    	
    }
//     REKURSIVT ANROP TILL newSnowflake
//     Koordinater för flingans spetsar kan du erhålla genom anrop till metoden getTip( s, y, len, pos) där pos ska ha något av värdena 0-5
//     getTip returnerar ett Point-objekt: 
//     Point p;
//     p = getSpets(x, y, len, 0);
//     nyFlinga( frame, p.x, p.y, len/3, randomColor );
    
    public static void main(String[] args) {
    	PaintWindow_GU2 frame = new PaintWindow_GU2(600,600,"Snowflakes",Color.BLACK);
        Snowflake graf = new Snowflake();
        graf.newSnowflake(frame, 300, 300, 200, Color.WHITE);
    }    
}
