package laboration2;

/*
 *	Avg 22ms på skoldatorer i Gäddan 
 */

public class TestLinearSearchTime {
	public static void main(String[] args) {
		TestLinearSearchTime t = new TestLinearSearchTime();
		Laboration2 l = new Laboration2();
		Uppg1 u1 = new Uppg1();
		
		int[] generatedArray = l.randomIntArray(10000);
		long timeStart = System.currentTimeMillis();
		
		for(int i = 0; i < generatedArray.length; i++){
			u1.indexOf(generatedArray, 20000);
		}
		
		long timeStop = System.currentTimeMillis();
		System.out.println(timeStop - timeStart);
	} 
}






















