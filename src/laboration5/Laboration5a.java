package laboration5;
import java.sql.Ref;

import laboration5.ObjectNode;

public class Laboration5a {
    
    public static void exercise2a() {
    	ObjectNode pos6 = new ObjectNode( 9, null );
    	ObjectNode pos5 = new ObjectNode( 11, pos6 );
    	ObjectNode pos4 = new ObjectNode( -9, pos5 );
    	ObjectNode pos3 = new ObjectNode( -5, pos4 );
    	ObjectNode pos2 = new ObjectNode( 20, pos3 );
    	ObjectNode pos1 = new ObjectNode( 17, pos2 );
    	ObjectNode list = new ObjectNode( 23, pos1 );
    	System.out.println( list );
        
        ObjectNode newPos = new ObjectNode(7, pos4);
        pos3.setNext(newPos);
        
        System.out.println( list );
    }
    
    public static void exercise2b() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        
        // Komplettera med kod så att listan skrivs ut på följande form: [ 23 17 20 -5 -9 11 9 ]
        // OBS, ej anrop list.toString()
        String res = "[";
        
        ObjectNode ref = list;
        res += " " + ref.getData() + " ";
        
        while(ref.getNext() != null){
        	ref = ref.getNext();
        	res += ref.getData() + " ";
        }
        
        System.out.println(res + "]");
    }
    
    public static void exercise2c() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        // Komplettera med kod
        ObjectNode n2 = new ObjectNode(4, pos2);
        ObjectNode n1 = new ObjectNode(-14, n2);
        
        pos1.setNext(n1);
        
        System.out.println( list );
    }
    
    public static void exercise2d() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        ObjectNode n1 = new ObjectNode(-14, pos2);
        ObjectNode n2 = new ObjectNode(4, pos3);
        
        pos1.setNext(n1);
        pos2.setNext(n2);

        System.out.println( list );
    }
    
    public static void exercise2e() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        pos2.setNext(pos4);
        pos3 = null;

        System.out.println( list );
    }
    
    public static void exercise2f() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        System.out.println( list );
        
        list = list.getNext();

        System.out.println( list);
    }
    
    public static void exercise2g() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        list = pos2;
        pos1 = null;

        System.out.println( list );
    }
    
    public static void exercise2h() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        System.out.println( list );
        
        list = list.getNext().getNext();

        System.out.println( list );
    }
    
    public static void exercise2i() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        list.setNext(pos2);
        pos1 = null;
        pos2.setNext(pos4);
        pos3 = null;
        
        System.out.println( list );
    }    
    
    
    public static void main(String[] args) {        
//        Laboration5a.exercise2a();
//        Laboration5a.exercise2b();
//        Laboration5a.exercise2c();
//        Laboration5a.exercise2d();
//        Laboration5a.exercise2e();
//        Laboration5a.exercise2f();
//        Laboration5a.exercise2g();
//        Laboration5a.exercise2h();
        Laboration5a.exercise2i();
    }
}
