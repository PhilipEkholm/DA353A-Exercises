package laboration1;

public class Adder implements IntModifier {
	 private int nbr;
	 
	 public Adder( int nbr ) {
		 this.nbr= nbr;
	 }
	 
	 public int modifyInt( int number ) {
		 return ( number + nbr );
	 }
}
