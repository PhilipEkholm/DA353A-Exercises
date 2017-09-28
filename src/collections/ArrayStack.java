package collections;

import java.util.EmptyStackException;

/**
 *	ArrayStack class is a class that allows data to be stored as a stack datastructure using the LiFo-structure, implements the Stack interface which
 *	states certain methods to be implemented. Supports generics to work with any homogeneous datatype.
 *
 * 	@author Philip Ekholm
 */
public class ArrayStack<T> implements Stack<T> {
	
	/**
	 *	We have the array to store our values in a form of stack, and
	 *	size to keep track of how much space we currently use.
	 */
	
    private T[] elements;
    private int size=0;
    
    /**
     *	Our base constructor that will take a certain capacity. Elements must be instantiated with Object and then
     *	type converted to our generic type with given capacity.
     *
     *	@param capacity the number of elements this stack will be sized for
     */
    
    public ArrayStack(int capacity) {
        elements = (T[])(new Object[capacity]);
    }
    
    /**
     *	Push - Add elements to the top of the stack, add to the size position of the element which
     *	works as our "stack pointer" in this class.
     *
     *	@param element the element to be added to the stack
     *	@throws StackOverflowError if trying to add to the stack while it's full
     */

    public void push(T element) {
    	if(size > elements.length)
    		throw new StackOverflowError();
        elements[ size ] = element;
        size++;
    }
    
    /**
     *	Pop - Remove elements from the top of the stack. The object to be removed is afterwards dereferenced
     *	in order to increase efficiency of the garbage collector.
     *
     *	@throws EmptyStackException if trying to pop objects from an empty stack
     *	@return the object to be removed from the stack
     */

    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T elem = elements[--size];
        elements[size] = null;
        return elem;
    }
    
    /**
     *	Return the object currently on the top of the stack, unlike the pop method this will not remove it, only return a reference to it.
     *
     * 	@throws EmptyStackException if trying to pop objects from an empty stack
     * 	@return the object from the top of the stack
     */

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size-1];
    }
    
    /**
     *	A method that gives a boolean back if the stack is empty or not.
     *	
     *	@return if stack is empty: true, otherwise return false 
     */

    public boolean isEmpty() {
        return (size==0);
    }
    
    /**
     *	Return the number of elements currently on the stack
     *
     *	@return size - number of elements on stack
     */

    public int size() {
        return size;
    }
    
    /**
     *	Main for internal testing, can be ignored. 
     */

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(20);
        Integer elem;
        for(int i=0; i<10; i++) {
            stack.push(new Integer(i));
        }
//        stack.push("HEJ"); // kompileringsfel
        while(!stack.isEmpty()) {
            elem = stack.pop();
            System.out.print(elem + " ");
        }
    }
}
