package model;

public interface Dequeable<T> {
	//left = start and right = end
	void insertLeft(T valueToInsert);
	void insertRight(T valueToInsert);
	T removeLeft();
	T removeRight();
	T peekLeft();
	T peekRight();
	int getSize();
	void clear();
}