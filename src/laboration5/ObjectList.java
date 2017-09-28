package laboration5; 

public class ObjectList {
    private ObjectNode list = null;
    
    private ObjectNode locate(int index) {
        ObjectNode node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }
    
    public int size() {
        int n = 0;
        ObjectNode node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }
    
    public Object get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ObjectNode node = locate( index );
        return node.getData();
    }
    
    public Object set( int index, Object data ) {
    	return null;
    }
    
    public void addFirst( Object data ) {
    	this.add(0, data);
    }
    
    public void addLast( Object data ) {
    	this.add(this.size(), data);
    }
    
    public void add( int index, Object data ) {
        if( ( index < 0 ) || ( index > size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        if( index == 0 )
        	list = new ObjectNode( data, list );
        else {
            ObjectNode node = locate( index - 1 );
            ObjectNode newNode = new ObjectNode( data, node.getNext() );
            node.setNext( newNode );
        }
    }
    
    public void set(int index, int data){
    	ObjectNode n = locate(index);
    	n.setData(data);
    }
    
    public Object removeFirst() {
    	return this.remove(0);
    }
    
    public Object removeLast() {
    	return this.remove(this.size() - 1);
    }
    
    public Object remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        Object res;
//        ObjectNode toNull; // help garbagecollection
        if( index == 0 ) {
            res = list.getData();
//            toNull = list;
            list = list.getNext();
        } else {
            ObjectNode node = locate( index - 1 );
            res = node.getNext().getData();
//            toNull = node.getNext();
            node.setNext( node.getNext().getNext() );
        }
//        toNull.setData(null);
//        toNull.setNext(null);
        return res;
    }
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    public static void main(String[] args) {
		ObjectList list = new ObjectList();
		
		list.add(0, 4);
		list.add(0, 5);
		list.add(0, 6);
		list.add(0, 7);
		System.out.println(list.toString());
		list.addFirst(50);
		System.out.println(list.toString());
		list.addLast(70);
		System.out.println(list.toString());
		list.removeFirst();
		System.out.println(list.toString());
		list.removeLast();
		System.out.println(list.toString());
		
	}
}
