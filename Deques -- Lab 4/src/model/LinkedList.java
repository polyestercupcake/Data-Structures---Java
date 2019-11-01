package model;

public class LinkedList<T> {
//LinkedList contains links to start and end
	private Link<T> start;
	private Link<T> end;
	
	public Link<T> getStart() {
		return start;
	}
	public void setStart(Link<T> start) {
		this.start = start;
	}
	public Link<T> getEnd() {
		return end;
	}
	public void setEnd(Link<T> end) {
		this.end = end;
	}
}
