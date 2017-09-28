package laboration8;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import collections.ArrayList;
import collections.List;

public class BinarySearchTree<K,V> implements SearchTree<K,V>, Iterable<V> {
    private Comparator<K> comparator;
    private BSTNode<K,V> tree;
    private int size;
    
    public BinarySearchTree() {
        comparator = new Comp();
    }
    
    public BinarySearchTree( Comparator<K> comp ) {
        comparator = comp;
    }
    
    public boolean contains( K key ) {
	    return find( key ) != null;
	}

	public V first(){
    	BSTNode<K, V> node = tree;
    	
    	if(node == null){
    		return null;
    	}
    	
    	while(node.left != null){
    		node = node.left;
    	}
    	
    	return node.value;
    }

	// Uppgift 10
	public V last(){
		BSTNode<K, V> node = tree;
		
		if(node == null){
			return null;
		}
		
		while(node.right != null){
			node = node.right;
		}
		
		return node.value;
	}

	public V get(K key) {
        BSTNode<K,V> node = find( key );
        if(node!=null)
            return node.value;
        return null;
    }
    
    public int height() {
        return height( tree );
    }
    
    private int height( BSTNode<K,V> node ) {
	    if( node == null )
	        return -1;
	    return 1 + Math.max( height( node.left ), height( node.right ));
	}

	public Iterator<V> iterator() {
        return new Iter();
    }
    
    private BSTNode<K,V> find(K key) {
        int res;
        BSTNode<K,V> node=tree;
        while( ( node != null ) && ( ( res = comparator.compare( key, node.key ) ) != 0 ) ) {
            if( res < 0 )
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }
    
    private BSTNode<K,V> put(BSTNode<K,V> node, K key, V value) {
        if( node == null ) {
            node = new BSTNode<K,V>( key, value, null, null );
        } else {
            if(comparator.compare(key,node.key)<0) {
                node.left = put(node.left,key,value);
            } else if(comparator.compare(key,node.key)>0) {
                node.right = put(node.right,key,value);
            }
        }
        return node;
    }
    
    private BSTNode<K,V> remove(BSTNode<K,V> node, K key) {
        int compare = comparator.compare(key,node.key);
        if(compare==0) {
            if(node.left==null && node.right==null)
                node = null;
            else if(node.left!=null && node.right==null)
                node = node.left;
            else if(node.left==null && node.right!=null)
                node = node.right;
            else {
                BSTNode<K,V> min = getMin(node.right);
                min.right = remove(node.right,min.key);
                min.left = node.left;
                node = min;
            }
        } else if(compare<0) {
            node.left = remove(node.left,key);
        } else {
            node.right = remove(node.right,key);
        }
        return node;
    }
    
    private BSTNode<K,V> getMin(BSTNode<K,V> node) {
        while(node.left!=null)
            node = node.left;
        return node;
    }
        
    public void put(K key, V value) {
	    tree = put(tree,key,value);
	    
	    size++;
	}

	public V remove(K key) {
	    V value = get( key );
	    if(value!=null) {
	        tree = remove(tree,key);
	    }
	    
	    size++;
	    
	    return value;
	}

	public BSTNode<K,V> root() {
	    return tree;
	}

	public int size1(){
    	return tree == null ? 0 : tree.size();
    }
    
    public int size2(){
    	return this.size2(tree);
    }
    
    private int size2(BSTNode<K, V> node){
    	int l = 0, r = 0;
    	
    	if(node.left != null){
    		l = this.size2(node.left);
    	}
    	if(node.right != null){
    		r = this.size2(node.right);
    	}
    	
    	return 1 + r + l;
    }
    
    // Uppgift 8c
    public int size() {
        return size;
    }
    
    // Uppgift 14
    public void print() {
    	print(tree);
    }
    
    private void print(BSTNode<K,V> node) {
    	if(node != null){
    		this.print(node.left);
    		System.out.println("Key: " + node.key + ", Value: " + node.value);
    		this.print(node.right);
    	}
    }
    
    public void printPreorder(){
    	printPreorder(tree);
    }
    
    private void printPreorder(BSTNode<K, V> node){
    	if(node != null){
    		//Insert action here
    		System.out.println("Key: " + node.key + ", Value: " + node.value);
    		
    		if(node.left != null){
    			this.printPreorder(node.left);
    		}
    		if(node.right != null){
    			this.printPreorder(node.right);
    		}
    	}
    }
    
    public void printPostOrder(){
    	tree.printPostOrder();
    }
    
    // Uppgift 18
    public List<K> keys(){
    	ArrayList<K> list = new ArrayList<K>();
    	keys(tree, list);
        return list;
    }
    
    private void keys(BSTNode<K,V> node, ArrayList<K> list){
    	if(node != null){
    		//Insert action here
    		list.add(node.key);
    		
    		if(node.left != null){
    			this.keys(node.left, list);
    		}
    		if(node.right != null){
    			this.keys(node.right, list);
    		}
    	}
    }
    
    public void traverse(Action<V> action){
    	traversePreOrder(action, tree);
    }
    
    private void traversePreOrder(Action<V> action, BSTNode<K, V> node){
    	if(node != null){
    		//Insert action here
    		action.action(node.value);
    		
    		if(node.left != null){
    			this.traversePreOrder(action, node.left);
    		}
    		if(node.right != null){
    			this.traversePreOrder(action, node.right);
    		}
    	}
    }
    
    // Uppgift 19
    public List<V> values(){
    	return null;
    }
    
    private void values(BSTNode<K, V> node, LinkedList<V> list){
    	if( node != null ) {
    		 values( node.left, list );
    		 list.add( list.size(), node.value ); // list.addLast(node.key);
    		 values( node.right, list );
    	}
    }
        
    private class Comp implements Comparator<K> {
        public int compare( K key1, K key2 ) {
            Comparable<K> k1 = ( Comparable<K> )key1;
            return k1.compareTo( key2 );
        }
    }
    
    private class Iter implements Iterator<V> {
        ArrayList<V> list = new ArrayList<V>();
        int index = -1;
        
        public Iter() {
            inOrder(tree);
        }
        
        private void inOrder(BSTNode<K,V> node) {
            if(node!=null) {
                inOrder(node.left);
                list.add(node.value);
                inOrder(node.right);
            }
        }
        
        public boolean hasNext() {
            return index<list.size()-1;
        }
        
        public V next() {
            if(!hasNext())
                throw new NoSuchElementException();
            index++;
            return list.get(index);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree<String,String> tree = new BinarySearchTree<String,String>();
        tree.put("karta","map");
        tree.put("vacker","beautiful");
        tree.put("svart","black");
        tree.put("lärare","teacher");
        tree.put("boll", "ball");
        tree.put("vit","white");
        tree.put("hus","house");
        tree.put("vänster","left");
        tree.put("höger","right");
        tree.printPostOrder();
        tree.root().showTree();
        String res = (String)tree.get("lärare");
        System.out.println(res);
        System.out.println(tree.get("LÄRARE"));
        System.out.println("---------------------");
        Iterator<String> elements = tree.iterator();
//        while(elements.hasNext()) {
//            System.out.println(elements.next());
//        }
        
        //List values in arraylist
        ArrayList<String> list = (ArrayList<String>)tree.keys();
        
//        while(list.size() > 0){
//        	System.out.println(list.removeFirst());
//        }
        
        LinkedList<String> list2 = (LinkedList<String>)tree.values();
        
//        while(list.size() > 0){
//        	System.out.println(list2.removeFirst());
//        }
        
        
        
        tree.root().showTree();
    }
}








