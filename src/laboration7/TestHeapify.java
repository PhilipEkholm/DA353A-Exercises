package laboration7;

import java.util.Random;

import arrays.ArraySupporter;

public class TestHeapify {
	public static void main(String[] args) {
		TestHeapify th = new TestHeapify();
		//th.exercise7b();
		th.exercise7c();
	}
	
	/*
	 *	Test constructor of ArrayHeap 
	 */
	
	private void exercise7b(){
		Integer[] array = new Integer[50];
		Random rand = new Random();
		
		for(int i = 0; i < array.length; i++){
			array[i] = new Integer(rand.nextInt(70));
		}
		
		ArrayHeap<Integer> heap = new ArrayHeap<Integer>(array);

		while(heap.size() > 0){
			System.out.println(heap.delete());
		}
	}
	
	/*
	 *	Test our new sorting algorithm with heaps 
	 */
	
	private void exercise7c(){
		Integer[] array = new Integer[50];
		Random rand = new Random();
		
		for(int i = 0; i < array.length; i++){
			array[i] = new Integer(rand.nextInt(70));
		}
		
		Integer[] sortedArray = ArrayHeap.sort(array);
		
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		
	}
}


































