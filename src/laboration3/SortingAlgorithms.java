package laboration3;
import java.util.Random;

/*
 *	Test på skoldatorer, double-array med 10k celler:
 *	Bubbelsorering: 114ms
 *	Insertionsortering: 51ms
 *	MergeSortering: 2ms 
 */
/**
 *	@author Philip Ekholm 
 */

public class SortingAlgorithms {
	
	private static double[] generateRandomArray(int length, double min, double max) {
		if (min > max)
			return null;
		
		double[] array = new double[length];
		Random rand = new Random();
		
		for (int i = 0; i < array.length; ++i) {
			array[i] = (min + (rand.nextFloat() * max));
		}
		
		return array;
	}
	
	private static double[] copy(double[] oldArray) {
		if (oldArray == null)
			return null;
		
		double[] array = new double[oldArray.length];
		
		for (int i = 0; i < oldArray.length; ++i) {
			array[i] = oldArray[i];
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		double[] array1 = SortingAlgorithms.generateRandomArray(10000, 5.0, 50),
				array2 = SortingAlgorithms.copy(array1),
				array3 = SortingAlgorithms.copy(array1);
		
		//Test1
//		long start, stop;
//		start = System.currentTimeMillis();
//		SortingAlgorithms.bubbleSort(array1);
//		stop = System.currentTimeMillis();
//		System.out.println("Tid för bubbelsortering: " + (stop - start) + "ms");
		
		//Test2
//		start = System.currentTimeMillis();
//		SortingAlgorithms.insertionSort(array2);
//		stop = System.currentTimeMillis();
//		System.out.println("Tid för insättningssortering: " + (stop - start) + "ms");
		
		//Test3
//		start = System.currentTimeMillis();
//		SortingAlgorithms.mergesort(array3);
//		stop = System.currentTimeMillis();
//		System.out.println("Tid för sammanslagssortering: " + (stop - start) + "ms");
		
		//Uppg 9, sort objects
//		RealNbr[] objectArray = RealNbr.randomNumbers(50, 1, 50);
//		SortingAlgorithms.sortObjectsWithBubblesort(objectArray);
//		for(int i = 0; i < objectArray.length; i++){
//			System.out.println(objectArray[i].getValue());
//		}
		
		//Quicksort
//		int[] array = ArraySupporter.generateRandomArray(5, 0, 50);
//		System.out.println(ArraySupporter.toString(array));
//		Quicksort.sort(array);
//		System.out.println(ArraySupporter.toString(array));
		
		//Uppg 11, sort objects with merge
//		RealNbr[] objectArray = RealNbr.randomNumbers(50, 1, 50);
//		SortingAlgorithms.sortObjectsWithMerge(objectArray);
//		for(int i = 0; i < objectArray.length; i++){
//			System.out.println(objectArray[i].getValue());
//		}
		
		//Uppg 15, with comparator
		RealNbr[] objectArray = RealNbr.randomNumbers(50, 1, 50);
		for(int i = 0; i < objectArray.length; i++){
			System.out.println(objectArray[i].getValue());
		}
}
	
//	public static void insertionsort(double[] array) {
//        for( int i = 1; i < array.length; i++ ) {
//            for ( int j = i; ( j > 0 ) && ( array[j-1] > array[j] ) ; j--) {
//                Utility.swap( array, j, j-1 );
//            }
//        }
//    }
	
	//Descending arraysort, insertion, desc mode
	public static void insertionSort(double[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = i; (j > 0) && (array[j - 1] < array[j]); j--){
				SortingAlgorithms.swap(array, j, j - 1);
			}
		}
	}
	
	//Descending arraysort, insertion, prints descriptions
		public static void describingInsertionSort(double[] array){
			int comparisons = 0,
				swaps = 0;
			
			for(int i = 0; i < array.length; i++){
				for(int j = i; (j > 0) && (array[j - 1] < array[j]); j--){
					SortingAlgorithms.swap(array, j, j - 1);
					swaps++;
				}
				comparisons++;
			}
			
			System.out.println("Insertionsorting---------------------------------------------");
			System.out.println("Antalet jämförelser utförda: " + comparisons + "\n Antalet byten utförda: " + swaps);
		}
	
	//Array sorting, uses bubblesort, desc mode
	public static void bubbleSort(double[] array){
		for(int i = 0; i < array.length - 1; i++){
			for(int j = array.length - 1; j > i; j--){
				if(array[j] > array[j - 1]){
					SortingAlgorithms.swap(array, j, j - 1);
				}
			}
		}
	}
	
	//Array sorting, uses bubblesort
		public static void describingBubbleSort(double[] array){
			int comparisons = 0,
					swaps = 0;
			
			for(int i = 0; i < array.length - 1; i++){
				for(int j = array.length - 1; j > i; j--){
					if(array[j] > array[j - 1]){
						SortingAlgorithms.swap(array, j, j - 1);
						swaps++;
					}
					
					comparisons++;
				}
			}
			
			System.out.println("Bubbelsortering---------------------------------------------");
			System.out.println("Antalet jämförelser utförda: " + comparisons + "\n Antalet byten utförda: " + swaps);
		}
		
		public static void mergesort( double[] array ) {
	        double[] temp = new double[ array.length ];
	        mergesort( array, 0, array.length, temp );
	        temp = null;
	    }
	    
	    // Mergesort, rekursiv
	    private static void mergesort( double[] array, int start, int n, double[] temp ) {
	        int n1,n2;
	        if( n > 1 ) {
	            n1 = n / 2;
	            n2 = n - n1;
	            mergesort( array, start, n1, temp );
	            mergesort( array, start + n1, n2, temp );
	            merge( array, start, n1, n2, temp );
	        }
	    }
	    
	    private static void merge(double[] array, int first, int n1, int n2, double[] temp) {
	        int counter = 0,cursor1 = 0, cursor2 = n1, last = n1 + n2;
	        while( ( cursor1 < n1 ) && ( cursor2 < last ) ) {
	            if( array[ first + cursor1 ] > array[ first + cursor2 ] ) {
	                temp[ counter ] = array[ first + cursor1];
	                cursor1++;
	            } else {
	                temp[ counter ] = array[ first + cursor2 ];
	                cursor2++;
	            }
	            counter++;
	        }
	        while( cursor1 < n1 ) {
	            temp[ counter ] = array[ first + cursor1 ];
	            cursor1++;
	            counter++;
	        }
	        while( cursor2 < last ) {
	            temp[ counter ] = array[ first + cursor2 ];
	            cursor2++;
	            counter++;
	        }
	        for( int i = 0; i < n1 + n2; i++ )
	            array[ first + i ] = temp[ i ];
	    }
	
	public static void swap(double[] array, int i, int j){
		double temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void swap(Object[] array, int i, int j){
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void sortObjectsWithBubblesort(Object[] array){
		for(int i = 0; i < array.length - 1; i++){
			for(int j = array.length - 1; j > i; j--){
				Comparable<Object> comp = (Comparable<Object>)array[j-1];
				if(comp.compareTo(array[j]) > 0){
					SortingAlgorithms.swap(array, j, j - 1);
				}
			}
		}
	}
	
	public static void sortObjectsWithMerge( Object[] array ) {
        Object[] temp = new Object[ array.length ];
        mergesort( array, 0, array.length, temp );
        temp = null;
    }
    
    // Mergesort, rekursiv
    private static void mergesort( Object[] array, int start, int n, Object[] temp ) {
        int n1,n2;
        if( n > 1 ) {
            n1 = n / 2;
            n2 = n - n1;
            mergesort( array, start, n1, temp );
            mergesort( array, start + n1, n2, temp );
            merge( array, start, n1, n2, temp );
        }
    }
    
    private static void merge(Object[] array, int first, int n1, int n2, Object[] temp) {
        int counter = 0,cursor1 = 0, cursor2 = n1, last = n1 + n2;
        while( ( cursor1 < n1 ) && ( cursor2 < last ) ) {
        	Comparable<Object> comp = (Comparable<Object>)array[first + cursor1];
            if(comp.compareTo(array[first + cursor2]) < 0) {
                temp[ counter ] = array[ first + cursor1];
                cursor1++;
            } else {
                temp[ counter ] = array[ first + cursor2 ];
                cursor2++;
            }
            counter++;
        }
        while( cursor1 < n1 ) {
            temp[ counter ] = array[ first + cursor1 ];
            cursor1++;
            counter++;
        }
        while( cursor2 < last ) {
            temp[ counter ] = array[ first + cursor2 ];
            cursor2++;
            counter++;
        }
        for( int i = 0; i < n1 + n2; i++ )
            array[ first + i ] = temp[ i ];
    }
}
























