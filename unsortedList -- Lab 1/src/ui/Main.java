package ui;

import java.util.Arrays;

import model.UnsortedList;

public class Main {
	public static void main(String[] args) {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(false);
		System.out.println(ul);
		ul.insert(5);
		ul.insert(5);
		ul.insert(5);
		ul.insert(2);
		ul.insert(3);
		System.out.println(ul);
		
//		System.out.println(Arrays.toString(ul.findAll(1)));
		System.out.println(Arrays.toString(ul.findAll(2)));
		//ul.clear();
		
		ul.initializeWithRandomData(UnsortedList.MAX_SIZE);
//		System.out.println(ul);
//		ul.deleteAll(5);
//		System.out.println(ul);
//		System.out.println(ul.find(2));
//		ul.insert(5);
	    System.out.println(ul);
	}
}
/*
 * UNIT TESTS
/**
 * @author Tanner Maasen
 
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
	 * @author Tanner Maasen
	 
	@Test
	public void initializeRandomCorrectSizeWithDups() {
		UnsortedList ul = new UnsortedList();
		ul.setDuplicatesAllowed(true); //Edit by Caleb Stucky. This best tests the scenario. Especially for larger numbers.
		ul.initializeWithRandomData(UnsortedList.MAX_SIZE);
		assertTrue(ul.getSizeOfList() == UnsortedList.MAX_SIZE);
	}
*/
