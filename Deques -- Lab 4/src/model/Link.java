package model;

public class Link<T> {
	
	private T value;
	//pointers
	private Link<T> next;
	private Link<T> previous;
	
	//Constructors
	public Link() {
	}
	public Link(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Link<T> getNext() {
		return next;
	}
	public void setNext(Link<T> next) {
		this.next = next;
	}
	public Link<T> getPrevious() {
		return previous;
	}
	public void setPrevious(Link<T> previous) {
		this.previous = previous;
	}
}
