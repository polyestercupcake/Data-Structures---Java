package model;

/**
 * Basic interface that all lists will implement.
 * 
 * @author cberkstresser
 * 
 */
public interface Stackable<T> {
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
	 * Clears the array to an initialized, size=0 state.
	 */
	void clear();

	/**
	 * Inserts an item in the list.
	 * 
	 * @param dataItem
	 *            The item to insert into the list.
	 */
	void push(T dataItem);

	/**
	 * 
	 * @return Removes the last item pushed onto the stack back to the user.
	 */
	T pop();

	/**
	 * 
	 * @return Shows the last item pushed onto the stack without removing it
	 *         from the stack.
	 */
	T peek();
}