package model;

import java.util.Arrays;


/*
 * ADT implemented on an int array
 */
public class UnsortedList implements Listable {

	public static final int MAX_SIZE = 5;
	// data structure
	private int[] values = new int[MAX_SIZE];
	// pointer will give us the size of the array. Index position starts at 0
	private int pointer = 0;

	private boolean duplicatesAllowed;

	@Override
	public int getSizeOfList() {
		return pointer;
	}

	@Override
	public boolean areDuplicatesAllowed() {
		return duplicatesAllowed;
	}

	@Override
	public void setDuplicatesAllowed(boolean pDuplicatesAllowed) {
		duplicatesAllowed = pDuplicatesAllowed;

	}

	@Override
	public void clear() {
		pointer = 0;
	}

	@Override
	public void insert(int pValueToInsert) {
		if (duplicatesAllowed == true || find(pValueToInsert) == -1) {
			if (pointer < MAX_SIZE) {
				values[pointer] = pValueToInsert;
				pointer++;
			}
		}
		if (duplicatesAllowed == false) {
			for (int n = 0; n < MAX_SIZE; n++) {
				int j = find(pValueToInsert);
				// if value is in array, do nothing
				// if value is not in array (find == -1), add it
				if (j == -1) {
					values[pointer] = j;
					pointer++;
				}
			}
		}
	}

	@Override
	public void delete(int pValueToDelete) {
		// pValue is the value, not the pointer
		int n = find(pValueToDelete);
		if (find(pValueToDelete) != -1) {
			pointer--;
			values[n] = values[pointer];
			// for Sorted Lists
//			for (int n = find(pValueToDelete); n < pointer - 1; n++)
//				// shift to left
//			 //FAILS WHEN TO TRY SHIFT LAST POSITION
//				values[n] = values[n + 1];
		}
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		// if pValue is 3, delete all 3's in the array
		while (find(pValueToDelete) != -1) {
			delete(pValueToDelete);
		}

//		if (duplicatesAllowed == false) {
//			delete(pValueToDelete);
//		} else {
//			for (int n = 0; n < pointer; n++) {
//				if (values[n] == pValueToDelete) {
//				}
//			}
//		}
	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {

		int number;
		pointer = 0;
		if (duplicatesAllowed == true) {
			if (pSizeOfList < MAX_SIZE) {
				for (int n = 0; n < pSizeOfList; n++) {
					number = (int) (Math.random() * 10);
					values[pointer++] = number;
				}
			} else if (pSizeOfList >= MAX_SIZE) {
				for (int n = 0; n < MAX_SIZE; n++) {
					number = (int) (Math.random() * 10);
					values[pointer++] = number;
				}
			}
		}
		 if (duplicatesAllowed == false) {
				if (pSizeOfList < MAX_SIZE) {
					while (pointer != pSizeOfList) {
						// for (int n = 0; n < MAX_SIZE; n++) {
						int numbers = (int) (Math.random() * 10);
						insert(numbers);
					}
				} else if (pSizeOfList >= MAX_SIZE) {
					while (pointer != MAX_SIZE) {
						// for (int n = 0; n < MAX_SIZE; n++) {
						int numbers = (int) (Math.random() * 10);
						insert(numbers);
					}
				}
			}
		}

	@Override
	public int find(int pValueToFind) {
		// ONLY RETURNS ONE (NO DUPLICATES)
		for (int n = 0; n < pointer; ++n) {
			if (values[n] == pValueToFind) {
				// this returns the index position
				return n;
			}
		}
		return -1;
	}

	@Override
	public int[] findAll(int pValueToFind) {
		// RETURNS MORE THAN ONE (DUPLICATES)

		int[] arr = new int[pointer];
		int tempPointer = 0;
		for (int n = 0; n < pointer; n++) {
			if (values[n] == pValueToFind) {
				arr[tempPointer++] = n;
			}
		}
		int[] newArray = Arrays.copyOf(arr, tempPointer);
		return newArray;
		/*
		 * ArrayList way import java.util.ArrayList; ArrayList<Integer> arr = new
		 * ArrayList<Integer>(); int[] arr = new int[pointer]; for (int n = 0; n <
		 * pointer; n++) { if (values[n] == pValueToFind) { arr.add(n); }} int[]
		 * newArray = new int[arr.size()]; int i = 0; for (int n : arr) newArray[i++] =
		 * n;
		 */
	}

	@Override
	public String toString() {
		int[] returnValue = new int[pointer];

		for (int n = 0; n < pointer; n++) {
			returnValue[n] = values[n];
		}

		return Arrays.toString(returnValue);
	}
}
