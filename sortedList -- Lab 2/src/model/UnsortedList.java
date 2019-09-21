package model;

import java.util.Arrays;

/*
 * ADT implemented on an int array
 */
public class UnsortedList implements Listable {

	public static final int MAX_SIZE = 10;
	// data structure
	protected  int[] values = new int[MAX_SIZE];
	// pointer will give us the size of the array. Index position starts at 0
	protected int pointer = 0;

	protected boolean duplicatesAllowed;

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

	//@Override
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
		int n = find(pValueToDelete);
		if (find(pValueToDelete) != -1) {
			for (int j = n; j < (pointer - 1); j++)
			values[j] = values[j+1];
			pointer--;
		}
	}

	@Override
	public void deleteAll(int pValueToDelete) {
		while (find(pValueToDelete) != -1)
			delete(pValueToDelete);
	}

	@Override
	public void initializeWithRandomData(int pSizeOfList) {

		int number;
		pointer = 0;
		if (duplicatesAllowed == true) {
			if (pSizeOfList < MAX_SIZE) {
				for (int n = 0; n < pSizeOfList; n++) {
					number = (int) (Math.random() * 10);
					insert(number);
				}
			} else if (pSizeOfList >= MAX_SIZE) {
				for (int n = 0; n < MAX_SIZE; n++) {
					number = (int) (Math.random() * 10);
					insert(number);
				}
			}
		}
		 if (duplicatesAllowed == false) {
				if (pSizeOfList < MAX_SIZE) {
					while (pointer != pSizeOfList) {
						// for (int n = 0; n < MAX_SIZE; n++) {
						int number2 = (int) (Math.random() * 10);
						insert(number2);
					}
				} else if (pSizeOfList >= MAX_SIZE) {
					while (pointer != MAX_SIZE) {
						// for (int n = 0; n < MAX_SIZE; n++) {
						int number2 = (int) (Math.random() * 10);
						insert(number2);
					}
				}
			}
		}

	@Override
	public int find(int pValueToFind) {
		// ONLY RETURNS ONE (NO DUPLICATES)
		for (int n = 0; n < pointer; ++n) {
			if (values[n] == pValueToFind)
				return n; // returns the index position
		}
		// if the desired value is not in the array, return -1
		return -1;
	}

	@Override
	public int[] findAll(int pValueToFind) {
		// RETURNS MORE THAN ONE (DUPLICATES)
		int[] arr = new int[pointer];
		int tempPointer = 0;
		for (int n = 0; n < pointer; n++) {
			if (values[n] == pValueToFind)
				arr[tempPointer++] = n;
		}
		int[] newArray = Arrays.copyOf(arr, tempPointer);
		return newArray;
		/*
		 * ArrayList way :: import java.util.ArrayList; ArrayList<Integer> arr = new
		 * ArrayList<Integer>(); int[] arr = new int[pointer]; for (int n = 0; n <
		 * pointer; n++) { if (values[n] == pValueToFind) { arr.add(n); }} int[]
		 * newArray = new int[arr.size()]; int i = 0; for (int n : arr) newArray[i++] =
		 * n;
		 */
	}
	
	/**
     * @author cberkstresser
     * @implNote Using the backwards outer loop like the textbook, page 86. I like
     *           this approach better than the approaches which use dual forward
     *           loops. It is too easy to overtrace your steps with dual forward
     *           loops.
     * @implSpec Put me in UnsortedList
     * 
     * BONUS: implemented bubbleSort() traditionally.
     */
    @Override
    public Listable bubbleSort() {
        for (int secondNumber = 0; secondNumber < pointer; secondNumber++) {
            for (int firstNumber = 0; firstNumber < pointer; firstNumber++) {
                if (values[firstNumber] > values[secondNumber]) {
                    // swap them if out of order
                	// doesn't matter what comes first, secondNumber or firstNumber
                	swap(firstNumber, secondNumber);
                }
            }
        }
        return this;
    }
    
    /**
     * Non-traditional way of bubbleSort(), aka beerSort().
     * @return null.
     */
    public MoreListable beerSort() {
    	for (int secondNum = pointer - 1; secondNum > 0; --secondNum) {
    		for (int firstNum = 0; firstNum < secondNum; ++firstNum) {
    			if (values[firstNum] > values[secondNum]) {
    				swap(firstNum, secondNum);
    			}
    		}
    	} return null;
    }
    
    /**
     * int out is the value at the index position that is to be compared with all the other values in the array
     * int incrementer are the values in the array that are being compared to out
     * int min is the placeholder for a value if it needs to be swapped
     */
    @Override
	public MoreListable selectionSort() {
    	
    	int out, incrementer, min;
    	//first loop gets a value
    	for(out = 0; out < pointer - 1; out++) {
    		min = out;							
    	//inner loop compares it to every other value
    		for(incrementer = out + 1; incrementer < pointer; incrementer++) {
    			if (values[incrementer] < values[min])
    				min = incrementer;
    				swap(out, min);
    		}
    	}
		return null;
	}

	@Override
	public String toString() {
		int[] returnValue = new int[pointer];

		for (int n = 0; n < pointer; n++)
			returnValue[n] = values[n];

		return Arrays.toString(returnValue);
	}
	
	/**
	 * Used to help with both selectionSort and bubbleSort methods.
	 * It swaps two values that need to be swapped in an array.
	 * @param one
	 * @param two
	 */
	public void swap(int one, int two) {
		int temp = values[one];
		values[one] = values[two];
		values[two] = temp;
	}
}
