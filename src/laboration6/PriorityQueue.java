package laboration6;

import java.util.Comparator;

public class PriorityQueue<E> implements Queue<E>{
	private List<E> elements;
    private int size;
    private Comparator<E> comp;

	@Override
	public void enqueue( E data ) {
		 int index = 0;
		 
		 while (index<size && comp.compare(elements.get(index), data) <= 0) {
			 index++;
		 }
		 
		 elements.add(index, data);
		 size++;
	}
	
	public PriorityQueue(){
		elements = new LinkedList<E>();
        size = 0;
	}
	
	public PriorityQueue(Comparator<E> comp){
		this();
        this.comp = comp;
	}

	@Override
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

	@Override
	public E peek() {
		if( size==0 ) {
            throw new QueueException("peek: Queue is empty");
        }
        return elements.get(0);
	}

	@Override
	public boolean isEmpty() {
		return (size<=0);
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString(){
		return elements.toString();
	}
	
}





























