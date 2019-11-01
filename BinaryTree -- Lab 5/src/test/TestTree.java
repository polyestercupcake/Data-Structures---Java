package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Tree;
import model.Treeable;

class TestTree {
	/**
	 * @author cberkstresser
	 */
	@Test
	void treeSizeWorksWithInsertDatesDegenerateLeftSidedTree() {
		Treeable<ChronoLocalDate> myTree = new Tree<>();
		for (int month = 12; month >= 1; --month) {
			myTree.insert(LocalDate.of(2019, month, 1));
		}
		assertTrue(myTree.getSize() == 12);
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void treeMinWorksWithInsertDatesDegenerateLeftSidedTree() {
		Treeable<ChronoLocalDate> myTree = new Tree<>();
		for (int month = 12; month >= 1; --month) {
			myTree.insert(LocalDate.of(2019, month, 1));
		}
		assertTrue(myTree.getMinValue().equals(LocalDate.of(2019, 1, 1)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void treeMaxWorksWithInsertDatesDegenerateLeftSidedsTree() {
		Treeable<ChronoLocalDate> myTree = new Tree<>();
		for (int month = 12; month >= 1; --month) {
			myTree.insert(LocalDate.of(2019, month, 1));
		}
		assertTrue(myTree.getMaxValue().equals(LocalDate.of(2019, 12, 1)));
	}
	/**
	 * @author cberkstresser
	 */
	@Test
	void treeSizeWorksWithInsertDatesDegenerateRightSidedTree() {
		Treeable<ChronoLocalDate> myTree = new Tree<>();
		for (int month = 1; month <= 12; ++month) {
			myTree.insert(LocalDate.of(2019, month, 1));
		}
		assertTrue(myTree.getSize() == 12);
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void treeMinWorksWithInsertDatesDegenerateRightSidedTree() {
		Treeable<ChronoLocalDate> myTree = new Tree<>();
		for (int month = 1; month <= 12; ++month) {
			myTree.insert(LocalDate.of(2019, month, 1));
		}
		assertTrue(myTree.getMinValue().equals(LocalDate.of(2019, 1, 1)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void treeMaxWorksWithInsertDatesDegenerateRightSidedTree() {
		Treeable<ChronoLocalDate> myTree = new Tree<>();
		for (int month = 1; month <= 12; ++month) {
			myTree.insert(LocalDate.of(2019, month, 1));
		}
		assertTrue(myTree.getMaxValue().equals(LocalDate.of(2019, 12, 1)));
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void treeSizeWorksWithInsertAndClear() {
		Treeable<Integer> myTree = new Tree<>();
		myTree.insert(5);
		myTree.insert(4);
		myTree.clear();
		myTree.insert(6);
		assertTrue(myTree.getSize() == 1);
	}

	/**
	 * @author cberkstresser
	 */
	@Test
	void treeSizeWorksWithInsertAllOneSide() {
		Treeable<Integer> myTree = new Tree<>();
		myTree.insert(4);
		myTree.insert(5);
		myTree.insert(6);
		myTree.insert(7);
		myTree.insert(8);
		assertTrue(myTree.getSize() == 5);
	}

	/**
	 * @implNote Edit by Kaleb Johnson: fixed capitalization and grammar because I'm
	 *           just that picky lol. Was originally ashton r collins.
	 * 
	 * @author Ashton R. Collins
	 */
	@Test
	void testMinValue() {
		Treeable<Integer> myTree = new Tree<>();

		myTree.insert(1);
		myTree.insert(3);
		myTree.insert(9);
		myTree.insert(7);
		myTree.insert(2);

		assertTrue(myTree.getMinValue() == 1);

	}

	/**
	 * @implNote Edit by Kaleb Johnson: fixed capitalization and grammar because I'm
	 *           just that picky lol. Was originally ashton r collins.
	 * 
	 * @author Ashton R. Collins
	 */
	@Test
	void testMaxValue() {
		Treeable<Integer> myTree = new Tree<>();

		myTree.insert(2);
		myTree.insert(7);
		myTree.insert(9);
		myTree.insert(3);
		myTree.insert(1);

		assertTrue(myTree.getMaxValue() == 9);

	}

	/**
	 * @author Bradley Stout
	 */
	@Test
	void testContains() {
		Treeable<Integer> tree = new Tree<>();
		tree.insert(2);
		tree.insert(5);
		tree.insert(8);
		assertTrue(tree.contains(2) == true);
	}

	/**
	 * @author Bradley Stout
	 */
	@Test
	void testRemove() {
		Treeable<Integer> tree = new Tree<>();
		tree.insert(4);
		tree.remove(4);
		assertTrue(tree.getSize() == 0);
	}

	/**
	 * @author Tanner Maasen
	 */
	@Test
	void findReturnsCorrectValue() {
		Treeable<Integer> tree = new Tree<>();
		tree.insert(4);
		tree.insert(1);
		tree.insert(15);
		tree.insert(11);
		assertTrue(tree.find(15).getValue() == 15);
	}

	/**
	 * @author Tanner Maasen
	 */
	@Test
	void testClear() {
		Treeable<Integer> tree = new Tree<>();
		tree.insert(4);
		tree.insert(3);
		tree.clear();
		assertTrue(tree.getSize() == 0);
	}

	/**
	 * Edit by Kaleb Johnson: fixed error with name. Originally was Dakota Johnson
	 * 
	 * @author Dakota Johnson
	 **/
	@Test
	void testGetMinValueOnEmptyTree() {
		Treeable<Integer> myTree = new Tree<>();
		myTree.getMinValue(); // Edit by Kaleb Johnson: was originally myTree.getMaxValue().
		assertTrue(myTree.getMinValue() == null); // Line added by Kaleb Johnson: method not complete without assertion.
	}

	/**
	 * Edit by Kaleb Johnson: fixed error with name. Originally was Dakota Johnson
	 * 
	 * @author Dakota Johnson
	 **/
	@Test
	void testMinAndMaxAreSameWhenSame() {
		Treeable<Integer> myTree = new Tree<>();
		myTree.insert(1);
		assertTrue(myTree.getMaxValue() == myTree.getMinValue());
	}

	/**
	 * Tests to verify that find returns null for value not found.
	 * 
	 * @author Kaleb Johnson
	 * @author Edited by Caleb Stucky. Johnson, you can't .getValue on a null item. That will always throw an exception.
	 */
	@Test
	void testFindForValueNotFound() {
		Treeable<Integer> yeetTree = new Tree<>();
		yeetTree.insert(6);
		yeetTree.find(5);
		assertTrue(yeetTree.find(5) == null);
	}

	/**
	 * Tests to ensure getSize is still accurate if remove does not find value to
	 * remove.
	 * 
	 * @author Kaleb Johnson
	 */
	@Test
	void testGetSizeForRemoveValueNotFound() {
		Treeable<Integer> golfIsAwesome = new Tree<>();
		golfIsAwesome.insert(2);
		golfIsAwesome.remove(5);
		assertTrue(golfIsAwesome.getSize() == 1);
	}

	/**
	 * Tests to ensure that an empty tree will return a size of 0, not null.
	 * 
	 * @author Kaleb Johnson
	 */
	@Test
	void testGetSizeForEmptyTree() {
		Treeable<Integer> blah = new Tree<>();
		blah.getSize();
		assertTrue(blah.getSize() == 0);
	}

	/**
	 * Makes sure removing from an empty tree doesnt cause an error, or cause
	 * getSize to return an incorrect size.
	 * 
	 * @author Ryan Cornelius
	 */
	@Test
	void testRemoveEmptyTree() {
		Treeable<Integer> t = new Tree<>();
		try {
			// If tree is empty already
			if (t.getSize() == 0) {
				t.remove(42);
				// Size should remain 0.
				assertTrue(t.getSize() == 0);
			} else {
				t.clear();
				t.remove(42);
				assertTrue("Size is 0.", t.getSize() == 0);
			}
		} catch (Exception e) {
			System.out.println("Remove is causing errors.");
		}
	}

	/**
	 * Makes sure getSize is 0 when tree is empty. It should not return a null value
	 * or anything other than 0.
	 * 
	 * @author Ryan Cornelius
	 */
	@Test
	void testGetSizeAlwaysZeroWhenTreeIsEmpty() {
		Treeable<Integer> t = new Tree<>();
		try {
			t.clear();
			t.getSize();
			assertTrue("Size is 0.", t.getSize() == 0);
			assertFalse("Size is not more or less than 0.", ((t.getSize() > 0) || (t.getSize() < 0)));
		} catch (Exception e) {
			System.out.println("getSize caused an error.");
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_insert_noExceptions_commonParameters() {
		Treeable<String> yeet = new Tree<>();
		try {
			yeet.insert("string 1");
			yeet.insert("string 2");
			yeet.insert("string 3");
		} catch (Exception e) {
			Assert.fail("insert() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_find_noExceptions_commonParameters() {
		Treeable<String> shakeSpeare = new Tree<>();
		shakeSpeare.insert("string 1");
		shakeSpeare.insert("string 2");
		shakeSpeare.insert("string 3");
		try {
			shakeSpeare.find("String 2");
		} catch (Exception e) {
			Assert.fail("find() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_contains_noExceptions_commonParameters() {
		Treeable<String> binaryTree = new Tree<>();
		binaryTree.insert("string 1");
		binaryTree.insert("string 2");
		binaryTree.insert("string 3");
		try {
			binaryTree.contains("String 2");
		} catch (Exception e) {
			Assert.fail("contains() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_remove_noExceptions_commonParameters() {
		Treeable<String> foo = new Tree<>();
		foo.insert("string 1");
		foo.insert("string 2");
		foo.insert("string 3");
		try {
			foo.remove("String 2");
		} catch (Exception e) {
			Assert.fail("remove() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_clear_noExceptions_commonParameters() {
		Treeable<String> blubBlubBlub = new Tree<>();
		blubBlubBlub.insert("string 1");
		blubBlubBlub.insert("string 2");
		blubBlubBlub.insert("string 3");
		try {
			blubBlubBlub.clear();
		} catch (Exception e) {
			Assert.fail("clear() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_getSize_noExceptions_commonParameters() {
		Treeable<String> cberkstresser = new Tree<>();
		cberkstresser.insert("string 1");
		cberkstresser.insert("string 2");
		cberkstresser.insert("string 3");
		try {
			cberkstresser.getSize();
		} catch (Exception e) {
			Assert.fail("getSize() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_getMinValue_noExceptions_commonParameters() {
		Treeable<String> spruceTree = new Tree<>();
		spruceTree.insert("string 1");
		spruceTree.insert("string 2");
		spruceTree.insert("string 3");
		try {
			spruceTree.getMinValue();
		} catch (Exception e) {
			Assert.fail("getMinValue() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * @author Ian Berkstresser "Math.sqrt(-1) am Nexos"
	 */
	@Test
	void nex_getMaxValue_noExceptions_commonParameters() {
		Treeable<String> palmTree = new Tree<>();
		palmTree.insert("string 1");
		palmTree.insert("string 2");
		palmTree.insert("string 3");
		try {
			palmTree.getMaxValue();
		} catch (Exception e) {
			Assert.fail("getMaxValue() is throwing an error: " + e.getMessage());
		}
	}

	/**
	 * Test inserting null value.
	 * 
	 * @author Seokwoo Ha
	 */
	@Test
	public void checkGetSizeFunctionalityWithMultipleNulls() {
		Treeable<Integer> myTree = new Tree<>();

		try {
			myTree.insert(null);
			myTree.insert(null);
			myTree.insert(7);
			myTree.insert(null);
			myTree.insert(null);
			assertTrue(myTree.getSize() == 1);
		} catch (Exception e) {
			Assert.fail("Input Error. The program should not accept a null as a value.");
		}
	}

	/**
	 * Test the minimum value With multiple duplicates.
	 * 
	 * @author Seokwoo Ha
	 */
	@Test
	public void checkMinValuesWithMultipleDups() {
		Treeable<Integer> myTree = new Tree<>();

		try {
			myTree.insert(1);
			myTree.insert(1);
			myTree.insert(2);
			myTree.insert(3);
			myTree.insert(3);
			assertTrue(myTree.getMinValue() == 1);
		} catch (Exception e) {
			Assert.fail("Your getMinValue method is not working properly, please check your codes.");
		}
	}

	/**
	 * Test the maximum value With multiple duplicates.
	 * 
	 * @author Seokwoo Ha
	 */
	@Test
	public void checkMaxValuesWithMultipleDups() {
		Treeable<Integer> myTree = new Tree<>();

		try {
			myTree.insert(1);
			myTree.insert(1);
			myTree.insert(2);
			myTree.insert(3);
			myTree.insert(3);
			assertTrue(myTree.getMaxValue() == 3);
		} catch (Exception e) {
			Assert.fail("Your getMaxValue method is not working properly, please check your codes.");
		}
	}

	/**
	 * @author Ethan
	 */
	@Test
	void findOnEmptyList() {
		try {
			Treeable<Integer> myTree = new Tree<>();
			myTree.find(5);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	/**
	 * @author Ethan
	 */
	@Test
	void maxSizeOnEmptyList() {
		try {
			Treeable<Integer> myTree = new Tree<>();
			assertTrue(myTree.getSize() == 0);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void remove_nullItem_noExceptions() {
		Treeable<Integer> Christmas = new Tree<>();

		try {
			Christmas.remove(null);
		} catch (Exception e) {
			Assert.fail("Your tree threw an exception when removing a null value");
		}
	}

	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void remove_normalTree_doesNotLooseNodes() {
		Treeable<Integer> Christmas = new Tree<>();

		Christmas.insert(0);
		Christmas.insert(1);
		Christmas.insert(2);
		Christmas.insert(-1);
		Christmas.insert(3);
		Christmas.remove(0);

		assertTrue(Christmas.getSize() == 4);
	}

	/**
	 * @author Nolan Perez
	 */
	@Test
	void treeGetSizeWorks() {
		Treeable<Integer> groot = new Tree<>();
		groot.insert(5);
		groot.insert(3);
		groot.insert(7);
		groot.insert(9);
		groot.insert(1);
		assertTrue(groot.getSize() == 5);
	}

	/**
	 * @author Nolan Perez
	 */
	@Test
	void testFindNullSilentlyRefuses() {
		Treeable<Integer> babyGroot = new Tree<>();

		try {
			babyGroot.find(null);
		} catch (Exception e) {
			Assert.fail("The tree threw an exception");
		}
	}

	/**
	 * @author Josiah Falukos
	 */
	@Test
	void insertsAfterClear() {
		try {
			Treeable<String> myTree = new Tree<>();
			myTree.clear();
			myTree.insert("is this working?");
		} catch (Exception e) {
			Assert.fail("Insert did not work after clearing tree");
		}

	}

	/**
	 * This test assumes getMaxValue() goes as far to the right as possible then
	 * gets that value.
	 * 
	 * @author Josiah Falukos
	 */
	@Test
	void isLeftChildOnTheLeft() {
		Treeable<Integer> myTree = new Tree<>();
		myTree.insert(8);
		myTree.insert(6);
		assertTrue(myTree.getMaxValue() == 8);

	}

	/**
	 * Tests to ensure that duplicate values are only inserted once per insert call.
	 * 
	 * @author Kaleb Johnson
	 */
	@Test
	void checkDuplicateValuesInsertedOncePerInsertCall() {
		Treeable<Integer> oakTree = new Tree<>();
		oakTree.insert(4);
		oakTree.insert(4);
		oakTree.insert(4);
		oakTree.insert(4);
		assertTrue(oakTree.getSize() == 4);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void remove_leftTree_keepsTrackofParent() {
		Treeable<Integer> bigCedar = new Tree<>();
		
		for (int n = 0; n < 8; n++) {
			if (n % 3 == 0) {
				bigCedar.insert(0);
			} else {
				bigCedar.insert(n);
			}
		}
		
		bigCedar.remove(0);
		bigCedar.remove(0);
		bigCedar.remove(0);
		
		assertTrue(bigCedar.getSize() == 5);
	}
	
	/**
	 * @author Caleb Stucky
	 */
	@Test
	public void remove_rightTree_keepsTrackofParent() {
		Treeable<Integer> bigCedar = new Tree<>();
		
		for (int n = 0; n < 8; n++) {
			if (n % 3 == 0) {
				bigCedar.insert(1000);
			} else {
				bigCedar.insert(n);
			}
		}
		
		bigCedar.remove(1000);
		bigCedar.remove(1000);
		bigCedar.remove(1000);
		
		assertTrue(bigCedar.getSize() == 5);
	}
	
	/**
	 * @author Kaleb Johnson
	 * Tests to ensure getSize remains accurate after removing a value other than root.
	 */
	@Test
	public void getSizeAccurateForRemoveValueNotRoot() {
		Treeable<Integer> yeetTree = new Tree<>();
		yeetTree.insert(4);
		yeetTree.insert(7);
		yeetTree.insert(6);
		yeetTree.insert(6);
		yeetTree.insert(6);
		yeetTree.insert(3);
		yeetTree.insert(2);
		yeetTree.remove(6);
		assertTrue(yeetTree.getSize() == 6);
	}
	
}
