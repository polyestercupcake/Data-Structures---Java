package ui;

import model.Data;
import model.Queue;
import model.Queueable;
import model.Stack;
import model.Stackable;

public class Main {

	public static void main(String[] args) {
		Stackable<Integer> myS = new Stack<>();
		Queueable<Integer> myQ = new Queue<>();
		myQ.setPriorityQueue(true);
// Stack
//		myS.push(5);
//		myS.push(6);
//		myS.push(7);
//		myS.push(8);
//		myS.push(9);
//		System.out.println(myS);
//		// pop the 2 most recent elements
////		myS.pop();
////		myS.pop();
//		System.out.println(myS.getSize());
//		System.out.println(myS.isFull());
// Queue
//		// enqueue with priority
		myQ.enqueue(new Data<>(7,5));
		myQ.enqueue(new Data<>(1,3));
		myQ.enqueue(new Data<>(3,3));
		myQ.enqueue(new Data<>(0,2));
		myQ.enqueue(new Data<>(9,3));
		System.out.println(myQ);
		myQ.clear();
		
		// enqueue without priority
//		myQ.setPriorityQueue(false);
//		myQ.enqueue(new Data<>(7));
//		myQ.enqueue(new Data<>(7));
//		myQ.enqueue(new Data<>(3));
//		myQ.enqueue(new Data<>(1));
//		myQ.enqueue(new Data<>(8));
//		wont insert past MAX_SIZE
//		myQ.enqueue(new Data<>(9));
		System.out.println(myQ);
		System.out.println(myQ.getSize());
		System.out.println(myQ.isFull());
		//calling .getValue() here causes NullPointerException
		System.out.println(myQ.peek());
	}
}
