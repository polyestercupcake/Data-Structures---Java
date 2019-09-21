package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Listable;
import model.MoreListable;
import model.SortedList;
import model.UnsortedList;

class UnsortedListTesting {
	/**
	 * @author cberkstresser
	 */
	@Test
	void insertRespectsOrder() {
		MoreListable sl = new SortedList();
		sl.insert(1);
		sl.insert(10);
		sl.insert(5);
		assertTrue(Arrays.equals(new int[] { 1, 5, 10 }, sl.getValues()));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void initializeRespectsSortedProperty() {
		//fill list to full
		MoreListable sl = new SortedList();
		sl.initializeWithRandomData(SortedList.MAX_SIZE);
		//make a copy of the values and sort them to compare.
		int[] sortedValues = sl.getValues().clone();
		Arrays.sort(sortedValues);
		//our sorted values should agree with java's.
		assertTrue(Arrays.equals(sl.getValues(), sortedValues));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void beerSortStaysInRange() {
		SortedList sl = new SortedList();
		sl.insert(10);
		sl.beerSort();
		// make sure beersort didn't sort any trailing zeros into the list
		assertTrue(sl.getValues()[0] == 10);
	}

	/**
	 * @author Tanner Maasen
	 */
	@Test
	void deleteRespectsSortedProperty() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(5);
		sl.insert(4);
		//deletes the 4
		sl.delete(4);
		sl.insert(56);
		sl.insert(8);
		sl.insert(10);
		sl.insert(1);
		//insert method should already have them sorted when they are inserted
		int[] arr = sl.getValues().clone();
		Arrays.sort(arr);
		assertTrue(Arrays.equals(arr, sl.getValues()));
	}
	
	/**
	 * @author Tanner Maasen
	 */
	@Test
	void checkFindInSortedList() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(4);
		sl.insert(1);
		sl.insert(7);
		sl.insert(2);
		sl.insert(8);
		//should be sorted into [1,2,4,7,8]
		assertTrue(sl.find(2)==1);
	}

	/**
	 * @author Tanner Maasen
	 */
	@Test
	void checkFindAllInSortedList() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(4);
		sl.insert(1);
		sl.insert(1);
		sl.insert(1);
		sl.insert(7);
		sl.insert(2);
		sl.insert(8);
		//should be sorted into [1,1,1,2,4,7,8]
		assertTrue(Arrays.equals(sl.findAll(1), new int[] {0,1,2}));
	}

		/**
	* @author Ashton R. Collins
	*/
	@Test
	void CheckInsertNoDuplicate() {
		// Ian - I like this indention technic, it's easier to read with the variables the same indention level as the method.
			//Arc - Thank you. I think so as well.
	MoreListable sl = new SortedList();
			sl.setDuplicatesAllowed(false);
			sl.insert(2);
			sl.insert(7);
			sl.insert(9);
			sl.insert(7);
			sl.insert(3);
			sl.insert(4);
		assertTrue(Arrays.equals(sl.getValues(), new int[]{ 2,3,4,7,9 }));
	}

	// Ian: These tests probably didn't run because I forgot the @Test annotation. Rerunning the unit tests will be necessary if you have not already

	/**
	 * @author Ian Berkstresser
	 */
	@Test
	public void itcInsertIgnoreDups() {
		MoreListable sl = new SortedList(); // Make a new SortedList
		sl.insert(5); // Insert bigger number first
		sl.insert(2); // Insert smaller number
		assertTrue(Arrays.equals(sl.getValues(), new int[] { 2, 5 })); // See if it fixed the ordering
		assertTrue(sl.getSizeOfList() == 2); // See if the size method is correct
	}

	/**
	 * @author Ian Berkstresser
	 */
	@Test
	public void itcInsertWithDups() {
		MoreListable sl = new SortedList(); // Make a new SortedList
		sl.setDuplicatesAllowed(true); // Allow duplicates
		sl.insert(4); // Insert number
		sl.insert(4); // Insert same number
		assertTrue(Arrays.equals(sl.getValues(), new int[] { 4, 4 })); // See if it allowed duplicates
	}

	/**
	 * @author Ian Berkstresser
	 */
	@Test
	public void itcInsertWithNoDups() {
		MoreListable sl = new SortedList(); // Make a new SortedList
		sl.setDuplicatesAllowed(false); // Disallow duplicates
		sl.insert(4); // Insert number
		sl.insert(4); // Insert same number
		assertTrue(Arrays.equals(sl.getValues(), new int[] { 4 })); // See if it did not allow duplicates
	}

	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testClear() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.insert(1);
		sl.insert(2);
		sl.insert(3);
		sl.clear();
		assertTrue(Arrays.equals(sl.getValues(), new int[] {}));
		assertTrue(sl.getSizeOfList() == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void initializeRandomCorrectSizeWithoutDups() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.initializeWithRandomData(SortedList.MAX_SIZE - 1);
		assertTrue(sl.getSizeOfList() == SortedList.MAX_SIZE - 1);
	}
	/**
	 * @author Dakota Johnson
	 */
	@Test
	public void initializeWithRandomDataIsSorted() {
		int valueAtZero;
		int valueAtOne;
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.initializeWithRandomData(5);
		valueAtZero = sl.getValues()[0];
		valueAtOne = sl.getValues()[1];
		assertTrue(valueAtZero < valueAtOne);
		}
	/**
	 * @author Dakota Johnson
	 */
	@Test
	public void checkFindOnAClearedArray() {
		MoreListable sl = new SortedList();
		sl.clear();
		assertTrue(sl.find(1) == -1);
	}

	/**
	 * @author Seokwoo Ha
	 * Check if the insert function sorts well by checking the first element.
	 */
	@Test
	void checkTheInsertFunctionsWellByCheckingTheFirstElement() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(5);
		sl.insert(11);
		sl.insert(3);
		sl.insert(87);
		sl.insert(23);
		assertTrue(sl.getValues()[0] == 3);
	}

	/**
	 * @author Seokwoo Ha
	 * Check if the insert function sorts well with duplicates not allowed by checking the third element.
	 */
	@Test
	void insertDupsNotAllowed() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.insert(5);
		sl.insert(5);
		sl.insert(11);
		sl.insert(3);
		sl.insert(87);
		sl.insert(23);
		//should be ordered: 3, 5, 11, 23, 87
		assertTrue(sl.getValues()[2] == 11);
	}

	// Ian: I entered down the "Insert into full list" part because it was on the author tag, "@author Josiah Falukos Insert into full list"
	/**
	 * @author Josiah Falukos
	 *  Insert into full list
	 */
	@Test
	public void insertIntoFullList() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		int n = 0;
		while (n <= SortedList.MAX_SIZE) {
			sl.insert(4);
			n++;
		}
		assertTrue(sl.getSizeOfList() == SortedList.MAX_SIZE);
	}

	/**
	 * @author Josiah Falukos 
	 * 	This test verifies delete() works correctly and that the
	 *         programmer isn't using -1 as a magic number.
	 */
	@Test
	public void delete() {
		MoreListable sl = new SortedList();
		sl.insert(-1);
		sl.delete(-1);
		sl.insert(7);
		assertTrue(sl.getSizeOfList() == 1);

	}

	/**
	 * @author Kaleb Johnson
	 * Check to make sure setting duplicates allowed or not allowed is actually working correctly.
	 * P.S.: I realize this is almost the exact same test case from TestUnsortedList;
	 * however, I feel it's important to still test basic functionality in a sorted list
	 * as much as it is in an unsorted list.
	 */
	@Test
	public void checkDuplicatesAllowedStatus() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		assertTrue(sl.areDuplicatesAllowed() == true);
	}

	/**
	 * @author Kaleb Johnson
	 * Verify that if the value being searched is not found, -1 is returned (i.e., we don't
	 * get a bunch of red pukey garbage...or an exception!)
	 */
	@Test
	public void checkFindIfValueNotFound() {
		MoreListable sl = new SortedList();
		sl.insert(3);
		sl.find(1);
		assertTrue(sl.find(1) == -1);
	}

	/**
	* @author Ashton R. Collins
	*/
	//This was changed due to some errors found in the code, I apologize if this gave you problems.
	@Test
	void DeleteAllDuplicatesCheck() {
		MoreListable sl = new SortedList();
				sl.setDuplicatesAllowed(true);
				sl.insert(2);
				sl.insert(7);
				sl.insert(9);
				sl.insert(7);
				sl.insert(7);
				sl.deleteAll(7);
	assertTrue(Arrays.equals(sl.getValues(), new int[]{ 2,9 }));
	
	}

		/**
	 * @author Cameron McGeorge
	 */
	@Test
	void checkFind() {
		MoreListable sl = new SortedList();
		
		sl.setDuplicatesAllowed(true);
		sl.insert(5);
		sl.insert(6);
		sl.insert(8);
		sl.insert(3);
		sl.insert(2);
		assertTrue(sl.getValues()[2] == 5);
	}
	
	/**
	 * @author Cameron McGeorge
	 */
	//Edit by Caleb Stucky: since this is a sorted list, the 2 will be at position 0 not 1 (like the original test was written).
	@Test
	void checkFindAllNoDuplicates() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.clear();
		sl.insert(5);
		sl.insert(5);
		sl.insert(2);
		assertTrue(sl.getValues()[0] == 2);
	}
	
	/** 
	 * @author Ethan
	 */
	public void insertDeleteAll() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(30);
		sl.insert(43);
		sl.insert(99);
		sl.insert(2);
		sl.insert(45);
		sl.insert(43);
		sl.deleteAll(43);
		assertTrue(sl.getSizeOfList() == 4);
	}
	/** 
	 * @author Ethan
	 */
	public void randomData() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		int sizeOfData = 10;
		sl.initializeWithRandomData(sizeOfData);
		
		assertTrue(sl.getSizeOfList() == sizeOfData);
	}
	/**
	 * Tests if the list sorts in reverse order (largest to smallest).
	 * Passes if the list DOES sort in reverse order.
	 * @author Bradley Stout
	 */
	/* Edit by Caleb Stucky: Commented out
	 // Edit by Josiah: This test is not necessary. We are ONLY sorting in ascending order.
	@Test
	public void testReverseSort() {
		MoreListable sl = new SortedList();
		sl.insert(3);
		sl.insert(5);
		sl.insert(9);
		assertTrue(Arrays.equals(new int[] { 9, 5, 3 }, sl.getValues()));
	}
	*/
	/**
	 * @author Bradley Stout
	 */
	@Test
	public void testListRemainsSorted() {
		MoreListable sl = new SortedList();
		sl.insert(4);
		sl.insert(8);
		sl.insert(10);
		sl.delete(8);
		sl.insert(1);
		sl.insert(6);
		assertTrue(Arrays.equals(new int[] { 1, 4, 6, 10}, sl.getValues()));
	}

	// Ian: This will probably fail for some people, since on UnsortedList there were unit tests to check if duplicatesAllowed was not allowed to change in the presence of duplicates.
	/**
	 * @author Nolan Perez
	 * Checks for ability to change the duplicates boolean mid program execution.
	 */
	 /*
	 Commented out: by Berkstresser
	public void checkChangedPermissions() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(2);
		sl.insert(5);
		sl.insert(7);
		sl.insert(2);
		sl.setDuplicatesAllowed(false);
		sl.insert(2);
		sl.insert(2);
		assertTrue(sl.areDuplicatesAllowed() == false);
		assertTrue(Arrays.equals(sl.getValues(), new int[]{ 2,2,5,7 }));
	}*/
	/**
	 * @author Nolan Perez
	 * Checks for clean transition from clear() to starting a new list.
	 */
	public void checkClearFollowedByNewList() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(1);
		sl.insert(7);
		sl.insert(9);
		sl.insert(4);
		sl.insert(2);
		sl.clear();
		sl.insert(8);
		sl.insert(5);
		sl.insert(3);
		assertTrue(Arrays.equals(sl.getValues(), new int[]{ 3,5,8 }));
	}

	/** @author RyanCornelius
	 *	Tests if the list is ordered from least to greatest.
	 */
	//Edit by Caleb Stucky: I believe we usually don't put sysouts in test cases.
	@Test
	public void testIsLeastToGreatest() {
		//System.out.println("TEST: testIsLeastToGreatest initialized.");
		try {
			MoreListable sl = new SortedList();
			sl.insert(5);
			sl.insert(10);
			sl.insert(15);
			assertTrue(Arrays.equals(new int[] {5, 10, 15}, sl.getValues()));
			//System.out.println("Success: List is ordered least to greatest.");
		} catch (Exception e) {
			Assert.fail("FAIL: List is not ordered least to greatest.");
		}
	}

	/** @author RyanCornelius
	 *	Tests if the list is ordered from greatest to least.
	 */
	 // Edit by Josiah: This test is not necessary. We are ONLY sorting in ascending order.
	/* Edit by Caleb Stucky: commented out
	@Test
	public void testIsGreatestToLeast() {
		System.out.println("TEST: testIsGreatestToLeast initialized.");
		try {
			MoreListable sl = new SortedList();
			sl.insert(15);
			sl.insert(10);
			sl.insert(5);
			assertTrue(Arrays.equals(new int[] {15, 10, 5}, sl.getValues()));
			System.out.println("Success: List is ordered greatest to least.");
		} catch (Exception e) {
			Assert.fail("FAIL: List is not ordered greatest to least.");
		}
	}
	*/
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void findIncludesTheFirstNumber() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.insert(1);
		sl.insert(2);
		assertTrue(sl.find(1) == 0);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	//Use this with a grain of salt. If you don't understand it, just comment it out.
	//Here's the logic:
	//since the pointer is at 4, binary search would look at index 2 first so it would return 2.
	//however, searching from beginning to end would find the 2 in index 1 first and return 1.
	@Test
	public void makeSureYouUseBinaryFind() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(1);
		sl.insert(2);
		sl.insert(2);
		sl.insert(3);
		assertTrue(sl.find(2) == 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void findAllIndexOutOfBoundsBeginning() {
		try {
			MoreListable sl = new SortedList();
			sl.insert(10);
			sl.insert(10);
			sl.insert(10);
			sl.insert(5);
			sl.insert(5);
			sl.findAll(5);
		} catch (IndexOutOfBoundsException e) {
			fail("Your find all code is looking before the beginning of the array.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void findAllIndexOutOfBoundsEnd() {
		try {
			MoreListable sl = new SortedList();
			sl.setDuplicatesAllowed(true);
			sl.insert(10);
			sl.insert(10);
			sl.insert(10);
			sl.insert(5);
			sl.insert(5);
			sl.findAll(10);
		} catch (IndexOutOfBoundsException e) {
			fail("Your find all code is looking after the end of the array.");
		}
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testInsertRespectsDupsNotAllowed() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.insert(5);
		sl.insert(5);
		sl.insert(5);
		assertTrue(sl.getSizeOfList() == 1);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testInsertRespectsDupsNotAllowedAndOrdered() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(false);
		sl.insert(1);
		sl.insert(4);
		sl.insert(1);
		sl.insert(2);
		assertTrue(Arrays.equals(sl.getValues(), new int[] {1, 2, 4}));
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testInsertOrderedWithDups() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(1);
		sl.insert(4);
		sl.insert(28);
		sl.insert(4);
		sl.insert(4);
		assertTrue(Arrays.equals(sl.getValues(), new int[] {1, 4, 4, 4, 28}));
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void insertDoesNotInsertPastMaxSize() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		for (int n = 0; n <= SortedList.MAX_SIZE; n++) {
			sl.insert(1);
		}
		sl.insert(1);
		assertTrue(sl.getSizeOfList() == SortedList.MAX_SIZE);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testDeleteItemDoesNotExist() {
		MoreListable sl = new SortedList();
		sl.delete(1);
		assertTrue(sl.getSizeOfList() == 0);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void deleteOnlyDeletesOneNumber() {
		MoreListable sl = new SortedList();
		sl.setDuplicatesAllowed(true);
		sl.insert(1);
		sl.insert(1);
		sl.insert(1);
		sl.delete(1);
		assertTrue(sl.getSizeOfList() == 2);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void deleteShiftsNumbersOver() {
		MoreListable sl = new SortedList();
		sl.insert(3);
		sl.insert(8);
		sl.insert(4);
		sl.insert(1);
		sl.insert(7);
		sl.delete(3);
		assertTrue(Arrays.equals(sl.getValues(), new int[] {1, 4, 7, 8}));
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void deleteDeletesFirstNumber() {
		MoreListable sl = new SortedList();
		sl.insert(1);
		sl.insert(2);
		sl.insert(3);
		sl.delete(1);
		assertTrue(Arrays.equals(sl.getValues(), new int[] {2, 3}));
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void deleteDeletesLastNumber() {
		MoreListable sl = new SortedList();
		sl.insert(3);
		sl.insert(5);
		sl.insert(2);
		sl.delete(5);
		assertTrue(Arrays.equals(sl.getValues(), new int[] {2, 3}));
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void findAllNothingToFind() {
		MoreListable sl = new SortedList();
		assertTrue(Arrays.equals(sl.findAll(1), new int[] {}));
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void findNothingToFind() {
		MoreListable sl = new SortedList();
		assertTrue(sl.find(1) == -1);
	}

}