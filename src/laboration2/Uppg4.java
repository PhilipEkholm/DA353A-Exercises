package laboration2;

public class Uppg4{

	private static void swap( Object[] array, int elem1, int elem2) {
		Object temp = array[elem1];
		array[elem1] = array[elem2];
		array[elem2] = temp;
	}

	public static void shuffle( Object[] obj ) {
		int pos;
		
		for(int i = obj.length - 1; i > 0; i--){
			pos = (int)(Math.random() * (i+1));
			swap(obj, i, pos);
		}
	} 
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[5];
		for( int i=0; i<arr.length; i++ )
		 arr[i] = new Integer(i);
		Uppg4.shuffle( arr );
		for( Integer elem : arr )
		 System.out.println(elem);
	}
}