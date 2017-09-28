package laboration2;

import java.util.ArrayList;
import java.util.*;

public class Uppg5 {
	public static void main(String[] args) {
		Uppg5 u5 = new Uppg5();
		
		//Uppg 7 test 1:
//		String[] strArray = {"Abstract", "Arbitrary", "Common", "Delta", "Gamma", "Something", "Losing", "Imagination", "Soon"};
//		String word = "Soon";
//		
//		System.out.println(u5.indexOf(strArray, word));
		//Uppg 7 test 2:
//		RealNbr[] weirdNumbers = new RealNbr[15];
//		
//		for(int i = 0; i < weirdNumbers.length; i++){
//			weirdNumbers[i] = new RealNbr(Math.random());
//		}
		
		Laboration2 l2 = new Laboration2();
		ArrayList l = l2.fillInteger(100000, 10000, 50000);
		
		ArrayList<RealNbr> lR = new ArrayList();
		
		for(int i = 0; i < 100000; i++){
			lR.add(new RealNbr((int) l.get(i)));
		}
		
		Collections.sort(lR);
		
		for(int i = 1; i <= 5; i++){
			System.out.println(Collections.binarySearch(lR, new RealNbr(i * 10000)));
		}
	}
	
	public RealNbr[] getRealNbrArray(int n){
		RealNbr[] array = new RealNbr[n];
		
		for(int i = 0; i < array.length; i++){
			array[i] = new RealNbr(Math.random());
		}
		
		Uppg4.shuffle(array);
		return array;
	}
	
	public int indexOf(RealNbr[] array, RealNbr value){
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(value)){
				return i;
			}
		}
		
		return -1;
	}
	
	public int indexOf(Object[] array, Object obj){
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(obj)){
				return i;
			}
		}
		
		return -1;
	}
}
