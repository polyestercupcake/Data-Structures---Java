package model;

import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
	// priority is the value
	// the other value is just along for the ride
	private Heapable<T> values = new Heap<>();

	public Data<T> dequeue() {
		if (getSize() > 0) {
			return values.remove();
		}
		return null;
	}

	public void enqueue(Data<T> value) {
			values.insert(value);
	}

	public int getSize() {
		return values.getSize();
	}

	public void clear() {
		values.clear();
	}

	public List<Data<T>> removeAllIntoSortedList() {
		// Heap Sort
		return values.removeAllIntoSortedList();
	}
	
	public String toString() {
		return values.toString();
	}
}
