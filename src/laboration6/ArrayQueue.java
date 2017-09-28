package laboration6;

public class ArrayQueue<E> implements Queue<E> {
	private E[] elements;
	 private int front = 0;
	 private int size = 0;

	 public ArrayQueue(int capacity) {
		 elements = (E[])new Object[ capacity ];
	 }

	 public void enqueue( E elem ) {
		 if( size==elements.length) {
			 throw new QueueException("enqueue: Queue is full");
	 }
	 
		 elements[ (front+size) % elements.length ] = elem;
		 size++;
	 }

	 public E dequeue() {
		 if(size==0) {
			 throw new QueueException("dequeue: Queue is empty");
		 }
	 
		 E value = elements[ front ];
		 elements[ front ] = null;
		 size--;
		 front = (front+1) % elements.length;
	 
		 return value;
	 }

	 public E peek() {
		 if( size==0 ) {
			 throw new QueueException("peek: Queue is empty");
		 }
		 
	 	return elements[ front ];
	 }

	 public boolean isEmpty() {
	 return (size==0);
	 }

	 public int size() {
		 return size;
	 }
}
