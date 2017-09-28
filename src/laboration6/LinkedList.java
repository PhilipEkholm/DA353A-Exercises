package laboration6;

import java.util.Iterator;

public class LinkedList<E> implements List<E>, Iterable<E> {
    private ListNode<E> list = null;
    
    private ListNode<E> locate(int index) {
        ListNode<E> node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }
    
    public int size() {
        int n = 0;
        ListNode<E> node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }
    
    public E get( int index ) {
        if( ( index < 0 ) || ( index > size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ListNode<E> node = locate( index );
        return node.getData();
    }
    
    public E set( int index, E data ) { 
    	if(index < 0 || index > this.size()){
    		throw new IndexOutOfBoundsException();
    	}
    	else{
    		E oldNode = this.get(index);
    		this.remove(index);
    		this.add(index, data);
    		
    		return oldNode;
    	}
    }
    
	public void add(E data) {
		this.addLast(data);
	}

    public void addFirst( E data ) {
    	this.add(0, data);
    }
    
    public void addLast( E data ) {
    	this.add(this.size(), data);
    }
    
    public void add( int index, E data ) {
    	if(index < 0 || index > this.size()){
    		throw new IndexOutOfBoundsException();
    	}
    	else if(index == 0){
    		list = new ListNode<E>(data, list);
    	}
    	else{
    		ListNode<E> n0 = locate(index - 1);
        	ListNode<E> n1 = new ListNode<E>(data, n0.getNext());
        	n0.setNext(n1);
    	}
    }
    
    public E removeFirst() {
    	return this.remove(0);
    }
    
    public E removeLast() {
    	if(this.size() <= 0){
    		return null;
    	}
    	else{
    		return this.remove(this.size() - 1);
    	}
    }
    
    public E remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        E res;
        if( index == 0 ) {
            res = list.getData();
            list = setNull(list);
//            list = list.getNext();
        } else {
            ListNode<E> node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext(setNull(node.getNext()));
//            node.setNext( node.getNext().getNext() );
        }
        return res;
    }
    
    private ListNode<E> setNull(ListNode<E> toNull) {
    	ListNode<E> res = toNull.getNext();
    	toNull.setData(null);
    	toNull.setNext(null);
    	return res;
    }

	public void clear() {
		this.clear(list.getNext());
		this.list = null;
	}
	
	private void clear(ListNode<E> node){
		if(node.getNext() != null){
			clear(node.getNext());
		}
		node.setNext(null);
	}
	
	public int indexOf(E data) {
		return indexOf(0, data);
	}

	public int indexOf(int startIndex, E data) {
		for(int i = 0; i < this.size(); i++){
			if(data.equals(this.get(i))){
				return i;
			}
		}
		
		return -1;
	}

	public Iterator<E> iterator() {
		return new Iter();
	}    
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    private class Iter implements Iterator<E> {
    	
    	public boolean hasNext() {
    		return false;
    	}
    	
    	public E next() {
    		return null;
    	}
    	
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }
}
