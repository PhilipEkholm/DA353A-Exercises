package laboration8;

public class Print<T> implements Action<T> {
	public void action( T value ) {
		 System.out.print( value + " " );
	}
}
