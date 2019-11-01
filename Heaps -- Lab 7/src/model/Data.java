package model;

public class Data<T extends Comparable<T>> implements Comparable<Data<T>> {
	private T value;
	private int priority; // highest priority is 1
	public static final int DEFAULT_PRIORITY = 5;

	public Data(T value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	public Data(T value) {
		this.value = value;
		priority = DEFAULT_PRIORITY;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Data<T> o) {
		//major method -- this is making it sort by priority
		return o.priority - this.priority;
	}

	@Override
	public String toString() {
		return "Data[v:" + value + ", p:" + priority + "]";
	}
}
