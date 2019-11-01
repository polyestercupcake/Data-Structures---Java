package model;

/**
 * Basic interface that all lists will implement.
 * 
 * @author cberkstresser
 * @version 1.2
 * 
 */
public interface Queueable<T extends Comparable<T>> {
	/**
	 * 
	 * @return True if the list is full.
	 */
	boolean isFull();

	/**
	 * 
	 * @return Returns the actual size of the list.
	 */
	int getSize();

	/**
	 * 
	 * @return Returns the maximum capacity of the list.
	 */
	int getCapacity();

	/**
	 * 
	 * @return Returns whether this queue should consider priority.
	 */
	boolean isPriorityQueue();

	/**
	 * 
	 * @param pIsPriorityQueue Sets whether this queue is a priority queue.
	 */
	void setPriorityQueue(boolean pIsPriorityQueue);

	/**
	 * Clears the array to an initialized, size=0 state.
	 */
	void clear();

	/**
	 * Inserts an item in the list.
	 * 
	 * @param dataItem The item to insert into the list.
	 */
	void enqueue(Data<T> dataItem);

	/**
	 * 
	 * @return Removes an item from the queue back to the user. Should operate using
	 *         the FIFO principle.
	 * 
	 */
	Data<T> dequeue();

	/**
	 * 
	 * @return Shows the item in the queue that would be dequeued from the queue if
	 *         dequeue were called.
	 */
	Data<T> peek();
}