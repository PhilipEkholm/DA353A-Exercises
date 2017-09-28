package laboration9;

import java.util.Iterator;

public class TestHashtableCH {
	
	public static void main(String[] args) {
		TestHashtableCH map = new TestHashtableCH();
		
		//map.testGet();
		map.testGrow();
	}
	
	private void testGet(){
		HashtableCH<Integer, String> map = new HashtableCH<Integer, String>();
		
		map.put(50, "Something");
		map.put(60, "Something else");
		map.put(70, "Something else else");
		map.put(80, "hej");
		map.put(90, "Slut på fantasi");
		
		System.out.println(map.get(new Integer(80)));
		System.out.println(map.remove(new Integer(50)));
		System.out.println(map.size());
		System.out.println(map.containsKey(70));
		System.out.println(map.containsKey(71));
		
		Iterator<String> iter = map.values();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
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
	
	private void testGrow(){
		HashtableCH<String, String> map = new HashtableCH<String, String>(2);
		
		map.put("sa", "say");
		map.put("sb", "some blue");
		map.put("sc", "scania");
		map.put("sd", "Sverigedemokraterna");
		
		System.out.println(map.size());
		System.out.println(map.remove("sc"));
		System.out.println(map.size());
	}

	private void testValues(){
	
	}
}
