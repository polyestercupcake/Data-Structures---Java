package ui;

import model.Deque;
import model.Dequeable;

public class Main {

	public static void main(String[] args) {
		Deque<Integer> myDq = new Deque<>();
		//toString works
		myDq.insertLeft(9);
		myDq.insertLeft(5);
		myDq.insertRight(1);
		myDq.removeLeft();
		myDq.removeRight();
		System.out.println(myDq);
		System.out.println(myDq.toArray());
		System.out.println(myDq.peekLeft());
		System.out.println(myDq.peekRight());
		System.out.println(myDq.getSize());
	}
}
