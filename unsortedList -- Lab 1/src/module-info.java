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
*/