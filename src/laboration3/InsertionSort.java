package laboration3;

import java.util.Comparator;

public class InsertionSort {
	public static void sort(Object[] array, Comparator<Object> comp){
		for(int i = 0; i < array.length; i++){
			for(int j = i; (j > 0) && (comp.compare(array[j-1], array[j]) > 0); j--){
				SortingAlgorithms.swap(array, j, j - 1);
			}
		}
	}
}
