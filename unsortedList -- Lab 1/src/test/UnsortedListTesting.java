package test;

import model.UnsortedList;

public class UnsortedListTesting {
	/**
	 * @author cberkstresser
	 */
	@Test
	public void constantMaxSizeRemainsConstant() {
		UnsortedList ul = new UnsortedList();
		int maxSize = UnsortedList.MAX_SIZE;
		for (int n = 0; n <= UnsortedList.MAX_SIZE; ++n) { // insert one 1 too many
			ul.insert(1);
		}
		assertTrue(UnsortedList.MAX_SIZE == maxSize);
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	public void deleteFromEmptyList() {
		try {
			UnsortedList ul = new UnsortedList();
			ul.delete(55);
			ul.delete(-5);
			ul.delete(1000);
			ul.delete(-2_147_483_648);
			ul.delete(2_147_483_647);
			assertTrue(ul.getSizeOfList() == 0);
		} catch (Exception e) {
			Assert.fail("List isn't handling deleting from an empty list");
		}
	}

	/**
	* @author cberkstresser 
	*/
	@Test
	public void findAnExistingItem() {
		UnsortedList ul = new UnsortedList();
		ul.insert(1);
		assertTrue(ul.find(1)==0);
	}

	/**
	* @author cberkstresser 
	*/
	@Test
	public void findAllExistingItems() {
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(1);
		ul.insert(2);
		ul.insert(1);
		assertTrue(Arrays.equals(ul.findAll(1), new int[] {0,2}));
	}

	/**
	 * @author Kaleb Johnson
	 */
	@Test
	public void insertIntoFullList() {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(true); //added by Caleb Stucky.
		for (int n = 0; n <= UnsortedList.MAX_SIZE; n++) {
			ul.insert(2);
		}
		assertTrue(ul.getSizeOfList() == UnsortedList.MAX_SIZE);
	}

		/**
	 * @author Seokwoo Ha
	 */
	@Test
	public void findFromEmptyList() {
		try {
			UnsortedList ul = new UnsortedList();
			
			ul.insert(-1_234_623_117);
			assertTrue(ul.find(-1_234_623_117) == 0);
		} catch (Exception e) {
			Assert.fail("List isn't handling finding from an empty list");
		}
	}

	/**
	 * @author Tanner Maasen
	 */
	@Test
	public void findValueNotFound() {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(1);
		ul.insert(2);
		ul.insert(4);
		ul.insert(5);
		ul.find(3);
		//true if array has dups
		assertTrue(ul.find(3) == -1);	
	}

	/**
	 * @author Kaleb Johnson
	 */
	@Test
	public void checkDuplicatesAllowed() {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		assertTrue(ul.areDuplicatesAllowed() == true);
	}

	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void insertDuplicatesWithoutAllowingDuplicates() {
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(false);
		ul.insert(1);
		ul.insert(1);
		ul.insert(1);
		assertTrue(ul.getSizeOfList() == 1);
	}

	/**
	 * @author Tanner Maasen
	 */
	@Test
	public void initializeRandomCorrectSizeWithDups() {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(true); //Edit by Caleb Stucky. This best tests the scenario. Especially for larger numbers.
		ul.initializeWithRandomData(UnsortedList.MAX_SIZE);
		assertTrue(ul.getSizeOfList() == UnsortedList.MAX_SIZE);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void checkDeleteAll() {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(1);
		for (int n = 1; n < ul.MAX_SIZE - 1; n++) {
			ul.insert(2);
		}
		ul.insert(3);
		ul.deleteAll(2);
		assertTrue(ul.toString().equals("[1, 3]"));
	}

	/**
	 * @author Caleb Stucky
	 */
	//This is kind of a specialty test. I doubt Mr. Berkstresser will be testing on this, but it's a good concept to incorporate if you have time.
	@Test
	public void checkAgainstChangeDuplicatesAllowedMidRun() {
		//We should not allow the user to change to duplicates allowed if they already have an array with duplicates.
		// Ian Berkstresser - I just programmed the list so it would only allow setting the duplicates allowed option once; I figure this will prevent confusion in some cases.
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(3);
		ul.insert(1);
		ul.insert(3);
		ul.setDuplicatesAllowed(false);
		assertTrue(ul.areDuplicatesAllowed() == true); //Edited by Tanner. If we should not allow them to change mid-run, we want the areDupsAllowed method to == true
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testClear() {
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(false);
		ul.insert(1);
		ul.insert(2);
		ul.insert(3);
		ul.clear();
		assertTrue(ul.toString().equals("[]"));
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void initializeRandomCorrectSizeWithoutDups() {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(false);
		ul.initializeWithRandomData(ul.MAX_SIZE - 1);
		assertTrue(ul.getSizeOfList() == ul.MAX_SIZE - 1);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testInsert() {
		Listable ul = new UnsortedList();
		ul.insert(55);
		ul.insert(88);
		ul.insert(2);
		assertTrue(ul.toString().equals("[55, 88, 2]"));
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void checkSizeOfListAfterDeletion() {
		Listable ul = new UnsortedList();
		ul.insert(55);
		ul.insert(20);
		ul.insert(30);
		ul.delete(20);
		assertTrue(ul.getSizeOfList() == 2);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void checkSizeOfListWhenValueToDeleteDidNotExist() {
		Listable ul = new UnsortedList();
		ul.insert(55);
		ul.insert(20);
		ul.insert(30);
		ul.delete(40);
		assertTrue(ul.getSizeOfList() == 3);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void checkSizeOfListAfterDeletionWithDups() {
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(55);
		ul.insert(20);
		ul.insert(20);
		ul.insert(30);
		ul.deleteAll(20);
		assertTrue(ul.getSizeOfList() == 2);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void checkSizeOfListWhenValueToDeleteDidNotExistWithDups() {
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(55);
		ul.insert(20);
		ul.insert(20);
		ul.insert(30);
		ul.deleteAll(40);
		assertTrue(ul.getSizeOfList() == 4);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testFind() {
		Listable ul = new UnsortedList();
		ul.insert(55);
		ul.insert(20);
		ul.insert(30);
		assertTrue(ul.find(30) == 2);
	}
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void testFindAll() {
		Listable ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(55);
		ul.insert(20);
		ul.insert(20);
		ul.insert(30);
		assertTrue(Arrays.equals(ul.findAll(20), new int[] {1, 2}));
	}
	
	//Caleb Stucky: Everyone, feel free to make multiple test cases for each method. The more the better.
		
		
	/**
	 * @author Bradley Stout
	 */
	@Test
	public void checkDelete() {
		try {
			UnsortedList ul = new UnsortedList();
			ul.setDuplicatesAllowed(false);
			ul.insert(9);
			ul.delete(9);
			assertTrue(ul.getSizeOfList()==0);
		} catch (Exception e) {
			Assert.fail("List is not handling deleting");
		}
	}
	/**
	 * @author Bradley Stout
	 */
	@Test
	public void deleteAtEndOfList() {
		try {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(true);
		ul.insert(2);
		ul.insert(6);
		ul.delete(6);
		assertTrue(ul.find(6) == -1);//value should not be found. insert own fail condition if need be -Bradley
		} catch (Exception e) {
			Assert.fail("List is not handling deleting at the end of the list");
		}
	}
	/**
	 * This test tries the find and findAll methods when no values have been entered
	 * into list.
	 * 
	 * @author Josiah Falukos
	 */
	@Test
	public void findInEmptyList() {
		try {
			UnsortedList ul = new UnsortedList();
			ul.find(9);
			ul.find(7);
			ul.find(234);
		} catch (Exception e) {
			Assert.fail("List isn't handling find in an empty list");
		}
		try {
			UnsortedList ul = new UnsortedList();
			ul.findAll(9);
			ul.findAll(7);
			ul.findAll(234);
		} catch (Exception e) {
			Assert.fail("List isn't handling findAll in an empty list");
		}
	}

	/**
	 * This test checks the clear method to confirm the list is erased by setting
	 * pointer is set to zero.
	 * 
	 * @author Josiah Falukos
	 */
	@Test
	public void clearMethodTest() {
		UnsortedList ul = new UnsortedList();
		ul.insert(4);
		ul.insert(3);
		ul.insert(7);
		ul.insert(4);
		ul.clear();
		assertTrue(ul.getSizeOfList() == 0);
	}

	/**
	* @author Ashton R. Collins 
	*/
	@Test
	public void testSwapDelete() {
		UnsortedList ul = new UnsortedList();
		ul.insert(2);
		ul.insert(7);
		ul.insert(9);
		ul.insert(3);
		ul.delete(7);
		assertTrue(ul.getSizeOfList()==3);
	}
	
	/**
	 * @author Nolan Perez
	 */
	@Test
	public void confirmListSize() {
		try {
			UnsortedList ul = new UnsortedList();
			ul.setDuplicatesAllowed(true); //Edit by Tanner. You never set duplicates to true and you need that since you insert duplicates
			ul.insert(3);
			ul.insert(3);
			ul.insert(3);
			ul.insert(3);
			assertTrue(ul.getSizeOfList() == 4);
		} catch (Exception e) {
			Assert.fail("List is not proper size");
		}
	}
	
	/**
	 * @author Nolan Perez
	 */
	@Test
	public void checkFindAllAccuracyDespiteOrder() {
		UnsortedList ul = new UnsortedList();
		String findIt;
		ul.insert(5);
		ul.insert(5);
		ul.insert(3);
		ul.insert(2);
		ul.insert(5);
		findIt = Arrays.toString(ul.findAll(5));
//		findIt.contains("4");
//		findIt.contains("0");
//		findIt.contains("1");
//		assertTrue(findIt.contains("0") && findIt.contains("1") && findIt.contains("4"));
	}
}
