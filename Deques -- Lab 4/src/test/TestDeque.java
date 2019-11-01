package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Dequeable;
import model.Deque;

class TestDeque {
	/**
	 * @author cberkstresser
	 * Edited by Kaleb Johnson (9/25/19) "Changed name of method"
	 */
	@Test
	void removeLeftFromEmptyList() { //Edit by Kaleb Johnson: changed name from removeLeftFromEmptyStack; seems more accurate and less confusing.
		try {
			Dequeable<Double> d = new Deque<>();
			d.removeLeft();
		} catch (Exception e) {
			Assert.fail("removeLeft() is crashing on empty list");
		}
	}

	/**
	 * @author cberkstresser
	 * Edited by Kaleb Johnson (9/25/19) "Changed name of method"
	 */
	@Test
	void removeRightFromEmptyList() { //Edit by Kaleb Johnson: changed name from removeRightFromEmptyStack; seems more accurate and less confusing.
		try {
			Dequeable<Double> d = new Deque<>();
			d.removeRight();
		} catch (Exception e) {
			Assert.fail("removeRight() is crashing on empty list");
		}
	}
    
    /**
	 * @author cberkstresser
	 * Edited by Ian Berkstresser: You used "I" instead of "i" for the first letter of "d.InsertLeft(...)"
	 */
	@Test
	void removeRightPullsFromRightSide() {
		//this would be a way to achieve queue behavior by inserting on the left and removing on the right.
		//you could also get queue behavior by always inserting on the right and removing on the left.
		Dequeable<Double> d = new Deque<>();
		d.insertLeft(5.5);
		d.insertLeft(6.5);
		assertTrue(d.removeRight() == 5.5);
	}
	
	/**
	 *@author Ashton R. Collins 
	 *Edited by cberkstresser: Changing 2.0 to 6.0
	 */
	@Test
	void checkPeekLeft() {
		Deque<Double> ll = new Deque<>();
		
		ll.insertLeft(2.0);
		ll.insertLeft(4.0);
		ll.insertLeft(6.0);
		
		assertTrue (ll.peekLeft().equals(6.0));
		
	}
	
	/**
	 *@author Ashton R. Collins 
	 *Edited by cberkstresser: Changing 6.0 to 2.0
	 */
	@Test
	void checkPeekRight()  {
		Deque<Double> ll = new Deque<>();
		
		ll.insertLeft(2.0);
		ll.insertLeft(4.0);
		ll.insertLeft(6.0);
		
		assertTrue (ll.peekRight().equals(2.0));
		
	}
	
	// Test names are nt_methodToTest_expectedResult made after Caleb Stucky's test
	// names on SQPQ.
	/**
	 * Methods tested: insertRight | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_insertRight_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertRight("I should not cause an exception when put into the deque.");
		} catch (Exception e) {
			Assert.fail("Deque.insertRight(...) is throwing an error.");
		}
	}

	/**
	 * Methods tested: insertLeft | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_insertLeft_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertLeft("I should not cause an exception when put into the deque.");
		} catch (Exception e) {
			Assert.fail("Deque.insertLeft(...) is throwing an error.");
		}
	}

	// If one of the above insert tests failed, the corresponding right / left
	// versions of these next four will too.
	/**
	 * Methods tested: insertRight, removeRight | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_removeRight_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertRight("I should not cause an exception when taken out of the deque.");
			dec.removeRight();
		} catch (Exception e) {
			Assert.fail("Deque.removeRight() is throwing an error.");
		}
	}

	/**
	 * Methods tested: insertLeft, removeLeft | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_removeLeft_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertLeft("I should not cause an exception when taken out of the deque.");
			dec.removeLeft();
		} catch (Exception e) {
			Assert.fail("Deque.removeLeft() is throwing an error.");
		}
	}

	/**
	 * Methods tested: insertRight, peekRight | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_peekRight_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertRight("I should not cause an exception when peeked at.");
			dec.peekRight();
		} catch (Exception e) {
			Assert.fail("Deque.peekRight(...) is throwing an error.");
		}
	}

	/**
	 * Methods tested: insertLeft, peekLeft | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_peekLeft_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertLeft("I should not cause an exception when peeked at.");
			dec.peekLeft();
		} catch (Exception e) {
			Assert.fail("Deque.peekLeft(...) is throwing an error.");
		}
	}

	/**
	 * Methods tested: insertRight, insertLeft, clear | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_clear_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertRight("I should not cause an exception when cleared.");
			dec.insertLeft("I should not cause an exception when cleared.");
			dec.clear();
		} catch (Exception e) {
			Assert.fail("Deque.clear(...) is throwing an error.");
		}
	}

	/**
	 * Methods tested: insertRight, insertLeft, getSize | Input validity: yes | Expected result: no errors
	 * 
	 * @author Ian Berkstresser "Nexon"
	 */
	@Test
	void nt_getSize_noException() {
		Deque<String> dec = new Deque<>();
		try {
			dec.insertRight("I should not cause an exception when size is called.");
			dec.insertLeft("I should not cause an exception when size is called.");
			dec.getSize();
		} catch (Exception e) {
			Assert.fail("Deque.getSize(...) is throwing an error.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peekLeft_EmptyDeque_NoExceptions() {
		Dequeable<Integer> di = new Deque<>();
		
		try {
			di.peekLeft();
		} catch (Exception e) {
			Assert.fail("peekLeft is throwing an exception when there is nothing in the list.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void peekRight_EmptyDeque_NoExceptions() {
		Dequeable<Integer> di = new Deque<>();
		
		try {
			di.peekRight();
		} catch (Exception e) {
			Assert.fail("peekRight is throwing an exception when there is nothing in the list.");
		}
	}
	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void insertLeftReturnsCorrectSize() {
		Deque<Integer> myDq = new Deque<>();
	try {
		myDq.insertLeft(5);
		myDq.insertLeft(10);
		myDq.insertLeft(15);
		myDq.insertLeft(20);
		myDq.insertLeft(25);
		assertTrue(myDq.getSize() == 5);
	} catch (Exception e) {
		Assert.fail("Insert right method does not work correctly. " +
		"Paste into main and find out why.");
		}
	}
	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void insertRightReturnsCorrectSize() {
		Deque<Integer> myDq = new Deque<>();
	try {
		myDq.insertRight(5);
		myDq.insertRight(10);
		myDq.insertRight(15);
		myDq.insertRight(20);
		myDq.insertRight(25);
		assertTrue(myDq.getSize() == 5);
	} catch (Exception e) {
		Assert.fail("Insert right method does not work correctly. " +
		"Paste into main and find out why.");
		}
	}
	
	/**
	 * @author Josiah Falukos
	 */
	@Test
	void insertRightAndRemoveRightAreTheSameSide() {
		Dequeable<Double> de = new Deque<>();
		de.insertRight(8.8);
		assertTrue(de.peekLeft().equals(8.8)); //Edit by Tanner. Since there is only one number in the LinkedList, both peeks should peek to the same value, rather than null.
	}
	
	/**
	 * @author Josiah Falukos
	 */
	@Test
	void insertAfterCallingClear() {
		Dequeable<String> de = new Deque<>();
		de.clear();
		de.insertLeft("I am insert left");
		de.insertRight("I am insert right");
		assertTrue(de.getSize() == 2);
	}
	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void insertLeftPeekRight() {
		Deque<Integer> myDq = new Deque<>();
	try {
		myDq.insertLeft(5);
		myDq.insertLeft(10);
		myDq.insertLeft(15);
		myDq.insertLeft(20);
		myDq.insertLeft(25);
		assertTrue(myDq.peekRight() == 5);
	} catch (Exception e) {
		Assert.fail("InsertLeft or peekRight method does not work correctly. "
				+ "Paste into main and find out why.");
		}
	}
	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void insertRightPeekLeft() {
		Deque<Integer> myDq = new Deque<>();
	try {
		myDq.insertRight(5);
		myDq.insertRight(10);
		myDq.insertRight(15);
		myDq.insertRight(20);
		myDq.insertRight(25);
		assertTrue(myDq.peekLeft() == 5);
	} catch (Exception e) {
		Assert.fail("InsertRight or peekLeft method does not work correctly. "
				+ "Paste into main and find out why.");
		}
	}
	
	/**
	 * @author Nolan Perez
	 */
	@Test
	void clearMethodWorks() {
		Deque<Integer> deq = new Deque<>();
	try {
		deq.insertLeft(5);
		deq.insertLeft(9);
		deq.insertLeft(3);
		deq.clear();
		assertTrue(deq.getSize() == 0);
	} catch (Exception e) {
		Assert.fail("Clear did not work or has malfunctioned");
	}
	}
	
	/**
	 * @author Nolan Perez
	 */
	@Test
	void getSizeFunctional() { //Edit by Kaleb Johnson: original name was getSizefunctional. Functional should be capitalized.
		Deque<Integer> deq = new Deque<>();
	try {
		deq.insertLeft(5);
		deq.insertLeft(9);
		deq.insertLeft(3);
		deq.insertLeft(1);
		deq.insertLeft(6);
		assertTrue(deq.getSize() == 5);
	} catch (Exception e) {
		Assert.fail("getSize() returns an inaccurate result"); 
	}
	}
	
	/**
	 * @author Kaleb Johnson
	 * Ensures that removeLeft is removing the value to the left.
	 */
	@Test
	public void removeLeftPullsFromLeftSide() {
		Dequeable<Integer> myDeq = new Deque<>();
		myDeq.insertRight(5);
		myDeq.insertRight(3);
		myDeq.insertLeft(1);
		assertTrue(myDeq.removeLeft() == 1);
		
	}
	
	/**
	 * @author Kaleb Johnson
	 * Ensures that removeLeft returns correct size for list not empty.
	 */
	@Test
	public void removeLeftReturnsCorrectSizeForListNotEmpty() {
		Dequeable<Integer> myDeq = new Deque<>();
		myDeq.insertLeft(5);
		myDeq.insertLeft(4);
		myDeq.insertLeft(6);
		myDeq.removeLeft();
		assertTrue(myDeq.getSize() == 2);
	}
	
	/**
	 * @author Kaleb Johnson
	 * Ensures that removeRight returns correct size for list not empty.
	 */
	@Test
	public void removeRightReturnsCorrectSizeForListNotEmpty() {
		Dequeable<Integer> deqMineNotYours = new Deque<>();
		deqMineNotYours.insertRight(5);
		deqMineNotYours.insertRight(6);
		deqMineNotYours.insertRight(2);
		deqMineNotYours.removeRight();
		assertTrue(deqMineNotYours.getSize() == 2);
	}
	
	/**
	 * @author Kaleb Johnson
	 * Ensures that removeLeft returns correct size for empty list.
	 */
	@Test
	public void removeLeftReturnsCorrectSizeForEmptyList() {
		Dequeable<Integer> yeet = new Deque<>();
		yeet.removeLeft();
		assertTrue(yeet.getSize() == 0);
	}
	
	/**
	 * @author Kaleb Johnson
	 * Ensures that removeRight returns correct size for empty list.
	 */
	@Test
	public void removeRightReturnsCorrectSizeForEmptyList() {
		Dequeable<Integer> yeet = new Deque<>();
		yeet.removeRight();
		assertTrue(yeet.getSize() == 0);
	}
	
	/**
	 * @author Bradley Stout
	 */
	@Test
	void testMixedInsertSize() {
		Dequeable<Integer> deck = new Deque<>();
		deck.insertLeft(3);
		deck.insertRight(4);
		deck.insertLeft(6);
		deck.insertLeft(1);
		deck.insertRight(10);
		deck.insertRight(5);
		assertTrue(deck.getSize() == 6);
	}
	
	//	/**
	//	 * @author Bradley Stout
	//	 */
	//	@Test
	//	void removeLeftPullsFromLeftSide() {
	//		Dequeable<Integer> deck = new Deque<>();
	//		deck.insertRight(6);
	//		deck.insertRight(4);
	//		
	//		assertTrue(deck.removeLeft() == 6);
	//	}
	
	//Who's is this?
	@Test
	public void removeTwiceWorks() {
		Deque<Integer> dq = new Deque<>();
		dq.insertLeft(4);
		dq.insertLeft(5);
		dq.insertLeft(7);
		dq.removeRight();
		dq.removeRight();
		assertTrue(dq.peekLeft() == 7);
	}
	
	//Who's is this?
	@Test
	public void peekFromBothSidesSameIfOne() {
		Deque<Integer> dq = new Deque<>();
		dq.insertRight(8);
		assertTrue(dq.peekLeft() == dq.peekRight());
	}
	
	
	/**
	 * @author Ryan Cornelius
	 * Tests to see if InsertRight is placing values to the far right,
	 * rather than to the left or inbetween, after values have been placed
	 * in from the left.
	 */
	@Test
	public void doesInsertRightInsertIntoCorrectPositionFollowingInsertLeft() {
		Dequeable<Integer> dq = new Deque<>();
		try {
			dq.insertLeft(11);
			dq.insertLeft(22);
			dq.insertLeft(33);
			//List should be [33, 22, 11]
			dq.insertRight(8);
			//List should now be [33, 22, 11, 8]
			assertTrue(dq.peekRight() == 8);
		} catch (Exception e) {
			Assert.fail("8 should be on the far right but is not.");
		}
	}
	
	/**
	 * @author Ryan Cornelius
	 * Tests to see if InsertLeft is placing values to the far left,
	 * rather than to the right or inbetween, after values have been placed
	 * in from the right.
	 */
	@Test
	public void doesInsertLeftInsertIntoCorrectPositionFollowingInsertRight() {
		Dequeable<Integer> dq = new Deque<>();
		try {
			dq.insertRight(11);
			dq.insertRight(22);
			dq.insertRight(33);
			//List should be [11, 22, 33]
			dq.insertLeft(8);
			//List should now be [8, 11, 22, 33]
			assertTrue(dq.peekLeft() == 8);
		} catch (Exception e) {
			Assert.fail("8 should be on the far left but is not.");
		}
	}
	
		/**
	 * @author Seokwoo Ha
	 */
	@Test
	public void checkAllInsertsFunctionality() {
		Dequeable<Integer> myDeque = new Deque<>();

		try {
			myDeque.insertLeft(5);
			myDeque.insertLeft(2);
			myDeque.insertRight(3);
			myDeque.insertRight(7);
			assertTrue(myDeque.peekLeft() == 2);
			assertTrue(myDeque.peekRight() == 7);
		} catch (Exception e) {
			Assert.fail("Your insert functions are not working at the same time.");
		}
	}
	
	/**
	 * @author Seokwoo Ha
	 */
	@Test
	public void checkGetSizeFunctionalityWithMultipleNulls() {
		Dequeable<Integer> myDeque = new Deque<>();

		try {
			myDeque.insertLeft(null);
			myDeque.insertLeft(null);
			myDeque.insertLeft(2);
			myDeque.insertLeft(null);
			myDeque.insertLeft(null);
			assertTrue(myDeque.getSize() == 1);
		} catch (Exception e) {
			Assert.fail("Input Error. The program should not accept a null as a value.");
		}
	}
	/**
		 * @author Ethan Hutchison
		 */
		@Test
		void peekLeftDoesNotPop() {
			Deque<Integer> myDeque = new Deque<>();
		try {
			myDeque.insertLeft(5);
			myDeque.insertLeft(10);
			myDeque.peekLeft();
			
			assertTrue(myDeque.getSize() == 2);
		} catch (Exception e) {
			Assert.fail("Oops. Something went haywire here.");
			}
		}
		/**
		 * @author Ethan Hutchison
		 */
		@Test
		void peekRightDoesNotPop() {
			Deque<Integer> myDeque = new Deque<>();
		try {
			myDeque.insertRight(5);
			myDeque.insertRight(10);
			myDeque.peekRight();
			
			assertTrue(myDeque.getSize() == 2);
		} catch (Exception e) {
			Assert.fail("Oops. Something went haywire here.");
			}
		}
		
		/**
		 * @author Caleb Stucky
		 */
		@Test
		public void removeRight_removeMultipleThingsPastEndOfList_NoExceptions() {
			Dequeable<Integer> goodD = new Deque<>();
			
			try {
				
			for (int n = 0; n < 10; n++) {
				goodD.insertLeft(n);
			}
			
			for (int n = 0; n < 12; n++) {
				goodD.removeRight();
			}
			
			} catch (Exception e) {
				Assert.fail("Removing from the right is throwing an exception when you remove more elements that were in the list");
			}
		}
		
		/**
		 * @author Caleb Stucky
		 */
		@Test
		public void removeLeft_removeMultipleThingsPastEndOfList_NoExceptions() {
			Dequeable<Integer> goodD = new Deque<>();
			
			try {
				
			for (int n = 0; n < 10; n++) {
				goodD.insertLeft(n);
			}
			
			for (int n = 0; n < 12; n++) {
				goodD.removeLeft();
			}
			
			} catch (Exception e) {
				Assert.fail("Removing from the left is throwing an exception when you remove more elements that were in the list");
			}
		}
	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void insertWorks() { 
		
			Deque<Integer> d = new Deque<>();
			List<Integer> arr = new ArrayList<>();
			d.insertRight(5);
			d.insertLeft(29);
			d.insertLeft(27);
			d.insertRight(12);
			d.removeLeft();
			assertTrue(d.toArray().equals(Arrays.asList(29,5,12)));
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void removeLeftandpeekRight_performedInThatOrder_NoExceptions() {
		Dequeable<Integer> donQuixote = new Deque<Integer>();
		
		donQuixote.insertLeft(0);
		donQuixote.removeLeft();
		
		assertTrue(donQuixote.peekRight() == null);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void removeRightandpeekLeft_performedInThatOrder_NoExceptions() {
		Dequeable<Integer> dominos = new Deque<Integer>();
		
		dominos.insertRight(0);
		dominos.removeRight();
		
		assertTrue(dominos.peekLeft() == null);
	}
    
}