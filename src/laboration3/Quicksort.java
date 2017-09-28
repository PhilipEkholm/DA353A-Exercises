package laboration3;

public class Quicksort {
	public static void sort(int[] arr) {
		 sort(arr,0,arr.length-1);
	}
	
	private static void sort(int[] arr, int left, int right) {
		int pivotIndex;
		if(left < right) {
			pivotIndex = partition(arr,left,right,(left+right)/2);
			sort(arr,left,pivotIndex-1);
			sort(arr,pivotIndex+1,right);
		}
	}
	
	private static int partition(int[] arr, int left, int right, int pivotIndex) {
		int pivotValue = arr[pivotIndex];
		int storeIndex = left;
		
		Utility.swap(arr, pivotIndex, right);
		for(int i = left; i < right; i++){
			if(arr[i] < pivotValue){
				Utility.swap(arr, i, storeIndex);
				storeIndex++;
			}
		}
		
		Utility.swap(arr, storeIndex, right);
		
		return storeIndex;
	}
}
