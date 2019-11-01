package model;

public class Data<T extends Comparable<T>> {
	// fields
	private T value;
	private int priority;
	
	// constructor
	public Data(T pValue) {
		value = pValue;
		// default priority
		priority = 5;
	}
	// constructor
	public Data(T pValue, int pPriority) {
		value = pValue;
		priority = pPriority;
	}
	// methods
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "[value: " + value + ", priority: " + priority + "]";
	}
}
