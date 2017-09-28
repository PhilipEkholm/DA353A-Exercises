package laboration7; 

public class Laboration7 {
    public void exercise1() {
        BTNode<Integer> n6 = new BTNode<Integer>( new Integer(108), null, null );
        BTNode<Integer> n5 = new BTNode<Integer>( new Integer(100), null, null );
        BTNode<Integer> n4 = new BTNode<Integer>( new Integer(63), null, null );
        BTNode<Integer> n3 = new BTNode<Integer>( new Integer(110), n6, null );
        BTNode<Integer> n2 = new BTNode<Integer>( new Integer(74), n4, n5 );
        BTNode<Integer> tree = new BTNode<Integer>( new Integer(102), n2, n3 );
        //tree.showTree();
        
        BTNode<Integer> res = tree.search(new Integer(108));
        
        if( res != null) {
        	System.out.println( "Finns" );
        }
        else {
        	System.out.println( "Finns ej" );
        }
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        tree.collectLevelOrder(list);
        for(int i=0; i<list.size(); i++) {
         System.out.print(list.get(i) + " ");
        }
        
        System.out.println();
        
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        tree.collect(list2, new IntervalFilter(70,102));
        for(int i=0; i<list2.size(); i++) {
         System.out.print(list2.get(i) + " ");
        }
        
        System.out.println();
        
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        tree.collect(list3, new EvenNumbers());
        for(int i=0; i<list3.size(); i++) {
        	System.out.print(list3.get(i) + " ");
        }
    }
    
    public void exercise2() {
        BTNode<Character> n1 = new BTNode<Character>(new Character('G'),null,null);
        BTNode<Character> n2 = new BTNode<Character>(new Character('S'),n1,null);
        BTNode<Character> n3 = new BTNode<Character>(new Character('X'),n2,null);
        BTNode<Character> n4 = new BTNode<Character>(new Character('N'),n3,null);
        BTNode<Character> tree = new BTNode<Character>(new Character('A'),n4,null);
        tree.showTree();
    }
    
    public void exercise3() {
        BTNode<String> n1 = new BTNode<String>("Anna",null,null);
        BTNode<String> n2 = new BTNode<String>("Anders",null,null);
        BTNode<String> n3 = new BTNode<String>("Emil",null,null);
        BTNode<String> n4 = new BTNode<String>("Admir",null,null);
        BTNode<String> n5 = new BTNode<String>("Lene",n1,n2);
        BTNode<String> n6 = new BTNode<String>("Robert",n3,n4);
        BTNode<String> tree = new BTNode<String>("Ahmed",n5,n6);
        tree.showTree();
    }
    
    public void exercise4(){
    	BTNode<Integer> n1 = new BTNode<Integer>(44, null, null);
    	BTNode<Integer> n2 = new BTNode<Integer>(45, n1, null);
    	BTNode<Integer> n3 = new BTNode<Integer>(36, null, null);
    	BTNode<Integer> n4 = new BTNode<Integer>(38, n3, n2);
    	BTNode<Integer> n5 = new BTNode<Integer>(17, null, null);
    	BTNode<Integer> n6 = new BTNode<Integer>(15, null, n5);
    	BTNode<Integer> tree = new BTNode<Integer>(27, n6, n4);
    	tree.showTree();
    }
    
    public void exercise5(){
    	BTNode<String> n1 = new BTNode<String>("G", null, null);
    	BTNode<String> n2 = new BTNode<String>("F", null, null);
    	BTNode<String> n3 = new BTNode<String>("E", null, null);
    	BTNode<String> n4 = new BTNode<String>("D", n2, n1);
    	BTNode<String> n5 = new BTNode<String>("C", null, null);
    	BTNode<String> n6 = new BTNode<String>("B", n4, n3);
    	BTNode<String> tree = new BTNode<String>("A", n6, n5);
    	tree.showTree();
    }
    
    public static void main(String[] args) {
        Laboration7 lab7 = new Laboration7();
        lab7.exercise1();
    }
}

