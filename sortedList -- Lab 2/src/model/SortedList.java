package model;

import java.util.Arrays;

public class SortedList extends UnsortedList implements MoreListable {

	@Override
	public int find(int pValueToFind) {
		return binarySearch(pValueToFind, 0, pointer - 1);
	}

	@Override
	public int[] findAll(int pValueToFind) {

		int tempPointer = 0;
		int[] arr = new int[pointer];
		// found middle value
		int findMidpt = binarySearch(pValueToFind, 0, pointer - 1);
		int lookLeft = findMidpt;
		int lookRight = lookLeft;

		// check for if pValueToFind is not present
		if (findMidpt != -1) {
			// if pValueToFind is already at index 0, dont need to look left
			// look left until the next value isnt == to value found
			while (lookLeft > -1 && values[lookLeft] == pValueToFind) {
				lookLeft--;
			}

			if (lookLeft == -1 || lookLeft != pValueToFind)
				lookRight = lookLeft + 1;
			else if ((lookLeft + 1) != pValueToFind)
				lookRight = lookLeft + 1;
			else
				lookRight = lookLeft;

			// then look right and start adding those found until u come across a
			// value that isn't == to value found
			while (lookRight < pointer && values[lookRight] == pValueToFind) {
				arr[tempPointer++] = lookRight;
				lookRight++;
			}
		}
		int[] newArray = Arrays.copyOf(arr, tempPointer);
		return newArray;
	}

	@Override
	public int[] getValues() {
		// int array, starting position, ending (most recent insert) position
		return Arrays.copyOfRange(values, 0, pointer);
	}

	@Override
	public void insert(int pValueToInsert) {
		if (pointer == 0) {
			values[pointer] = pValueToInsert;
			pointer++;
		} else {

			if (duplicatesAllowed == true || find(pValueToInsert) == -1) {
				if (pointer < MAX_SIZE) {
					values[pointer] = pValueToInsert;
					pointer++;
				}
			}
		}
		//selectionSort();
		//bubbleSort();
		beerSort();
	}

	public int binarySearch(int pValueToFind, int start, int end) {

		// RECURSIVELY
		if (end >= start) {
			int midpt = (start + end) / 2;
			if (pValueToFind == values[midpt])
				return midpt;
			else {
				// values that aren't in array still hit these
				if (values[midpt] < pValueToFind)
					return binarySearch(pValueToFind, midpt + 1, end);
				else if (values[midpt] > pValueToFind)
					return binarySearch(pValueToFind, start, midpt - 1);
			}
		}
		return -1; // number was not found
	}
}