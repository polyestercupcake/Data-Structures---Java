package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Data;
import model.Heap;
import model.Heapable;
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

		} catch (Exception e) {
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
	 * @author Kaleb Johnson Tests to ensure that removing from an empty priority
	 *         queue does not affect its size.
	 */
	@Test
	public void DequeueFromEmptyPriorityQueue_NoSizeChange() {
		PriorityQueue<Integer> jacobyBrissett = new PriorityQueue<>();
		jacobyBrissett.dequeue();
		assertTrue(jacobyBrissett.getSize() == 0);
	}

	/**
	 * @author Kaleb Johnson Tests to ensure that the size of the priority queue
	 *         changes appropriately with dequeue.
	 */
	@Test
	public void getSizeMethod_AccountsforDequeue() {
		PriorityQueue<Integer> mahomesIsHurt = new PriorityQueue<>();
		mahomesIsHurt.enqueue(new Data<>(1, 1));
		mahomesIsHurt.enqueue(new Data<>(2, 2));
		mahomesIsHurt.enqueue(new Data<>(3, 4));
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
	 * @author Seokwoo Ha This test validates the priority range.
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
	 * @author Seokwoo Ha This test checks if the default value of getSize() is 0.
	 */
	@Test
	void testGetSizeDefualt() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		assertTrue(pq.getSize() == 0);
	}

	/**
	 * @author Tanner Maasen
	 * @author Caleb Stucky Note: I'm claming co-authorship because I edited this in
	 *         an essential way.
	 */
	@Test
	public void insert_MultipleValues_SortsPrioritiesCorrectly() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int[] values = new int[2];
		int[] priorities = new int[2];
		int[] expectedValues = new int[] { 4, 12 };
		int[] expectedPriorities = new int[] { 1, 5 };

		pq.enqueue(new Data<>(12, 5));
		pq.enqueue(new Data<>(4, 1));
		for (int n = 0; n < 2; n++) {
			Data<Integer> d = pq.dequeue();
			values[n] = d.getValue();
			priorities[n] = d.getPriority();
		}

		for (int n = 0; n < 2; n++) {
			if (values[n] != expectedValues[n] || priorities[n] != expectedPriorities[n]) {
				Assert.fail("Your priority queue is not sorting priorities in the right order.");
			}
		}
	}

	@Test
	/**
	 * @author Tanner Maasen
	 */
	void testClear() {
		Heapable<Integer> heap = new Heap<>();
		heap.insert(new Data<>(12, 5));
		heap.insert(new Data<>(4, 1));
		heap.insert(new Data<>(45, 2));
		heap.insert(new Data<>(1, 8));
		heap.clear();

		assertTrue(heap.getSize() == 0);
	}

	@Test
	/**
	 * @author Tanner Maasen
	 */
	void testGetSize() {
		Heapable<Integer> heap = new Heap<>();
		heap.insert(new Data<>(12, 5));
		heap.insert(new Data<>(4, 1));
		heap.insert(new Data<>(45, 2));
		heap.insert(new Data<>(1, 8));

		assertTrue(heap.getSize() == 4);
	}

	/**
	 * @author Kaleb Johnson Tests to ensure removing from an empty heap returns
	 *         null.
	 */
	@Test
	public void testRemoveFromEmptyHeap_ReturnsNull() {
		Heapable<Integer> heapOfTrouble = new Heap<>();
		assertTrue(heapOfTrouble.remove() == null);
	}

	/**
	 * @author Kaleb Johnson Tests to ensure removing from a heap not empty
	 *         appropriately affects size.
	 */
	@Test
	public void testRemoveFromHeapNotEmpty_ProperlyChangesSize() {
		Heapable<Integer> papaHeap = new Heap<>();
		papaHeap.insert(new Data<>(2, 7));
		papaHeap.insert(new Data<>(5, 1));
		papaHeap.insert(new Data<>(5, 3));
		papaHeap.insert(new Data<>(4, 8));
		papaHeap.remove();

		assertTrue(papaHeap.getSize() == 3);
	}

	/**
	 * @author Dakota Johnson Test to make sure priorities inserted not within
	 *         designated priority range are not inserted.
	 */
	@Test
	public void testPriorityInsertedOutsidePriorityBounds() {
		Heapable<Integer> sheap = new Heap<>();
		sheap.insert(new Data<>(2, 11));
		assertTrue(sheap.getSize() == 0);
	}

	/**
	 * @author Dakota Johnson Test to make sure heap correctly inserts data with the
	 *         same priority and value.
	 */
	@Test
	public void testInsertWithSamePriorityAndValue() {
		Heapable<Integer> sheap = new Heap<>();
		sheap.insert(new Data<>(1, 1));
		sheap.insert(new Data<>(1, 1));
		sheap.insert(new Data<>(1, 1));
		sheap.insert(new Data<>(1, 1));
		assertTrue(sheap.getSize() == 4);
	}

	/**
	 * @author Seokwoo Ha This test validates the priority range.
	 */
	@Test
	void testPriorityRange1() {
		Heapable<Integer> heap = new Heap<>();
		heap.insert(new Data<>(1, 11));
		heap.insert(new Data<>(7, 0));
		heap.insert(new Data<>(2, -1));

		assertTrue(heap.getSize() == 0);
	}

	/**
	 * @author Seokwoo Ha This test checks if the default value of getSize() is 0.
	 */
	@Test
	void testGetSizeDefualt1() {
		Heapable<Integer> heap = new Heap<>();

		assertTrue(heap.getSize() == 0);
	}

	/**
	 * @author Ian Berkstresser
	 */
	@Test
	public void xv_insert_emptyList_noExceptions() {
		Heapable<Integer> heap = new Heap<Integer>();
		try {
			heap.insert(new Data<Integer>(10, 4));
		} catch (Exception e) {
			Assert.fail("insert() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser
	 */
	@Test
	public void xv_remove_emptyList_noExceptions() {
		Heapable<Integer> heap = new Heap<Integer>();
		try {
			heap.remove();
		} catch (Exception e) {
			Assert.fail("remove() is throwing an exception: " + e.getMessage());
		}
	}

	/**
	 * @author Ethan Hutchison
	 */
	@Test
	public void insert3000Times() {
		Heapable<Integer> heap = new Heap<Integer>();
		try {
			for (int x = 0; x <= 3000; x++)
				heap.insert(new Data<Integer>(x, 1));
		} catch (Exception e) {
			Assert.fail("somethig went...wrong." + e.getMessage());
		}
	}

	/**
	 * @author Ethan Hutchison
	 */
	@Test
	public void insert3000TimesThenRemove() {
		Heapable<Integer> heap = new Heap<Integer>();
		try {
			for (int x = 0; x <= 3000; x++)
				heap.insert(new Data<Integer>(x, 1));
			for (int x = 0; x <= 3000; x++)
				heap.remove();
			assertTrue(heap.getSize() == 0);
		} catch (Exception e) {
			Assert.fail("somethig went...wrong." + e.getMessage());
		}
	}

	/**
	 * @author Bradley Stout
	 */
	@Test
	void testInsertAndRemove() {
		Heapable<Integer> heap = new Heap<Integer>();
		Data<Integer> inserted = new Data<Integer>(6, 2);
		heap.insert(inserted);

		assertTrue(heap.remove() == inserted);
	}

	@Test
	/**
	 * @author Bradley Stout
	 */
	void testHeapDoesNotSortByValue() {
		Heapable<Integer> heap = new Heap<Integer>();

		heap.insert(new Data<Integer>(1, 10));
		heap.insert(new Data<Integer>(10, 5));

		assertTrue(heap.remove() != new Data<Integer>(1, 10));
	}
	
	@Test
    /**
	
	 * Fixing Berkstresser's mistake on sorting reversed.
     * @author cberkstresser
	 * @author Seokwoo
     */
    void testSortedStructure() {
       Heap<String> heap = new Heap<>();
		for (int n = 1; n <= 10; ++n) {
			heap.insert(new Data<String>("String " + n, n));
		}
		List<Data<String>> results = heap.removeAllIntoSortedList();
		List<Data<String>> sortedResults = new ArrayList<>(results);
		sortedResults.sort(Collections.reverseOrder());
		System.out.println(results);
		System.out.println(sortedResults);
    }

}
