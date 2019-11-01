package test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Data;
import model.PriorityQueue;


class TestHeap {

	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void test_Clear() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.enqueue(new Data<>(12, 5));
		pq.enqueue(new Data<>(4, 1));
		pq.enqueue(new Data<>(45, 2));
		pq.enqueue(new Data<>(1, 8));
		pq.clear();
		
		assertTrue(pq.getSize() == 0);
	}
	
	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void test_getSize() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.enqueue(new Data<>(12, 5));
		pq.enqueue(new Data<>(4, 1));
		pq.enqueue(new Data<>(45, 2));
		pq.enqueue(new Data<>(1, 8));
		
		assertTrue(pq.getSize() == 4);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void insert_NullItem_SilentlyRefuse() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.enqueue(null);
		
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void insert_ItemWithNullValue_SilentlyRefuse() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Data<Integer> d = new Data<>(null, 1);
		
		pq.enqueue(d);
		
		assertTrue(pq.getSize() == 0);
	}

	/**
	 * @author Josiah Falukos
	 */
	@Test
	public void removeMethod_removesInCorrectOrder() {
		PriorityQueue<String> pq = new PriorityQueue<>();

		try {
			pq.enqueue(new Data<>("Hi, I'm Dakota", 10));
			pq.enqueue(new Data<>("Hi, I'm Josiah", 1));
		} catch (Exception e) {
			Assert.fail("Enqueue is not working properly");
		}

		assertTrue(pq.dequeue().getValue() == "Hi, I'm Josiah");

	}
	
	/**
	 * @author Josiah Falukos
	 */
	@Test
	public void getSizeMethod_AccountsForClear() {
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		try {
			pq.enqueue(new Data<>("Hi, I'm Josiah", 1));
		} catch (Exception e) {
			Assert.fail("Enqueue is not working properly");
		}
		
		pq.clear();
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Ashton R. Collins
	 */
	@Test
	public void testDequeue() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		try {
		pq.enqueue(new Data<>(2, 5));
		pq.enqueue(new Data<>(4, 1));
		pq.enqueue(new Data<>(5, 2));
		pq.enqueue(new Data<>(1, 3));
		pq.enqueue(new Data<>(3, 4));
		
		} catch(Exception e) {
			Assert.fail("Enqueue is not working correctly");
		}
		
		assertTrue(pq.dequeue().getValue() == 4);
		
	}

	/**
	 * @author Ashton R. Collins
	 */
	@Test
	public void testNullDequeue() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		assertTrue(pq.dequeue() == null);
	
	}	
	
	/**
	 * @author Kaleb Johnson
	 * Tests to ensure that removing from an empty priority queue does not affect its size.
	 */
	@Test
	public void DequeueFromEmptyPriorityQueue_NoSizeChange() {
		PriorityQueue<Integer> jacobyBrissett = new PriorityQueue<>();
		jacobyBrissett.dequeue();
		assertTrue(jacobyBrissett.getSize() == 0);
	}
	
	/**
	 * @author Kaleb Johnson
	 * Tests to ensure that the size of the priority queue changes appropriately with dequeue.
	 */
	@Test
	public void getSizeMethod_AccountsforDequeue() {
		PriorityQueue<Integer> mahomesIsHurt = new PriorityQueue<>();
		mahomesIsHurt.enqueue(new Data<>(1,1));
		mahomesIsHurt.enqueue(new Data<>(2,2));
		mahomesIsHurt.enqueue(new Data<>(3,4));
		mahomesIsHurt.dequeue();
		assertTrue(mahomesIsHurt.getSize() == 2);
	}
	
	/**
	 * @author Nolan Perez
	 */
	@Test
	public void testEnqueueRefusesPriorityZero() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.enqueue(new Data<>(2, 0));
		
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Nolan Perez
	 */
	@Test
	public void testGetSizeAfterClearAndAddingNewData() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.enqueue(new Data<>(1, 1));
		pq.enqueue(new Data<>(2, 3));
		pq.enqueue(new Data<>(5, 7));
		
		pq.clear();
		
		pq.enqueue(new Data<>(1, 1));
		pq.enqueue(new Data<>(3, 3));
		
		assertTrue(pq.getSize() == 2);
	}
	
		/**
	 * @author Seokwoo Ha
	 * This test validates the priority range.
	 */
	@Test
	void testPriorityRange() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.enqueue(new Data<>(1, 11));
		pq.enqueue(new Data<>(7, 0));
		pq.enqueue(new Data<>(2, -1));
		
		assertTrue(pq.getSize() == 0);
	}
	
	/**
	 * @author Seokwoo Ha
	 * This test checks if the default value of getSize() is 0.
	 */
	@Test
	void testGetSizeDefualt() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		assertTrue(pq.getSize() == 0);
	}
}