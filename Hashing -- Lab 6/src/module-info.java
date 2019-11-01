module hashing {
}
/*
 * Hashes
 * The process of converting a value to a key
 * 
 * A good hash function does 2 things:
 * - A little change to input does a big change to the output so we have few collisions
 * - Don't waste a huge pile of space (2 inputs, 1 million place holders)
 * 
 *  There's never a way to fully combat collisions, so there must be a way to dodge them
 *  
 *  All OBJECTS have a built-in hashcode
 *  Integers are their own hashcode (Ex. int x = 5; the hashcode would be 5)
 *  
 *  Duplicates
 *  cat = 48
 *  2(3 + 1 + 20) = 48
 *  act = 48 -> dups + 1
 *  duplicates go in odd positions
 *  non-duplicates go in even positions
 *  
 *  Open Addressing is the first way to deal with duplicates
 *  Separate Chaining is the second way:
 *  The idea is to make each cell of hash table point to a linked list of records that 
 *  have same hash function value.
 */