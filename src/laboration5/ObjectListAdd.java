package laboration5;
import laboration5.ObjectNode;

public class ObjectListAdd {
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
    
    public void add( int index, int data ) {
        if(index < 0 || index >= this.size()){
        	throw new IndexOutOfBoundsException();
        }
        
        if(index == 0){
        	list = new ObjectNode(data, list);
        }
        else{
        	ObjectNode lastNode = locate(index - 1);
        	ObjectNode n = new ObjectNode(data, lastNode.getNext());
        	lastNode.setNext(n);
        }
    }
    
    public Object remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        Object res;
        if( index == 0 ) {
            res = list.getData();
            list = list.getNext();
        } else {
        	ObjectNode node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext( node.getNext().getNext() );
        }
        return res;
    }
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }

    public static void main(String[] args) {
        ObjectListAdd list = new ObjectListAdd();
        for(int i=0; i<5; i++)
            list.add(i,i);
        for(int i=4; i>=0; i--)
            list.add(i,i);
        System.out.println(list);
    }
}
