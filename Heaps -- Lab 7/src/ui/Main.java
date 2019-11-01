package ui;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import model.Data;
import model.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// List<Data<Integer>> test = new ArrayList<>();
		// test.stream().forEach(x -> System.out.println(x.getPriority()));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		pq.enqueue(null);
//		pq.enqueue(new Data<>(10, 7));
//		//System.out.println(pq.toString());
//		pq.enqueue(new Data<>(13, 6));
//		//System.out.println(pq.toString());
//		pq.enqueue(new Data<>(11, 5));
//		//System.out.println(pq.toString());
//		pq.enqueue(new Data<>(12)); // default priority of 5
//		//System.out.println(pq.toString());
//		pq.enqueue(new Data<>(7, 4));
//		//System.out.println(pq.toString());
//		pq.enqueue(new Data<>(72, 3));
//		//System.out.println(pq.toString());
//		pq.enqueue(new Data<>(2, 2));
		//System.out.println(pq.toString());
		pq.enqueue(new Data<>(22, 1));
		pq.enqueue(new Data<>(2, 2));
		pq.enqueue(new Data<>(7, 4));
		pq.enqueue(new Data<>(2, 1));
		pq.enqueue(new Data<>(5, 6));
		pq.dequeue();
		System.out.println(pq.toString());
		System.out.println(pq.getSize());
		//System.out.println(pq.removeAllIntoSortedList());
	}
}
