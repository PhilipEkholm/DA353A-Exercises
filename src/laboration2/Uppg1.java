package laboration2;

public class Uppg1 {
	public static void main(String[] args) {
		Uppg1 app = new Uppg1();
		double[] array = {3, 2, 6, 12, 3, 8};
		String[] strArray = {"Abstract", "Arbitrary", "Common", "Delta", "Gamma", "Something", "Losing", "Imagination", "Soon"};
		
		//Linear search array
		System.out.println(app.indexOf(array, 52));
		System.out.println(app.indexOf(strArray, "Trainstation"));
	}
	
	public int indexOf(double[] array, double value){
		for(int i = 0; i < array.length; i++){
			if(array[i] == value){
				return i;
			}
		}
		
		return -1;
	}
	
	public int indexOf(int[] array, int value){
		for(int i = 0; i < array.length; i++){
			if(array[i] == value){
				return i;
			}
		}
		
		return -1;
	}
	
	public int indexOf(String[] array, String value){
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(value)){
				return i;
			}
		}
		
		return -1;
	}
}
















