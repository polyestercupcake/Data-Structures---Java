package model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue<T extends Comparable<T>> implements Queueable<T> {

	public static final int MAX_SIZE = 5;
	// data structure, casted to a Data<T>
	@SuppressWarnings("unchecked")
	private Data<T>[] values = (Data<T>[]) Array.newInstance(Data.class, MAX_SIZE);
	// pointer will give us the size of the array. Index position starts at 0
	private int front = 0;
	private int pointer = 0;
	// determines whether the queue is a priority queue or not
	// Defaults to false
	public boolean priorityQueue;

	@Override
	public boolean isFull() {
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
	public boolean isPriorityQueue() {
		return priorityQueue;
	}

	@Override
	public void setPriorityQueue(boolean pIsPriorityQueue) {
		priorityQueue = pIsPriorityQueue;
	}

	@Override
	public void clear() {
		pointer = 0;
	}

	/**
	 * sort on priority basis then sort on FIFO basis when priority is the same if
	 * lower priority than dataItem, swap them
	 */
	@Override
	public void enqueue(Data<T> dataItem) {

// isPriorityQueue == false
		if (dataItem != null) {
			if (isPriorityQueue() == false) {
				if (!isFull() && dataItem.getValue() != null) {
					for (int n = pointer; n >= 0; n--) {
						if (n > 0)
							values[n] = values[n - 1];
					}
					values[front] = dataItem;
					pointer++;
				}
			} else {
// isPriorityQueue == true
				if (dataItem.getPriority() < 11 && dataItem.getPriority() > 0) {
					if (!isFull() && dataItem.getValue() != null) {
// add new dataItem here
						values[pointer] = dataItem;
						pointer++;
// primary and secondary sorting
						for (int n = pointer; n >= 0; n--) {
							if (n != 0) {
								if (values[n - 1].getPriority() < dataItem.getPriority())
									swap((n - 1), n);
							}
							sortFIFOEqualPriority();
						}
					}
				}
			}
		}
	}

	/**
	 * Removes from the queue the first-most value entered. If priority queue,
	 * removes the highest priority, then the first-most values.
	 */
	@Override
	public Data<T> dequeue() {
		if (getSize() != 0) {
			return values[pointer = pointer - 1];
		} else
			return null;
	}

	/**
	 * Displays the next value to be dequeued, but does not delete it. Simply shows
	 * it to the user.
	 */
	@Override
	public Data<T> peek() {

		if (getSize() > 0)
			return values[pointer - 1];
		else
			return null;

	}

	/**
	 * toString to allow the queue to print out nicely to the console. No memory
	 * address!
	 */
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(values, 0, pointer));
	}

	/**
	 * Used to help with enqueue method for priority queue. It swaps two values that
	 * need to be swapped in an array.
	 * 
	 * @param values2
	 * @param values3
	 */
	public void swap(int values2, int values3) {
		Data<T> temp = values[values2];
		values[values2] = values[values3];
		values[values3] = temp;
	}

	/**
	 * Used to help with enqueue method for priority queue. It swaps two values that
	 * need to be swapped in an array that have the same priority. Runs off of FIFO
	 * principle.
	 */
	public void sortFIFOEqualPriority() {
		for (int n = 1; n < pointer; n++) {
				if (values[n - 1].getPriority() == values[n].getPriority()) {
					swap(n, n - 1);
			}
		}
	}
}
