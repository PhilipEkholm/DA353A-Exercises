package laboration5;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 15; i++){
			list.add(new Integer(i * 6));
		}
		System.out.println(list.toString());
		
		list.addFirst(new Integer(74));
		list.addFirst(new Integer(74));
		list.addLast(new Integer(999999));
		
		System.out.println(list.toString());
		
		Integer z = list.set(0, new Integer(400));
		Integer tInt = new Integer(50);
		list.add(12, tInt);
		System.out.println(list.toString());
		System.out.println(z);
		list.add(tInt);
		
		print(list.size());
	}
	
	public static void print(String txt){
		System.out.println(txt);
	}
	
	public static void print(int txt){
		System.out.println(txt);
	}
}
