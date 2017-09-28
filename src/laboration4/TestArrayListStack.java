package laboration4;

public class TestArrayListStack {
    public static void main(String[] args) {
    	//Aktivera satserna nedan för att testa ArrayListStack
        ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
        
        for( int i = 10; i < 20; i++ )
            stack.push( i );
        System.out.println( "Size = " + stack.size() );
        System.out.println( "Första element = " + stack.peek() );
        while( !stack.isEmpty() )
            System.out.println( "Element = " + stack.pop() +", size = " + stack.size() );
    }
}