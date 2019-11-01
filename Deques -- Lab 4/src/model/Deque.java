package model;

import java.util.ArrayList;
import java.util.List;

public class Deque<T> implements Dequeable<T> {
	
	private LinkedList<T> values = new LinkedList<>();
	private int size;
	
	@Override
	public void insertLeft(T valueToInsert) {
		Link<T> linkToInsert = new Link<>(valueToInsert);
		//if the list is empty
	if (valueToInsert != null) {
		if (values.getStart() == null) {
			values.setStart(linkToInsert);
			values.setEnd(linkToInsert);
			size++;
		} else {
			//there is already something at start
			linkToInsert.setNext(values.getStart());
			values.getStart().setPrevious(linkToInsert);
			values.setStart(linkToInsert);
			size++;
		}
	}
}

	@Override
	public void insertRight(T valueToInsert) {
		Link<T> linkToInsert = new Link<>(valueToInsert);
		//if the list is empty
	if (valueToInsert != null) {
		if (values.getStart() == null) {
			values.setStart(linkToInsert);
			values.setEnd(linkToInsert);
			size++;
		} else {
			//there is already something at start
			linkToInsert.setPrevious(values.getEnd());
			//broken
			values.getEnd().setNext(linkToInsert);
			values.setEnd(linkToInsert);
			size++;
		}
	}
}
	
	@Override
	public T removeLeft() {
		T valueToRemove;
		Link<T> linkToRemove = new Link<T>();
		if (values.getStart() != null) {
			valueToRemove = values.getStart().getValue();
			linkToRemove = values.getStart();
			values.setStart(linkToRemove.getNext());
			//set previous to null
			linkToRemove.setPrevious(null);
			size--;
			//returns the leftmost value in the list
			return valueToRemove;
		} else {
			return null;
		}
	}

	@Override
	public T removeRight() {
		T valueToRemove;
		Link<T> linkToRemove = new Link<T>();
		if (values.getEnd() != null) {
			valueToRemove = values.getEnd().getValue();
			linkToRemove = values.getEnd();
			//set next to null
			if (getSize() > 1) {
				values.setEnd(linkToRemove.getPrevious());
				linkToRemove.getPrevious().setNext(null);
			} else {
				values.setStart(null);
			}
			size--;
			//returns the rightmost value in the list
			return valueToRemove;
		} else {
			return null;
		}
	}

	@Override
	public T peekLeft() {
		if (getSize() == 0)
			return null;
		 else
			 return values.getStart().getValue();
	}

	@Override
	public T peekRight() {
		if (getSize() == 0)
			return null;
		 else
			 return values.getEnd().getValue();
	}

	@Override
	public int getSize() {
		//increment on insert
		//decrement on remove
		//set to 0 on clear
		//return size;
//	}
	
//	 getSize()
		if (values.getStart() == null) {
			return 0;
		} else {
			int runningSum = 1;
			Link<T> current = values.getStart();
			while (current.getNext() != null) {
				current = current.getNext();
				runningSum++;
			}
			return runningSum;
		}
	}

	@Override
	public void clear() {
		values.setStart(null);
		values.setEnd(null);
		size = 0;
	}

	@Override
	public String toString() {
		
		if (values.getStart() != null) {
			//get the first one we know is there
			StringBuilder sb = new StringBuilder();
			//get a pointer to dance down the linked list
			Link<T> current = values.getStart();
			//add the first link to the return value
			sb.append("Doubly Linked List: {");
			sb.append(current.getValue() + ",");
			//for each subsequent value...
			while (current.getNext() != null) {
				current = current.getNext();
				sb.append(current.getValue() + ",");
			}
			sb.append("}");
			return sb.toString().replaceAll(",$", "");
		} else {
			return "Linked List is empty.";
		}
	}
	
	/**
	 * This is a method that copies the contents of the values LinkedList to
	 * an array so we can check the values inserted to ensure they are equal.
	 * This is essentially to test your insert methods.
	 * @return copy of the LinkedList
	 */
	public List<T> toArray() {
		List<T> arr = new ArrayList<>();
		if (values.getStart() != null) {
			arr.add(values.getStart().getValue());
		}
		Link<T> temp = values.getStart();
		while (temp.getNext() != null) {
			arr.add(temp.getNext().getValue());
			temp = temp.getNext();
		}
		return arr;
	}
}
