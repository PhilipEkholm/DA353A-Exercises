package laboration4;
import java.util.*;

public class Laboration4 {
    public void reverse(Double[] array) {
        DoubleStack ds = new DoubleStack(array.length);
        
        for(int i = 0; i < array.length; i++){
        	ds.push(array[i]);
        }
        
        for(int i = 0; i < array.length; i++){
        	array[i] = ds.pop();
        }
    }
    
    public void descending(Double[] array) {
        Arrays.sort(array);
        this.reverse(array);
    }
    
    public void uppgift5() {
        Double[] arr = {new Double(5),new Double(14),new Double(12),new Double(9),
        		        new Double(3),new Double(7),new Double(5),new Double(12)};
        reverse( arr );
        for(Double d : arr) {
            System.out.print(d+" ");
        }
    }
    
    public void uppgift6() {
        Double[] arr = {new Double(5),new Double(14),new Double(12),new Double(9),
		                new Double(3),new Double(7),new Double(5),new Double(12)};
        descending( arr );
        for(Double d : arr) {
            System.out.print(d+" ");
        }
    }
    
    public static void main(String[] args) {
        Laboration4 lab4 = new Laboration4();
//      lab4.uppgift5();
        lab4.uppgift6();
    }
}
