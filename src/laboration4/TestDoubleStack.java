package laboration4;

public class TestDoubleStack {
    public static void main(String[] args) {
    	// Aktivera satserna nedan vid test av DoubleStack
        DoubleStack stack = new DoubleStack(100);
        
        for( int i = 10; i < 20; i++ )
            stack.push( new Double(i) );
        System.out.println( "Size = " + stack.size() );
        System.out.println( "Första element = " + stack.peek() );
        while( !stack.isEmpty() )
            System.out.println( "Element = " + stack.pop() +", size = " + stack.size() );
    }
}
