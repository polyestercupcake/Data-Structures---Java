module heaps {
	requires junit;
	requires org.junit.jupiter.api;
}
/*
 * Max Heaps (Every parent is greater than it's children)
 * 
 * Implement a priority queue on a binary tree
 * Every level must be complete, left to right
 * We are losing search
 * 
 * Insert
 * Always insert top to bottom, left to right (must be full before going down another level)
 * Compare to the above values. It's okay if inserted value is <= parent
 * If inserted value > parent, swap them (recursively or iteratively)
 * ----
 * Can either swap nodes or switch the value inside the node
 * 
 * Remove
 * 1. Remove root (only removes the root)
 * 	- Take most recent inserted value and make it the root (that node is now gone = disconnect)
 * 	- Compare side that has the greater value of the 2 children on level 2, swap them
 * 	- Keep comparing on that side until value is in correct position in heap
 * 	- When swapping down and the two children are ==, just choose a side to swap
 * 
 * 2. Remove most recent value
 * 	- do nothing
 * 
 * To keep track of where to insert next
 * 	- use an int accumulator 
 * 	- get the binary value of the accumulator
 * 	- Lose the first digit (truncate method for binary)
 * 	- Use 1's to go right and use 0's to go left
 * 	- Be ready for deleting to decrement
 * 
 * Heap Sort:
 * 	- If we put random numbers into a heap, the removal of each node created a sortedList
 * algorithm
 * 	- Sorting algorithm on the order of O(n log n)
 */


/*
 * 
 * a String representation of a binary tree
 * 
    public String toString(){         

        String output = ""; 
        int depth = 0;
        int arraySpots = tree.length;
         
        while (arraySpots > 0){
            arraySpots /= 2;
            ++depth;
        }

        int maxWidth = (int) (Math.pow(2, depth));
        int charWidth = 4*maxWidth;
        int idx = 0;

        for (int i = 0; i < depth; ++i) {
            int level = (int) Math.pow(2, i);
            for (int j = 0; j < level; ++j) {
                int preSpace = (int) ((charWidth/(Math.pow(2,(i + 1))) - 1));

                for (int k = 0; k < preSpace; ++k) {
                    output += " ";
                }
                output +=tree[idx];
                ++idx;
                
                if (idx >= size()) {
                    output += "\n";
                    break;
                }
                
                for (int k = 0; k < preSpace; ++k) {
                    output +=" ";
                }
            }
            output += "\n\n";
        }
        return output;
    }
*/
