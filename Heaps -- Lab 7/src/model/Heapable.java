package model;

import java.util.List;

public interface Heapable<T extends Comparable<T>> {
	
	void insert(Data<T> value);
	Data<T> remove();
	void clear();
	int getSize();
	List<Data<T>> removeAllIntoSortedList();
}
