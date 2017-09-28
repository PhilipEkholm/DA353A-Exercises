package laboration7;
import laboration6.LinkedQueue;

public class BTNode<V> {
    private V value;
    private BTNode<V> left;
    private BTNode<V> right;
    
    public interface Action<V> {
        public void action(V value);
    }
    
    public BTNode( V value, BTNode<V> left, BTNode<V> right ) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public void collect(ArrayList<V> list, Filter<V> filter){
    	if( left != null)
            left.collect(list, filter);
        
    	//Insert action here
    	if(filter.accept(this.value)){
    		list.add(value);
    	}
    	
        if( right != null )
            right.collect(list, filter);
    }
    
    public void collectPreOrder(ArrayList<V> list){
    	list.add(this.value);
    	
    	if(this.left != null){
    		this.left.collectPreOrder(list);
    	}
    	if(this.right != null){
    		this.right.collectPreOrder(list);
    	}
    }
    
    public void collectLevelOrder(LinkedList<V> list) {
    	 LinkedQueue<BTNode<V>> queue = new LinkedQueue<BTNode<V>>();
    	 BTNode<V> node;
    	 queue.enqueue(this);
    	 
    	 while(!queue.isEmpty()) {
    		 node = queue.dequeue();
    		 list.add(node.value);
    	 
    		 if(node.left!=null)
    			 queue.enqueue(node.left);
    		 if(node.right!=null)
    			 queue.enqueue(node.right);
    	 }
    }
    
    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BTNode<V> getLeft() {
        return this.left;
    }

    public void setLeft(BTNode<V> left) {
        this.left = left;
    }

    public BTNode<V> getRight() {
        return this.right;
    }

    public void setRight(BTNode<V> right) {
        this.right = right;
    }

    public int depth() {
        int leftH = -1, rightH = -1;
        if( left != null )
            leftH = left.depth();
        if( right != null )
            rightH = right.depth();
        return 1 + Math.max( leftH, rightH );
    }
    
    public BTNode<V> search(V value){
    	BTNode<V> node = null;
    	
    	if(this.value.equals(value)){
    		node = this;
    	}
    	if(node == null && this.left != null){
    		node = this.left.search(value);
    	}
    	if(node == null && this.right != null){
    		node = this.right.search(value);
    	}
    	
    	return node;
    }
    
    public int size() {
        int leftS = 0, rightS = 0;
        if( left != null )
            leftS = left.size();
        if( right != null )
            rightS = right.size();
        return 1 + leftS + rightS;
    }
    
    public void preorder(Action<V> a) {
        a.action(value);
        if( left != null)
            left.preorder(a);
        if( right != null )
            right.preorder(a);
    }
    
    public void inorder(Action<V> a) {
        if( left != null)
            left.inorder(a);
        a.action(value);
        if( right != null )
            right.inorder(a);
    }
    
    public void postorder(Action<V> a) {
        if( left != null)
            left.postorder(a);
        if( right != null )
            right.postorder(a);
        a.action(value);
    }
    
    public void levelOrder(Action<V> a) {
        LinkedQueue<BTNode<V>> queue = new LinkedQueue<BTNode<V>>();
        BTNode<V> node;
        queue.enqueue(this);
        while(!queue.isEmpty()) {
            node = queue.dequeue();
            a.action(node.value);
            if(node.left!=null)
                queue.enqueue(node.left);
            if(node.right!=null)
                queue.enqueue(node.right);
        }
    }
    
    public void showTree() {
        javax.swing.JOptionPane.showMessageDialog( null, new ShowBTNode<V>( this, 800,600 ), "Show tree", javax.swing.JOptionPane.PLAIN_MESSAGE );
    }
}
