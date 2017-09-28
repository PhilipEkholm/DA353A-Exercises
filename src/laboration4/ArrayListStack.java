package laboration4;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<T> implements Stack<T>{
	private ArrayList<T> elements = new ArrayList<T>();

	@Override
	public void push(T element) {
		elements.add(elements.size(), element);
	}
	

	@Override
	public T pop() {
		if(elements.size() <= 0){
			throw new EmptyStackException();
		}
		T lastElement = elements.get(elements.size() - 1);
		elements.remove(elements.size() - 1);
		
		return lastElement;
	}

	@Override
	public T peek() {
		return elements.get(elements.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return (elements.size() <= 0);
	}

	@Override
	public int size() {
		return elements.size();
	}
	
}
