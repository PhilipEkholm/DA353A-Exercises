package laboration9;

import java.util.Iterator;

public class TestHashtableOH {
	public static void main(String[] args) {
		HashtableOH<String, String> map = new HashtableOH<String, String>(10);
		
		map.put("ss", "Something");
		map.put("sh", "Something else");
		map.put("sc", "Something else else");
		map.put("sa", "hej");
		map.put("sb", "Slut på fantasi");
		
		Iterator<String> iter = map.keys();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	
	private void testGet(){
		
	}
	
	private void testRemove(){
		
	}

	private void testSize(){
	
	}
	
	private void testIsEmpty(){
		
	}
	
	private void testContainsKey(){
		
	}

	private void testClear(){
	
	}
	
	private void testKeys(){
		
	}

	private void testValues(){
	
	}
}
