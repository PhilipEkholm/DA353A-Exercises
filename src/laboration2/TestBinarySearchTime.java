package laboration2;

import java.util.Arrays;

/*
 *	Avg < 0ms på skoldatorer i Gäddan, sortering exkluderad
 *	Avg 3ms på skoldatorer i Gäddan, sortering inkluderad
 */

public class TestBinarySearchTime {
	public static void main(String[] args) {
		Laboration2 l = new Laboration2();
		BinarySearch bs = new BinarySearch();
		Uppg1 u1 = new Uppg1();
		
		int[] generatedArray = l.randomIntArray(10000);
		
		long timeStart = System.currentTimeMillis();
		Arrays.sort(generatedArray);
		
		bs.binarySearch(generatedArray, 20000);
		
		long timeStop = System.currentTimeMillis();
		System.out.println(timeStop - timeStart);
	} 
	
	public int binarySearch(long[] array, long value){
		long min = 0,
			max = array.length - 1;
		
		int pos;
		
		while(min <= max){
			pos = (int)(min + max) / 2;
			
			if(value == array[pos]){
				return pos;
			}
			else if(value < array[pos]){
				max = pos -1;
			}
			else{
				min = pos +1;
			}
		}
		
		return -1;
	}
	
	public int binarySearch(String[] array, String value){
		int min = 0, max = array.length - 1, pos;
		
		while(min <= max){
			pos = (min + max) / 2;
			
			if(array[pos].equals(value))
				return pos;
			else if(array[pos].compareTo(value) < 0)
				max = pos - 1;
			else
				min = pos + 1;
		}
		
		return -1;
	}
	
	public int binarySearch(Object[] array, Object key){
		int min = 0, max = array.length - 1, pos;
		
		while(min <= max){
			pos = (min + max) / 2;
			
			Comparable comp = (Comparable)key;
			
			int comparing = comp.compareTo(array[pos]);
			
			if(comparing == 0){
				return pos;
			}
			else if(comparing < 0){
				max = pos - 1;
			}
			else if(comparing > 0){
				min = pos + 1;
			}
		}
		
		return -1;
	}
}


























