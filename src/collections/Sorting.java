package collections;

/**
 *	The Sorting class contains one swap function for double-arrays by value, and two functions
 *	for sorting, where one is stable and suitable for primitive datatypes, and the other is unstable and
 *	therefore unsuitable for general objects. Both sorting methods are recursive.
 *
 *	@author Philip Ekholm
 */

public class Sorting {
	
	/**
	 *	A sorting method that will sort a common array of the double datatype. The array consists of the Divide and Conquer
	 *	method, which means it breaks the array down into smaller parts in order to sort it more effectively.
	 *	
	 *	The array is partitioned to find the pivot index to place in the middle, and division occurs. This continues to do so
	 *	until the array is small enough to sort. 
	 *
	 *	@param array the array to be passed
	 */
	
	public static void sort(double[] array){
		sort(array,0,array.length-1);
	}
	
	private static void sort(double[] array, int left, int right) {
		int pivotIndex;
		if(left < right) {
			pivotIndex = partition(array,left,right,(left+right)/2);
			sort(array,left,pivotIndex-1);
			sort(array,pivotIndex+1,right);
		}
	}
	
	private static int partition(double[] array, int left, int right, int pivotIndex) {
		double pivotValue = array[pivotIndex];
		int storeIndex = left;
		
		Sorting.swap(array, pivotIndex, right);
		for(int i = left; i < right; i++){
			if(array[i] < pivotValue){
				Sorting.swap(array, i, storeIndex);
				storeIndex++;
			}
		}
		
		Sorting.swap(array, storeIndex, right);
		
		return storeIndex;
	}
	
	/**
     * 	The method will shift the value of two elements in a double array
     * 
     * 	@param array the array containing the two values to be swapped
     * 	@param i position for the first element
     * 	@param j position for the second element
     */
    public static void swap( double[] array, int i, int j ) {
        double temp = array[ i ];
        array[ i ] = array[ j ];
        array[ j ] = temp;
    }
    
    /**
     *	A sorting method that can sort an ArrayList of any homogeneous datatype. The algorithm is based on
     *	the Divide and Conquer strategy, and uses recursion to break the array down into smaller and smaller
     *	pieces, to the point where it is easy to sort. Unlike Quicksort this does not use partitioning to find
     *	pivotindex, which means this algorithm is stable, and suitable for sorting common objects.
     *
     * 	Mergesort will split the array recursively, and the merge method will merge the pieces back together.
     * 
     * 	@param list the list to be sorted
     */
	
	public static<E> void sort(ArrayList<E> list){
		ArrayList<E> tempList = new ArrayList<E>(list.size());
        mergesort( list, 0, list.size(), tempList );
        tempList = null;
	}
	
	
    private static <E> void mergesort(ArrayList<E> list, int start, int n, ArrayList<E> tempList ) {
        int n1,n2;
        if( n > 1 ) {
            n1 = n / 2;
            n2 = n - n1;
            mergesort( list, start, n1, tempList );
            mergesort( list, start + n1, n2, tempList );
            merge( list, start, n1, n2, tempList );
        }
    }
    
    private static<E> void merge(ArrayList<E> list, int first, int n1, int n2, ArrayList<E> tempList) {
        int counter = 0,cursor1 = 0, cursor2 = n1, last = n1 + n2;
        while( ( cursor1 < n1 ) && ( cursor2 < last ) ) {
        	Comparable comp = (Comparable)list.get(first + cursor1);
        	if(comp.compareTo(list.get(first + cursor2)) > 0){
        		tempList.add(counter, list.get(first + cursor1));
                cursor1++;
            } else {
            	tempList.add(counter, list.get(first + cursor2));
                cursor2++;
            }
            counter++;
        }
        while( cursor1 < n1 ) {
        	tempList.add(counter, list.get(first + cursor1));
            cursor1++;
            counter++;
        }
        while( cursor2 < last ) {
        	tempList.add(counter, list.get(first + cursor2));
            cursor2++;
            counter++;
        }
        for( int i = 0; i < n1 + n2; i++ ){
        	list.set(first + i, tempList.get(i));
        }
    }
}
