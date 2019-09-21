module unsortedList {
	requires jdk.compiler;
	requires org.junit.jupiter.api;
	requires junit;
}
/*
 * Data structure: a way of storing primitive data
 * ADT: defines the behavior of what we're going to implement
 * I can have different ADT's implemented on different data structures
 * Unsorted list: 1 7 2 5 10 ... it doesn't get more complex the more elements I have
 * Big-O: O(1) when inserting into the list
 * Deleting by position: we have to shift the indexers after deleting
 * Big-O: O(n) when deleting (it's proportional to n/2)
 * Find any, all: O(n)
 * Clear: start at the end of the array so you wouldnt have to start at the beginning and delete,
 * shift, move on, delete, shift, move on... It gets rid of the shift if you start at the end
 * Big-O: O(n^2) 
 * An unsorted list can be implemented on an array, or another data structure (so it's an ADT)
 * 
 * ArrayList is an unsorted list implemented on an array. But we can't have Java do it for us
 * 
 * 
 * Ask about buying the clean code book for the CS department
 * 
 * BUBBLE SORT
 * 9 8 1 3 2
 * compare
 * swap 9 and 8
 * 8 9 1 3 2 
 * swap 9 and 1
 * 8 1 9 3 2
 * swap 9 and 3
 * 8 1 3 9 2
 * swap 9 and 2
 * 8 1 3 2 9 --I can ensure the last value is sorted. Don't have to worry about it
 * swap 8 and 1
 * 1 8 3 2 9
 * swap 8 and 3
 * 1 3 8 2 9
 * swap 8 and 2
 * 1 3 2 8 9 --I can ensure the last 2 values are sorted.
 * swap 3 and 2
 * 1 2 3 8 9
 * DONE (8 swap operations, 16 compare operations)
 * On average, there will be half as many swaps as the number of values in the list
 * Both compares and swaps are on the order of n^2
 * 
 * SELECTION SORT
 * 9 8 1 3 2
 * go through all values, find the largest
 * position: 0
 * value: 9
 * no value was bigger than the 9 after going through the whole list. Put 9 at the end of the list
 * Keep doing that process throughout the whole thing
 * Swaps are on the order of n
 * Compares are on the order of n^2
 * Worst possible input: 9 8 7 6 5
 * 
 * can't just throw number onto end. Find the number closest to where it goes
 * which list is better will depend on what you're using your lists for. This is why we have Big-O Notation!
 * insert: O(1) = unsorted ... O(n) = sorted
 * find: O(n) = unsorted... O(logn) = sorted
 * delete: O(n) = unsorted and sorted
 * 
 * 
 * binary search (O notation = log2(n))
 * only notation better is O(1)
 * ln(2^x) = log(y)
 * xln(2) = lx(y)
 * x = ln(x)/ln(2)
 * x = (1/ln(2)) * y
 * 
 * 
 * O notation of 2^n = 2^outputComplexity = input
 * 
 * check for when IF pValueToFind = pointer || when it is < pointer || when it is > pointer
 * use midpoint formula--that'll tell you where to put your pointer next
 * 
 * find() binary search
 * needs to be sorted before starting
 * use start pointer, current pointer, and end pointer to create a set of bounds of where my number could be
 * put current pointer in middle 
 * pValueToFind = pointer || when it is < pointer || when it is > pointer {
 * say pointer is < pointer
 * move start pointer
 */