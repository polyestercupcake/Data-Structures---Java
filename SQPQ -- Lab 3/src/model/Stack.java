package model;

import java.util.Arrays;

public class Stack<T> implements Stackable<T> {
	
	public static final int MAX_SIZE = 5;
	// data structure
	@SuppressWarnings("unchecked")
	private T[] values = (T[]) new Object[MAX_SIZE];
	// pointer will give us the size of the array. Index position starts at 0
	private int pointer = 0;

	@Override
	public boolean isFull() {
		// it'll be true if pointer == max
		//returns false if not
		return (pointer == MAX_SIZE);
	}

	@Override
	public int getSize() {
		return pointer;
	}

	@Override
	public int getCapacity() {
		return MAX_SIZE;
	}

	@Override
	public void clear() {
		pointer	= 0;
	}

	@Override
	public void push(T dataItem) {
		if (!isFull() && dataItem != null) {
			values[pointer] = dataItem;
			pointer++;
		}
	}

	@Override
	public T pop() {
		if(getSize() != 0)
			return values[--pointer];
		else
			return null;
	}

	@Override
	public T peek() {
		if (pointer > 0)
			return values[pointer - 1];
		else
			return null;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(values, 0, pointer));
	}
}
