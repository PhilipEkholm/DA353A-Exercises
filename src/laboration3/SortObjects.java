package laboration3;

import java.util.Random;

public class SortObjects {
	private static int[] generateRandomArray(int length, int min, int max) {
		if (min > max)
			return null;
		
		int[] array = new int[length];
		Random rand = new Random();
		
		for (int i = 0; i < array.length; ++i) {
			array[i] = (min + rand.nextInt(max));
		}
		
		return array;
	}
	
	private static String toString(int[] array) {
		if (array == null)
			return null;
		
		String str = "[";
		
		for (int i = 0; i < array.length - 1; ++i) {
			str += array[i];
			
			/* Do not add comma if last element */
			if (i != array.length - 2)
				str += ", ";
		}
		
		return (str + "]");
	}
	
	public static void main(String[] args) {
		int[] array = SortObjects.generateRandomArray(5, -5, 5);
		
		System.out.println(SortObjects.toString(array));
		SortObjects.bubbleSortObjects(array);
		System.out.println(SortObjects.toString(array));
	}
	
	public static void bubbleSortObjects(int[] array){
		for(int i = 0; i < array.length; i++){
			
		}
	}
}





































