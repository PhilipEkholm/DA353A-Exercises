package laboration6;

import laboration4.Stack;

public class ArrayListStack<E> implements Stack<E>{
	
	private List<E> stack;
	private int stackPointer;
	
	public ArrayListStack(){
		stack = new LinkedList<E>();
		stackPointer = 0;
	}

	@Override
	public void push(E element) {		
		stack.add(element);
		stackPointer++;
	}

	@Override
	public E pop() {
		return stack.removeLast();
	}

	@Override
	public E peek() {
		return stack.get(stackPointer - 1);
	}

	@Override
	public boolean isEmpty() {
		return (stack.size() <= 0);
	}

	@Override
	public int size() {
		return stackPointer;
	}

}
