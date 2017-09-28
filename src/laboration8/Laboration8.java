package laboration8;
import java.util.*;

import javax.swing.JOptionPane;

public class Laboration8 {
    public void exercise1() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(20), new Integer(20) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(60), new Integer(60) );
        bst.put( new Integer(80), new Integer(80) );
        bst.put( new Integer(75), new Integer(75) );
        
        bst.root().print();
    }
    
    public void exercise2() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(20), new Integer(20) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(60), new Integer(60) );
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(75), new Integer(75) );
        bst.put( new Integer(80), new Integer(80) );
        
        bst.root().print();
   }
    
    public void exercise3() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(80), new Integer(80) );
        bst.put( new Integer(75), new Integer(75) );
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(60), new Integer(60) );
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(20), new Integer(20) );
        
        bst.root().print();
    }
    
    public void exercise4() {
    	BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
    	bst.put(new Integer(27), new Integer(27));
    	bst.put(new Integer(15), new Integer(15));
    	bst.put(new Integer(38), new Integer(38));
    	bst.put(new Integer(17), new Integer(17));
    	bst.put(new Integer(36), new Integer(36));
    	bst.put(new Integer(45), new Integer(45));
    	bst.put(new Integer(44), new Integer(44));
    	
    	//bst.root().print();
    	bst.traverse(new Print<Integer>());
    }
    
    public void exercise5() {
    	BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
    	bst.put(7, "C");
    	bst.put(15, "H");
    	bst.put(8, "D");
    	bst.put(10, "F");
    	bst.put(5, "B");
    	bst.put(12, "G");
    	bst.put(20, "I");
    	
    	BinarySearchTree<Integer, String> bst2 = new BinarySearchTree<Integer, String>();
    	
    	System.out.println(bst.size1());
    	System.out.println(bst2.size1());
    }
    
    /*********************** Uppgift 6 *************************/
    private BinarySearchTree<String,String> svenskEngelsk() {
        BinarySearchTree<String,String> tree = new BinarySearchTree<String,String>();
        tree.put("vacker","beautiful");
        tree.put("svart","black");
        tree.put("boll", "ball");
        tree.put("vit","white");
        tree.put("lärare","teacher");
        tree.put("karta","map");
        tree.put("hus","house");
        tree.put("vänster","left");
        tree.put("höger","right");
        return tree;
    }
    
    public void exercise6() {
        BinarySearchTree<String,String> tree = svenskEngelsk();
        String svenska = "", engelska;
        while( svenska!=null && !svenska.equals("slut") ) {
        	String res = "";
        	svenska = javax.swing.JOptionPane.showInputDialog( "Skriv ett svenskt ord" );
        	
            if(tree.contains(svenska)){
            	res += svenska + " ger resultatet " + tree.get(svenska);
            }
            else if(!svenska.equals(svenska)){
            	res += svenska + " ger resultatet null";
            }
            
            JOptionPane.showMessageDialog(null, res);
        }
    }
    
    /*********************** Uppgift 7 *************************/
    private TreeMap<String,String> capitals() {
        TreeMap<String,String> tree = new TreeMap<String,String>();
        tree.put("Sverige", "Stockholm");
        tree.put("Danmark", "Köpenhamn");
        tree.put("Norge", "Oslo");
        tree.put("Finland", "Helsingfors");
        tree.put("Ryssland", "Moskva");
        tree.put("Tyskland", "Berlin");
        tree.put("Tjeckien", "Prag");
        tree.put("USA", "Washington D.C");
        tree.put("Grönland", "Nuuk");
        tree.put("Island", "Reykjavik");
        
        return tree;
    }
    
    public void exercise7() {
    	TreeMap<String, String> tree = this.capitals();
    	
    	String input = "";
    	
    	while(!input.equals("slut")){
    		input = JOptionPane.showInputDialog("Mata in namnet på ett land");
    		
    		if(tree.containsKey(input)){
    			JOptionPane.showMessageDialog(null, tree.get(input));
    		}
    		else if(!tree.containsKey(input) && !input.contains("slut")){
    			JOptionPane.showMessageDialog(null, "Huvudstad i "+ input +" är okänd");
    		}
    	}
    }
    
    /*********************** Uppgift 11a + 11b *************************/
    private <K,V> AVLNode<K,V> rotateRight(AVLNode<K,V> node) {
    	AVLNode<K, V> newRoot = node.left;
        AVLNode<K, V> rightChild = newRoot.right;
        newRoot.right = node;
        node.left = rightChild;
        
        return newRoot;
    }
    
    private <K,V> AVLNode<K,V> rotateLeft(AVLNode<K,V> node) {
    	AVLNode<K, V> newRoot = node.right;
        AVLNode<K, V> leftChild = newRoot.left;
        
        newRoot.left = node;
        node.right = leftChild;
        
        return newRoot;
    }
    
    public void exercise11a() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n5, null );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), n4, n3 );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), n2, n1 );
        root.showAVL();
        root = rotateRight(root);
        root.showAVL();
    }
    
    public void exercise11b() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), null, n5 );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), n3, n4 );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n2, n1 );
        root.showAVL();
        root = rotateLeft(root);
        root.showAVL();
    }
    
    /*********************** Uppgift 12a + 12b + 12c *************************/
    private <K,V> int height(AVLNode<K,V> node ) {
        if( node == null )
            return -1;
        return 1 + Math.max( height( node.left ), height( node.right ));
    }
    
    private <K,V> AVLNode<K,V> balanceLeft(AVLNode<K,V> node) {
    	if((this.height(node.left) - this.height(node.right) == 2)){
			if(this.height(node.left.left) - this.height(node.left.right) == -1){
				node.left = this.rotateLeft(node.left);
				node = this.rotateRight(node);
			}
			else{
				node = this.rotateRight(node);
			}
		}
		
		return node;
    }
    
    private <K,V> AVLNode<K,V> balanceRight(AVLNode<K,V> node) {
        if(this.height(node.left) - this.height(node.right) == -2){
        	if(this.height(node.right.left) - this.height(node.right.right) == 1){
        		node.right = this.rotateRight(node.right);
        		node = this.rotateLeft(node);
        	}
        	else{
        		node = this.rotateLeft(node);
        	}
        }
        
        return node;
    }

    public void exercise12a() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n5, null );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), n4, n3 );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), n2, n1 );
        root.showAVL();
        root = balanceLeft(root);
        root.showAVL();
        AVLNode<Integer,Integer> n6 = new AVLNode<Integer,Integer>( new Integer(2), new Integer(2), null, null );
        n5.right = n6;
        root.showAVL();
        root.left = balanceLeft(root.left);
        root.showAVL();
    }

    public void exercise12b() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), null, n5 );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), n3, n4 );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n2, n1 );
        root.showAVL();
        root = balanceRight(root);
        root.showAVL();
        AVLNode<Integer,Integer> n6 = new AVLNode<Integer,Integer>( new Integer(14), new Integer(14), null, null );
        n5.left = n6;
        root.showAVL();
        root.right = balanceRight(root.right);
        root.showAVL();
    }
    
    
    public static void main(String[] args) {
        Laboration8 lab8 = new Laboration8();
        lab8.exercise4();
    }
}
