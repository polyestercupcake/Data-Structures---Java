package ui;

import java.util.List;

import model.Data;
import model.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// List<Data<Integer>> test = new ArrayList<>();
		// test.stream().forEach(x -> System.out.println(x.getPriority()));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.enqueue(new Data<>(10, 7));
		pq.enqueue(new Data<>(13, 6));
		pq.enqueue(new Data<>(11, 5));
		pq.enqueue(new Data<>(12)); // default priority of 5
		pq.enqueue(new Data<>(7, 4));
		pq.enqueue(new Data<>(72, 3));
		pq.enqueue(new Data<>(2, 2));
		pq.enqueue(new Data<>(22, 1));
		pq.enqueue(new Data<>(2, 2));
		pq.enqueue(new Data<>(7, 4));
		pq.enqueue(new Data<>(2, 1));
		pq.enqueue(new Data<>(5, 6));
		System.out.println(pq.toString());
		for (int n = 0; n < 12; n++) {
			System.out.println(pq.dequeue());
		}
		//System.out.println(pq.removeAllIntoSortedList());
	}
}
