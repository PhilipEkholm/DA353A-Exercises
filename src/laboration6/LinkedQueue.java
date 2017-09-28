package laboration6;

public class LinkedQueue<E> implements Queue<E>{
	private List<E> elements;
    private int size;
    
    public LinkedQueue() {
        elements = new LinkedList<E>();
        size = 0;
    }
    
    public void enqueue( E elem ) {
        elements.add(elem);
        size++;
    }
    
    public E dequeue() {
        if(size==0) {
            throw new QueueException("dequeue: Queue is empty");
        }
        E value = elements.get(0);
        for(int i=1; i<size; i++) {
        	elements.set(i - 1, elements.get(i));
        }
        size--;
        elements.set(size, null);
        return value;
    }
    
    public E peek() {
        if( size==0 ) {
            throw new QueueException("peek: Queue is empty");
        }
        return elements.get(0);
    }
    
    public boolean isEmpty() {
        return (size<=0);
    }
    
    public int size() {
        return size;
    }
    
    public String toString(){
    	return elements.toString();
    }

}

























