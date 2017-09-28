package laboration8;

import collections.ArrayList;

public class CollectValues<T> implements Action<T>{
	
	private ArrayList<T> list = new ArrayList<T>();

	@Override
	public void action(T value) {
		list.add(value);
	}
	
	public ArrayList<T> getValues(){
		return list;
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer,Integer> bst = new BinarySearchTree <
				Integer,Integer >();
				CollectValues<Integer> cv = new CollectValues<Integer>();
				bst.put( new Integer(27), new Integer(27) );
				bst.put( new Integer(15), new Integer(15) );
				bst.put( new Integer(38), new Integer(38) );
				bst.put( new Integer(17), new Integer(17) );
				bst.put( new Integer(36), new Integer(36) );
				bst.put( new Integer(45), new Integer(45) );
				bst.put( new Integer(44), new Integer(44) );
				bst.traverse( cv );
				ArrayList<Integer> values = cv.getValues();

				while(values.size() > 0){
					System.out.print(values.removeFirst() + " ");
				}
	}
}
