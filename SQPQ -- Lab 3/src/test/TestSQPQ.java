package test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Data;
import model.Queue;
import model.Queueable;
import model.Stack;
import model.Stackable;

class TestSQPQ {
	/**
	 * @author cberkstresser
	 */
	@Test
	void popFromEmptyStack() {
		try {
			Stackable<Double> s = new Stack<>();
			s.pop();
		} catch (Exception e) {
			Assert.fail("Pop is crashing on empty list");
		}
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void pushToAFullStack() {
		try {
			Stackable<Integer> s = new Stack<>();
			while (!s.isFull()) {
				s.push(42);
			}
			s.push(42);
		} catch (Exception e) {
			Assert.fail("Push is crashing on a full list");
		}
	}

	/**
	 * @author Tanner Maasen
	 */
	@Test
	void stackDoesNotIncludePoppedValues() {
		Stackable<Integer> s = new Stack<>();
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		// pop the 2 most recent elements
		s.pop();
		s.pop();
		// stack should not include the popped values
		assertTrue(s.getSize() == 3);
	}

	/**
	 * @author Tanner Maasen Edited by Kaleb Johnson (9/18/19)
	 */
	@Test
	void stackDoesIncludePeekedValues() {
		Stackable<Integer> s = new Stack<>();
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		// peek the most recent element
		s.peek();
		// stack should include the peeked values (Edit - Kaleb Johnson: originally said
		// "stack should
		// not include the popped values")
		assertTrue(s.getSize() == 5);
	}

	/**
	 * @author Josiah Falukos Tests getSize() for a stack.
	 * @author Modified by cberkstresser for Stack<>() generics
	 */
	@Test
	public void doesGetSizeStackWork() {

		Stackable<Integer> st = new Stack<>();
		st.push(4);
		st.push(6);
		assertTrue(st.getSize() == 2);
	}

	/**
	 * @author Josiah Falukos Tests getSize() for a queue.
	 * @author Modified by cberkstresser for Queue<>() generics
	 */
	@Test
	public void doesGetSizeQueueWork() {
		Queueable<Integer> qu = new Queue<>();
		qu.enqueue(new Data<>(4));
		qu.enqueue(new Data<>(6));
		assertTrue(qu.getSize() == 2);
	}

	/**
	 * @author Josiah Falukos Tests clear() for a stack.
	 * @author Modified by cberkstresser for Stack<>() generics
	 */
	@Test
	public void doesClearStackWork() {
		Stackable<Integer> st = new Stack<>();
		st.push(6);
		st.push(5);
		st.push(4);
		st.push(2);
		st.clear();
		assertTrue(st.getSize() == 0);
	}

	/**
	 * @author Josiah Falukos Tests clear() for a queue.
	 * @author Modified by cberkstresser for Data<T> types
	 * @author Modified by cberkstresser for Queue<>() generics
	 */
	@Test
	public void doesClearQueueWork() {
		Queueable<Integer> qu = new Queue<>();
		qu.enqueue(new Data<>(6));
		qu.enqueue(new Data<>(5));
		qu.enqueue(new Data<>(4));
		qu.enqueue(new Data<>(2));
		qu.clear();
		assertTrue(qu.getSize() == 0);
	}

	/**
	 * @author Seokwoo Ha Tests peek() for the stack class.
	 * 
	 *         Edited by Kaleb Johnson (9/18/19)
	 */
	@Test
	public void checkPeek() {
		Stackable<Integer> s = new Stack<>(); // Edit - Kaleb Johnson: was originally new Stack();
		s.clear();
		s.push(1);
		s.push(3);

		assertTrue(s.peek() == 3);
	}
	
	/**
	 * @author Seokwoo Ha
	 * Tests multiple pops for the stack class.
	 */
	@Test
	public void checkMultiplePop() {
		Stackable <Integer> s = new Stack();
		s.clear();
		s.push(2);
		s.push(4);
		s.pop();
		s.push(5);
		s.push(61);
		s.pop();
		s.push(11);
		s.pop();
		
		assertTrue(s.toString().equals("[2, 5]"));
	}

	/**
	 * @author Dakota Johnson tests getCapacity This test should be run with a
	 *         MAX_VALUE size of 100 or less.
	 */
	@Test
	public void checkCapacityToMaxSize() {
		Stackable<Integer> s = new Stack<>();
		for (int n = 0; n < 100; n++) {

			s.push(1);
		} // <- this curly was in the wrong place (edited by Josiah)

		assertTrue(s.getCapacity() == s.getSize());
	}

	/**
	 * @author Dakota Johnson
	 */
	@Test
	public void justPopIt() {
		Stackable<Integer> s = new Stack<>();
		for (int n = s.getCapacity(); n > 0; n--) {
			s.pop();
		}
		assertTrue(s.getSize() == 0);
	}

	/**
	 * @author Kaleb Johnson Tests to make sure that the IsFull method returns true
	 *         for a stack of up to size 10 if the stack is full.
	 */
	@Test
	public void testIsFullMethodForFullStack() {
		Stackable<Integer> s = new Stack<>();
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		assertTrue(s.isFull() == true);

	}

	/**
	 * @author Kaleb Johnson Tests to make sure that the IsFull method returns false
	 *         for an empty array.
	 * 
	 *         P.S.: I am not testing for an array of size > 0 because if someone's
	 *         max size is different from 5 (e.g., 1 or 2) and I only test for 5, it
	 *         may fail this test simply because it's max size is different. Testing
	 *         on an empty array ensures that any array size will pass as long as
	 *         max size is not zero.
	 * 
	 */
	@Test
	public void testIsFullMethodForEmptyArray() {
		Stackable<Integer> s = new Stack<>();
		assertTrue(s.isFull() == false);
	}

	/**
	 * @author Kaleb Johnson Tests peek for an empty array. Should return null.
	 */
	@Test
	public void testPeekForEmptyArray() {
		Stackable<Integer> s = new Stack<>();
		assertTrue(s.peek() == null);
	}

	/**
	 * @author Cameron McGeorge
	 * @author Modified by cberkstresser for Data<T> generics
	 * @author Modified by cberkstresser for Queue<>() generics
	 */
	@Test
	public void testGetSizeQueue() {
		Queueable<Integer> qu = new Queue<>();
		qu.enqueue(new Data<>(8));
		qu.enqueue(new Data<>(9));
		assertTrue(qu.getSize() == 2);
	}

	/**
	 * @author Cameron McGeorge
	 * @author Modified by cberkstresser for Data<T> generics
	 * @author Modified by cberkstresser for MAX_SIZE constant visibility
	 */
	@Test
	public void testIsFullForQueue() {
		Queueable<Integer> f = new Queue<>();
		int MAX_SIZE = Queue.MAX_SIZE;
		for (int i = 0; i < MAX_SIZE; i++) {
			f.enqueue(new Data<>(8));
		}
		assertTrue(f.isFull() == true);
	}
	
	/*
	 * @author: Ashton R. Collins
	 * 
	 * Test if MAX_SIZE = 5. Else Fail
	 */
	@Test
	void CheckIfFullStack() {
		Stackable<Integer> myS = new Stack<>();

		myS.push(3);
		myS.push(2);
		myS.push(1);
		myS.push(4);
		myS.push(5);

		assertTrue(myS.getSize() == 5);

	}

	/*
	 * @author: Ashton R. Collins
	 * 
	 * Test if Push then Clear then Push
	 */
	@Test
	void TestPushClearPush() {
		Stackable<Integer> myS = new Stack<>();

		myS.push(3);
		myS.push(2);
		myS.clear();
		myS.push(1);

		assertTrue(myS.peek() == 1);

	}
	
	/**
	 * @author Bradley Stout
	 * @author edited by Caleb Stucky.
	 */
	@Test
	public void priorityQueueSortsByPriority() {
		Queueable<Integer> q = new Queue<>();
		q.setPriorityQueue(true);
		q.enqueue(new Data<>(2,6));
		q.enqueue(new Data<>(8,3));
		q.enqueue(new Data<>(5,1));
		q.enqueue(new Data<>(4,2));
		assertTrue(q.dequeue().getValue() == 5);
		assertTrue(q.dequeue().getValue() == 4);
		assertTrue(q.dequeue().getValue() == 8);
		assertTrue(q.dequeue().getValue() == 2);
	}
	
	/**
	 * @author Bradley Stout
	 * @author edited by Caleb Stucky
	 */
	@Test
	public void peekAtFirstPriority() {
		Queueable<Integer> q = new Queue<>();
		q.setPriorityQueue(true);
		q.enqueue(new Data<>(1,9));
		assertTrue(q.peek().getValue() == 1);
		q.enqueue(new Data<>(8,2));
		assertTrue(q.peek().getValue() == 8);
		q.enqueue(new Data<>(4,3));
		assertTrue(q.peek().getValue() == 8);
	}
	
	/**
	 * @author Ryan Cornelius
	 * Makes sure clear works when used on an already clear stack.
	 */
	@Test
	public void doesClearWorkOnEmptyStack() {
		Stackable<Integer> s = new Stack<>();
		try {
			s.clear();
			s.clear();
			//With nothing, size should = 0.
			assertTrue(s.getSize() == 0);
		} catch (Exception e) {
			System.out.println("Clear does not work on empty stack.");
		}
	}
	
	/**
	 * @author Ryan Cornelius
	 * Makes sure clear works when used on an already clear queue.
	 */
	@Test
	public void doesClearWorkOnEmptyQueue() {
		Queueable<Integer> q = new Queue<>();
		try {
			q.clear();
			q.clear();
			//With nothing, size should = 0.
			assertTrue(q.getSize() == 0);
		} catch (Exception e) {
			System.out.println("Clear does not work on empty queue.");
		}
	}

	/**
	 * This test will check if getSize() returns the expected value.
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	public void getSizeWorks() {
		Stackable<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		assertTrue(s.getSize() == 3);
	}

	/**
	 * This test will check if getCapacity() returns the expected value.
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	public void getCapacityWorks() {
		Stackable<Integer> s = new Stack<>();
		assertTrue(s.getCapacity() == Stack.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 * 	How do you like that for a name? :)
	 */
	@Test
	public void testPriorityQueueDoesNotChangePositionOfNumbersWithSamePriority() {
		Queueable<Integer> pq = new Queue<>();
		pq.setPriorityQueue(true);
		pq.enqueue(new Data<>(3, 10));
		pq.enqueue(new Data<>(1, 10));
		pq.enqueue(new Data<>(2, 1));
		pq.dequeue();
		assertTrue(pq.dequeue().getValue() == 3);
	}
	
	/**
	 * @author Caleb Stucky
	 * 	Another great name ;)
	 */
	@Test
	public void testQueueDoesNotPrioritizeIfPriorityIsSetToFalse() {
		Queueable<Integer> pq = new Queue<>();
		pq.setPriorityQueue(false);
		pq.enqueue(new Data<>(3, 10));
		pq.enqueue(new Data<>(1, 10));
		pq.enqueue(new Data<>(2, 1));
		assertTrue(pq.dequeue().getValue() == 3);
	}
		/**
	 * @author Ethan Hutchison
	 */
	@Test
	void testPop() {
		Stackable<Integer> s = new Stack<>();
		s.push(1);
		s.pop();
	
		// stack should not include the popped values
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Ethan Hutchison
	 */
	@Test
	void popOnEmptyAfterFirstPop() {
		Stackable<Integer> s = new Stack<>();
		s.push(1);
		s.pop();
		s.pop();
	
		// stack should not include the popped values
		assertTrue(s.getSize() == 0);
	}
	
		/**
	 * @author Nolan Perez
	 * Tests functionality of push().
	 */
	@Test
	void testPush() {
		Stackable<Integer> s = new Stack<>();
		s.push(1);
		
		assertTrue(s.peek() == 1);
	}
	
	/**
	 * @author Nolan Perez
	 * Checks for dequeue() operation when chosen to operate from the beginning of the array.
	 * Feel free to ignore this if your dequeue works at the end.
	 */
	@Test
	void checkIfDequeueWorksAtBeginningOfList() {
		Queueable<Integer> qu = new Queue<>();
		qu.setPriorityQueue(false);
		qu.enqueue(new Data<>(2));
		qu.enqueue(new Data<>(4));
		qu.enqueue(new Data<>(6));
		qu.enqueue(new Data<>(8));
		assertTrue(qu.dequeue().getValue() == 2);
	}
	
	/**
	 * @author Josiah Falukos 
	 *  Sometimes weird things happen when calling multiple
	 *  methods in a row, so I created this test to see if everything works
	 *  as intended.
	 */
	@Test
	public void polyTest() {
		try {
		Queueable<Integer> qu = new Queue<>();
		qu.enqueue(new Data<>(4));
		qu.dequeue();
		qu.clear();
		qu.enqueue(new Data<>(8));
		assertTrue(qu.dequeue().getValue() == 8);
		assertTrue(qu.getSize() == 0);
		} catch (Exception e) {
			System.out.println("Figure out what went wrong");
		}
	}

	/**
	 * @author Josiah Falukos
	 */
	@Test
	public void dequeueEmptyQueue() {
		try {
		Queueable<Integer> qu = new Queue<>();
		qu.dequeue();
		qu.enqueue(new Data<>(3));
		qu.dequeue();
		qu.dequeue();
		assertTrue(qu.getSize() == 0);
		} catch (Exception e) {
			Assert.fail("Queue is not handling dequeue when queue empty");
		}
	}
	
	/*
	 * Note from Caleb Stucky:
	 * Please don't be upset if I test something you already tested.
	 * I want to make sure to thoroughly test everything,
	 * and the more tests the better (even if they test the same thing).
	 */
	
	/**
	 * @author Caleb Stucky
	 * Note: new naming convention TestedMethod_TestScenario_ExpectedOutcome.
	 */
	@Test
	public void isFull_EmptyQueue_False() {
		Queueable<Integer> q = new Queue<>();
		
		assertTrue(q.isFull() == false);
	}
	
	/**
	 * @author Caleb Stucky
	 * note: A MAX_SIZE of 1 will fail, but if you have a MAX_SIZE of 1,
	 * 	you've defeated the whole purpose of a queue.
	 */
	@Test
	public void isFull_QueueNotEmptyButNotFull_False() {
		Queueable<Integer> q = new Queue<>();
		
		q.enqueue(new Data<>(0));
		
		assertTrue(q.isFull() == false);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void isFull_FullQueueIntegers_True() {
		Queueable<Integer> q = new Queue<>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<>(0));
		}
		
		assertTrue(q.isFull());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void isFull_FullQueueDoubles_True() {
		Queueable<Double> q = new Queue<Double>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<Double>(0.0));
		}
		
		assertTrue(q.isFull());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_EmptyQueue_0() {
		Queueable<Integer> q = new Queue<Integer>();
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_OneIntegerInQueue_1() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(0));
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_OneDoubleInQueue_1() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<Double>(0.0));
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_QueueFullIntegers_1() {
		Queueable<Integer> q = new Queue<Integer>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<Integer>(0));
		}
		
		assertTrue(q.getSize() == Queue.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_QueueFullDoubles_1() {
		Queueable<Double> q = new Queue<Double>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<Double>(0.0));
		}
		
		assertTrue(q.getSize() == Queue.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getCapacity_IntegerQueue_MAX_SIZE() {
		Queueable<Integer> q = new Queue<Integer>();
		
		assertTrue(q.getCapacity() == Queue.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getCapacity_DoubleQueue_MAX_SIZE() {
		Queueable<Double> q = new Queue<Double>();
		
		assertTrue(q.getCapacity() == Queue.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testCapacityDoesNotChangeQueue() {
		Queueable<Integer> q = new Queue<Integer>();
		int capacityAtBegining = q.getCapacity();
		
		for (int n = 0; n <= Queue.MAX_SIZE + 1; n++) {
			q.enqueue(new Data<Integer>(0));
		}
		
		assertTrue(capacityAtBegining == q.getCapacity());		
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void isPriorityQueue_Queue_False() {
		Queueable<Integer> q = new Queue<Integer>();
		q.setPriorityQueue(false);
		
		assertTrue(q.isPriorityQueue() == false);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void isPriorityQueue_PriorityQueue_True() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		assertTrue(pq.isPriorityQueue());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_EmptyIntegerQueue_NoExceptions() {
		Queueable<Integer> q = new Queue<Integer>();
		
		try {
			q.clear();
		} catch (Exception e) {
			Assert.fail("Clearing an empty integer queue is throwing an exception");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_EmptyDoubleQueue_NoExceptions() {
		Queueable<Double> q = new Queue<Double>();
		
		try {
			q.clear();
		} catch (Exception e) {
			Assert.fail("Clearing an empty double queue is throwing an exception");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_OneIntegerInQueue_EmptyQueue() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(0));
		q.clear();
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_OneDoubleInQueue_EmptyQueue() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<Double>(0.0));
		q.clear();
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_FullIntegerQueue_EmptyQueue() {
		Queueable<Integer> q = new Queue<Integer>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<Integer>(0));
		}
		q.clear();
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_FullDoubleQueue_EmptyQueue() {
		Queueable<Double> q = new Queue<Double>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<Double>(0.0));
		}
		q.clear();
		
		assertTrue(q.getSize() == 0);
	}
	
	/*
	 * Comment from Caleb Stucky:
	 * Since test cases are not supposed to grade implementation,
	 * I will be testing whether everything is in the right order when I test dequeue.
	 * That being said,
	 * your queue may be like mine and have enqueue put items in the right order
	 * and dequeue just grab the last (or first) one.
	 * My tests are designed to work however you implemented queue and priority queue.
	 * If you do find one that fails based on implementation, feel free to change it.
	 */
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_NullItem_SilentlyRefuse() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(null);
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_NullValue_SilentlyRefuse() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(null));
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_NullValueWithPriority_SilentlyRefuse() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(null, 5));
		
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_IntegerQueue_EnqueueTheInteger() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<>(0));
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_DoubleQueue_EnqueueTheDouble() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<>(0.0));
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_FullIntegerQueue_SilentlyRefuse() {
		Queueable<Integer> q = new Queue<Integer>();
		
		for (int n = 0; n <= Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<Integer>(0));
		}
		q.enqueue(new Data<Integer>(0));
		
		assertTrue(q.getSize() == q.getCapacity());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_FullDoubleQueue_SilentlyRefuse() {
		Queueable<Double> q = new Queue<Double>();
		
		for (int n = 0; n <= Queue.MAX_SIZE; n++) {
			q.enqueue(new Data<Double>(0.0));
		}
		q.enqueue(new Data<Double>(0.0));
		
		assertTrue(q.getSize() == q.getCapacity());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_NegativeNumber_EnqueueTheItem() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(-1));
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_PreciseNumber_EnqueueTheItem() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<Double>(0.0001));
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_LargeNumber_EnqueueTheItem() {
		Queueable<Integer> q = new Queue<Integer>();
		final int LARGEST_POSSIBLE_INTEGER = 2147483647;
		
		q.enqueue(new Data<Integer>(LARGEST_POSSIBLE_INTEGER));
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_NumberWithPriority0_SilentlyRefuse() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 0));
		
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_NumberWithPriorityGreaterThan10_SilentlyRefuse() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 11));
		
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void enqueue_NumberWithNegativePriority_SilentlyRefuse() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, -1));
		
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_EmptyQueue_NoExceptions() {
		Queueable<Integer> q = new Queue<Integer>();
		
		try {
			q.dequeue();
		} catch (Exception e) {
			Assert.fail("Dequeue threw an exception on empty queue.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_IntegerQueue_RemovesItemFromQueue() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(0));
		q.dequeue();
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_DoubleQueue_RemovesItemFromQueue() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<Double>(0.0));
		q.dequeue();
		
		assertTrue(q.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_IntegerQueue_DisplaysItemToUser() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(0));
		
		assertTrue(q.dequeue().getValue() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_DoubleQueue_DisplaysItemToUser() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<Double>(0.0));
		
		assertTrue(q.dequeue().getValue() == 0.0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_IntegerQueue_OperateOnFIFOPrinciple() {
		Queueable<Integer> q = new Queue<Integer>();
		q.setPriorityQueue(false);
		
		q.enqueue(new Data<Integer>(0));
		q.enqueue(new Data<Integer>(1));
		
		assertTrue(q.dequeue().getValue() == 0);
	}

	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_DoubleQueue_OperateOnFIFOPrinciple() {
		Queueable<Double> q = new Queue<Double>();
		q.setPriorityQueue(false);
		
		q.enqueue(new Data<Double>(0.0));
		q.enqueue(new Data<Double>(1.0));
		
		assertTrue(q.dequeue().getValue() == 0.0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_IntegerPriorityQueue_RespectPriority() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 3));
		pq.enqueue(new Data<Integer>(1, 2));
		
		assertTrue(pq.dequeue().getValue() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_DoublePriorityQueue_RespectPriority() {
		Queueable<Double> pq = new Queue<Double>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Double>(0.0, 3));
		pq.enqueue(new Data<Double>(1.0, 2));
		
		assertTrue(pq.dequeue().getValue() == 1.0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_IntegerPriorityQueue_OperateOnFIFOPrincipleWithinPriorities() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 3));
		pq.enqueue(new Data<Integer>(1, 3));
		
		assertTrue(pq.dequeue().getValue() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_DoublePriorityQueue_OperateOnFIFOPrincipleWithinPriorities() {
		Queueable<Double> pq = new Queue<Double>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Double>(0.0, 3));
		pq.enqueue(new Data<Double>(1.0, 3));
		
		assertTrue(pq.dequeue().getValue() == 0.0);
	}
	
	/*
	 * Note form Caleb Stucky:
	 * The next few tests only work if you have a MAX_SIZE of at least 5.
	 * I tried to make it work for whatever MAX_SIZE,
	 * but it just ended up complicating it too much.
	 */
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_PriorityQueue_RespectPriorityWithMultiplePriorities_PartI() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 10));
		pq.enqueue(new Data<Integer>(1, 7));
		pq.enqueue(new Data<Integer>(2, 8));
		pq.enqueue(new Data<Integer>(3, 3));
		pq.enqueue(new Data<Integer>(4, 5));
		
		assertTrue(pq.dequeue().getValue() == 3);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_PriorityQueue_RespectPriorityWithMultiplePriorities_PartII() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 10));
		pq.enqueue(new Data<Integer>(1, 7));
		pq.enqueue(new Data<Integer>(2, 8));
		pq.enqueue(new Data<Integer>(3, 3));
		pq.enqueue(new Data<Integer>(4, 5));
		pq.dequeue();
		
		assertTrue(pq.dequeue().getValue() == 4);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_PriorityQueue_RespectPriorityWithMultiplePriorities_PartIII() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 10));
		pq.enqueue(new Data<Integer>(1, 7));
		pq.enqueue(new Data<Integer>(2, 8));
		pq.enqueue(new Data<Integer>(3, 3));
		pq.enqueue(new Data<Integer>(4, 5));
		pq.dequeue();
		pq.dequeue();
		
		assertTrue(pq.dequeue().getValue() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_PriorityQueue_RespectPriorityWithMultiplePriorities_PartIV() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 10));
		pq.enqueue(new Data<Integer>(1, 7));
		pq.enqueue(new Data<Integer>(2, 8));
		pq.enqueue(new Data<Integer>(3, 3));
		pq.enqueue(new Data<Integer>(4, 5));
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		
		assertTrue(pq.dequeue().getValue() == 2);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void dequeue_PriorityQueue_RespectPriorityWithMultiplePriorities_PartV() {
		Queueable<Integer> pq = new Queue<Integer>();
		pq.setPriorityQueue(true);
		
		pq.enqueue(new Data<Integer>(0, 10));
		pq.enqueue(new Data<Integer>(1, 7));
		pq.enqueue(new Data<Integer>(2, 8));
		pq.enqueue(new Data<Integer>(3, 3));
		pq.enqueue(new Data<Integer>(4, 5));
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		
		assertTrue(pq.dequeue().getValue() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_EmptyIntegerQueue_NoExceptions() {
		Queueable<Integer> q = new Queue<Integer>();
		
		try {
			q.peek();
		} catch (Exception e) {
			Assert.fail("Peek threw an exception on an empty integer queue.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_EmptyDoubleQueue_NoExceptions() {
		Queueable<Double> q = new Queue<Double>();
		
		try {
			q.peek();
		} catch (Exception e) {
			Assert.fail("Peek threw an exception on an empty double queue.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_IntegerQueue_DoesNotRemoveItem() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(0));
		q.peek();
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_DoubleQueue_DoesNotRemoveItem() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<Double>(0.0));
		q.peek();
		
		assertTrue(q.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_IntegerQueue_DisplaysItemToUser() {
		Queueable<Integer> q = new Queue<Integer>();
		
		q.enqueue(new Data<Integer>(0));
		
		assertTrue(q.peek().getValue() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_DoubleQueue_DisplaysItemToUser() {
		Queueable<Double> q = new Queue<Double>();
		
		q.enqueue(new Data<Double>(0.0));
		
		assertTrue(q.peek().getValue() == 0.0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void isFull_EmptyStack_False() {
		Stackable<Integer> s = new Stack<Integer>();
		
		assertTrue(s.isFull() == false);
	}
	
	/**
	 * @author Caleb Stucky
	 * note: A MAX_SIZE of 1 will fail, but if you have a MAX_SIZE of 1,
	 * 	you've defeated the whole purpose of a stack.
	 */
	@Test
	public void isFull_StackNotEmptyButNotFull_False() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		
		assertTrue(s.isFull() == false);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void isFull_FullStackIntegers_True() {
		Stackable<Integer> s = new Stack<Integer>();
		
		for (int n = 0; n < Stack.MAX_SIZE; n++) {
			s.push(0);
		}
		
		assertTrue(s.isFull());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void isFull_FullStackDoubles_True() {
		Stackable<Double> s = new Stack<Double>();
		
		for (int n = 0; n < Stack.MAX_SIZE; n++) {
			s.push(0.0);
		}
		
		assertTrue(s.isFull());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_EmptyStack_0() {
		Stackable<Integer> s = new Stack<Integer>();
		
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_OneIntegerInStack_1() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_OneDoubleInStack_1() {
		Stackable<Double> s = new Stack<Double>();
		
		s.push(0.0);
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_StackFullIntegers_1() {
		Stackable<Integer> s = new Stack<Integer>();
		
		for (int n = 0; n < Stack.MAX_SIZE; n++) {
			s.push(0);
		}
		
		assertTrue(s.getSize() == Stack.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getSize_StackFullDoubles_1() {
		Stackable<Double> s = new Stack<Double>();
		
		for (int n = 0; n < Stack.MAX_SIZE; n++) {
			s.push(0.0);
		}
		
		assertTrue(s.getSize() == Stack.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getCapacity_IntegerStack_MAX_SIZE() {
		Stackable<Integer> s = new Stack<Integer>();
		
		assertTrue(s.getCapacity() == Stack.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void getCapacity_DoubleStack_MAX_SIZE() {
		Stackable<Double> s = new Stack<Double>();
		
		assertTrue(s.getCapacity() == Stack.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testCapacityDoesNotChangeStack() {
		Stackable<Integer> s = new Stack<Integer>();
		int capacityAtBegining = s.getCapacity();
		
		for (int n = 0; n <= Queue.MAX_SIZE + 1; n++) {
			s.push(0);
		}
		
		assertTrue(capacityAtBegining == s.getCapacity());		
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_EmptyIntegerStack_NoExceptions() {
		Stackable<Integer> s = new Stack<Integer>();
		
		try {
			s.clear();
		} catch (Exception e) {
			Assert.fail("Clearing an empty integer stack is throwing an exception");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_EmptyDoubleStack_NoExceptions() {
		Stackable<Double> s = new Stack<Double>();
		
		try {
			s.clear();
		} catch (Exception e) {
			Assert.fail("Clearing an empty double stack is throwing an exception");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_OneIntegerInStack_EmptyQueue() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.clear();
		
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_OneDoubleInStack_EmptyQueue() {
		Stackable<Double> s = new Stack<>();
		
		s.push(0.0);
		s.clear();
		
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_FullIntegerStack_EmptyQueue() {
		Stackable<Integer> s = new Stack<Integer>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			s.push(0);
		}
		s.clear();
		
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void clear_FullDoubleStack_EmptyQueue() {
		Stackable<Double> s = new Stack<Double>();
		
		for (int n = 0; n < Queue.MAX_SIZE; n++) {
			s.push(0.0);
		}
		s.clear();
		
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_NullItem_SilentlyRefuse() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(null);
		
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_IntegerStack_PushTheInteger() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_DoubleStack_PushTheDouble() {
		Stackable<Double> s = new Stack<Double>();
		
		s.push(0.0);
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_FullIntegerStack_SilentlyRefuse() {
		Stackable<Integer> s = new Stack<Integer>();
		
		for (int n = 0; n <= Stack.MAX_SIZE; n++) {
			s.push(0);
		}
		s.push(0);
		
		assertTrue(s.getSize() == s.getCapacity());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_FullDoubleStack_SilentlyRefuse() {
		Stackable<Double> s = new Stack<Double>();
		
		for (int n = 0; n <= Stack.MAX_SIZE; n++) {
			s.push(0.0);
		}
		s.push(0.0);
		
		assertTrue(s.getSize() == s.getCapacity());
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_NegativeNumber_PushTheItem() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(-1);
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_PreciseNumber_PushTheItem() {
		Stackable<Double> s = new Stack<Double>();
		
		s.push(0.0001);
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void push_LargeNumber_PushTheItem() {
		Stackable<Integer> s = new Stack<Integer>();
		final int LARGEST_POSSIBLE_INTEGER = 2147483647;
		
		s.push(LARGEST_POSSIBLE_INTEGER);
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_EmptyIntegerStack_NoExceptions() {
		Stackable<Integer> s = new Stack<Integer>();
		
		try {
			s.pop();
		} catch (Exception e) {
			Assert.fail("Stack threw and exception on empty integer stack.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_EmptyDoubleStack_NoExceptions() {
		Stackable<Double> s = new Stack<Double>();
		
		try {
			s.pop();
		} catch (Exception e) {
			Assert.fail("Stack threw and exception on empty double stack.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_IntegerStack_RemovesElementFromStack() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.pop();
		
		assertTrue(s.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_IntegerStack_DisplaysElementToUser() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		
		assertTrue(s.pop() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_IntegerStack_OpperatesOnLastInFirstOutPrinciple() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.push(1);
		
		assertTrue(s.pop() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_DoubleStack_OpperatesOnLastInFirstOutPrinciple() {
		Stackable<Double> s = new Stack<Double>();
		
		s.push(0.0);
		s.push(1.0);
		
		assertTrue(s.pop() == 1.0);
	}
	
	/*
	 * Note from Caleb Stucky:
	 * Once again I could not find a simple way of implementing this
	 * that did not require a MAX_SIZE of at least 5.
	 */
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_StackWithMultipleInputs_OpperatesOnLastInFirstOutPrinciple_PartI() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		
		assertTrue(s.pop() == 3);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_StackWithMultipleInputs_OpperatesOnLastInFirstOutPrinciple_PartII() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		s.pop();
		
		assertTrue(s.pop() == 4);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_StackWithMultipleInputs_OpperatesOnLastInFirstOutPrinciple_PartIII() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		s.pop();
		s.pop();
		
		assertTrue(s.pop() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_StackWithMultipleInputs_OpperatesOnLastInFirstOutPrinciple_PartIV() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		s.pop();
		s.pop();
		s.pop();
		
		assertTrue(s.pop() == 2);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void pop_StackWithMultipleInputs_OpperatesOnLastInFirstOutPrinciple_PartV() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(3);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		
		assertTrue(s.pop() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_EmptyIntegerStack_NoExceptions() {
		Stackable<Integer> s = new Stack<Integer>();
		
		try {
			s.peek();
		} catch (Exception e) {
			Assert.fail("Peek threw and exception on an empty integer stack.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_EmptyDoubleStack_NoExceptions() {
		Stackable<Double> s = new Stack<Double>();
		
		try {
			s.peek();
		} catch (Exception e) {
			Assert.fail("Peek threw and exception on an empty double stack.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_Stack_DoesNotRemoveElementFromStack() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		s.peek();
		
		assertTrue(s.getSize() == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peek_Stack_DisplaysItemToUser() {
		Stackable<Integer> s = new Stack<Integer>();
		
		s.push(0);
		
		assertTrue(s.peek() == 0);
	}
	
}