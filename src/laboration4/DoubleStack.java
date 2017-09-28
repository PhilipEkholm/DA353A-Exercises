package laboration4;

import java.util.EmptyStackException;

public class DoubleStack implements DStack{
	
	private double[] elements;
	private int stackPointer;
	
	public DoubleStack(int size){
		this.elements = new double[size];
		this.stackPointer = 0;
	}

	@Override
	public void push(Double element) {
		if(stackPointer >= elements.length){
			throw new StackOverflowError();
		}
		
		this.elements[stackPointer++] = element;
	}

	@Override
	public Double pop() {
		if(this.isEmpty()){
			throw new EmptyStackException();
		}
		
		Double number = this.elements[--stackPointer];
		this.elements[stackPointer] = 0;
		
		return number;
	}

	@Override
	public Double peek() {
		return this.elements[stackPointer - 1];
	}

	@Override
	public boolean isEmpty() {
		return (this.stackPointer <= 0);
	}

	@Override
	public int size() {
		return this.stackPointer;
	}

}
