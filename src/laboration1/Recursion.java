package laboration1;

public class Recursion {
	public static void main(String[] args) {
		Recursion app = new Recursion();
		
		//app.print(-3, 4);
		//app.everySecondReverse("Stuent", 6);
		//app.reverse(-2, 1);
		//app.print("Malm� H�gskola!", 6);
		//System.out.print(app.factorial(4));
		
		//Member
//		int[] arr = { 23, -45, -20, 10, 8 };
//		System.out.println( app.member( 17, arr, 0 ) ); // Resultat: false
//		System.out.println( app.member( 23, arr, 0 ) ); // Resultat: true
//		System.out.println( app.member( 23, arr, 2 ) ); // Resultat: false
//		System.out.println( app.member( 10, arr, 0 ) ); // Resultat: true
		
		//Sum
//		System.out.println( app.sum( 4, 8 ) ); // Resultat: 30
//		System.out.println( app.sum( 5, 2 ) ); // Resultat: 0
//		System.out.println( app.sum( -2, 1 ) ); // Resultat: -2
		
		//System.out.println( app.reverse( "Student" ) );
		
		//EverySecond
//		app.everySecond( "Student", 0, 6 ); // Resultat: Student
//		app.everySecond( "Student", 3, 5 ); // Resultat: den
//		app.everySecond( "Malm� h�gskola!", -4, 6 ); // Resultat:
//		app.everySecond( "Hubert", 2, 10 ); // Resultat:
//		app.everySecond( "Hubert", 5, 2 ); // Resultat:
		
		//PRINTSTRING
//		app.printString( "Student", 0 , 2); // Resultat: Suet
//		app.printString( "Student", 3 , -1); // Resultat: dutS
//		app.printString( "du", 0 , 2); // Resultat: d
//		app.printString( "Malm� h�gskola! ", -2 , 1); // Resultat:
//		app.printString( "Hubert", 10 , 0); // Resultat:
		
		//Digits
//		System.out.println( app.digits( "Student" ) ); // Resultat: 0
//		System.out.println( app.digits( "RDS 435" ) ); // Resultat: 3
//		System.out.println( app.digits( "Pw TT54W41" ) ); // Resultat: 4
		
		//Digits - check number of digits in number
//		System.out.println( app.digits( 95004 ) ); // Resultat: 5
//		System.out.println( app.digits( 32 ) ); // Resultat: 2
		
		//Fibonacci
//		System.out.println( app.fib( 1 ) ); // Resultat: 1
//		System.out.println( app.fib( 4 ) ); // Resultat: 3
//		System.out.println( app.fib( 8 ) ); // Resultat: 21
		
		//Tidstest, tog 2132ms p� skolans dator (approx. 2,1s)
//		long starttid = System.currentTimeMillis();
//		for(int i = 0; i < 1000; i++){
//			app.fib2(30);
//		}
//		long stopptid = System.currentTimeMillis();
//		
//		System.out.println(stopptid - starttid);
//		System.out.println(app.fib2(30));
		
		//Test interface IntModifier
		Adder adder = new Adder( 9 );
		int[] arr = { 17,-4, 6 };
		app.changeIntArray( arr, adder );
		
		for( int key : arr ) {
			System.out.print ( key + " " ); // Utskrifterna 26 5 15
		}
		
		
	}
	
	public void print(int min, int max){
		if(min <= max){
			System.out.print(min + " ");
			print(min + 1, max);
		}
	}
	
	public void everySecondReverse(String txt, int pos){
		if(pos >= 0 && pos < txt.length()){
			System.out.print(txt.charAt(pos));
			everySecondReverse(txt, pos-2);
		}
	}
	
	public void reverse(int min, int max){
		if(max >= min){
			System.out.print(max + " ");
			reverse(min, max-1);
		}
	}
	
	public void print(String txt, int pos){
		if(pos > 0 && pos < txt.length()){
			System.out.print(txt.charAt(pos));
			print(txt, pos+1);
		}
	}
	
	public long factorial(long n){
		if(n <= 1){
			return 1;
		}
		else{
			return n * factorial(n - 1);
		}
	}
	
	public boolean member(int nbr, int[] array, int pos){
		if(pos < 0 || pos >= array.length){
			return false;
		}
		else if(nbr == array[pos]){
			return true;
		}
		else{
			return member(nbr, array, pos + 1);
		}
	}
	
	public int sum(int min, int max){
		if(min > max){
			return 0;
		}
		else{
			return min + sum(min + 1, max);
		}
	}
	
	public String reverse(String s){
		if(s.equals("")){
			return "";
		}
		else{
			return reverse(s.substring(1)) + s.charAt(0);
		}
	}
	
	public void everySecond(String txt, int startPos, int endPos){
		if((startPos >= 0) && (endPos <= txt.length()) && (startPos <= endPos)){
			System.out.print(txt.charAt(startPos));
			everySecond(txt, startPos + 1, endPos);
		}
	}
	
	public void printString(String txt, int pos, int n){
		if(pos >= 0 && pos < txt.length()){
			System.out.print(txt.charAt(pos));
			printString(txt, pos + n, n);
		}
	}
	
	public int digits(String str){
		if(str.equals("")){
			return 0;
		}
		else if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
			return 1 + digits(str.substring(1));
		}
		
		return digits(str.substring(1));
		
	}
	
	public int digits(int number){
		if(number == 0){
			return 0;
		}
		else{
			return 1 + digits(number / 10);
		}
	}
	
	public long fib(long n){
		if(n <= 2){
			return 1;
		}
		else{
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	public long fib2(int n){
		return fib2(n, 1, 1);
	}
	
	private long fib2(int n, int n1, int n2){
		if(n <= 2){
			return n2;
		}
		else{
			return fib2(n - 1, n2, n1 + n2);
		}
	}
	
	public void changeIntArray(int[] array, IntModifier mod){
		changeIntArray(array, mod, 0);
	}
	
	private void changeIntArray(int[] array, IntModifier mod, int pos){
		if(pos >= 0 && pos < array.length){
			array[pos] = mod.modifyInt(array[pos]);
			changeIntArray(array, mod, pos+1);
		}
	}
}
















