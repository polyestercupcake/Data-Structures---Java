package model;

import java.util.List;

/**
 * The path finder using A* algorithm.
 */
public abstract class AbstractMaze {
    /**
     * Constructor.
     * 
     * @param maze A 2-d array representing the maze on which to path-find. Cells
     *             that can be traversed have a value of true. Cells that cannot be
     *             traversed are false. The cell at [0][0] will always be true as
     *             well as the cell at the opposite diagonal end of the maze.
     * @implNote The 2-d array may not be square, but it will be rectangular.
     */
    public AbstractMaze(boolean[][] maze) {

    }

    /**
     * The A* path.
     * 
     * @return Returns a list of which cells represent the shortest path (found by
     *         the A* algorithm)
     *         @implNote Cells are numbered 0 and onward as follows first by rows and then by columns:
     *         
     *         |00|01|02|03|
     *         |04|05|06|07| 
     *         |08|09|10|11|
     *         |12|13|14|15|
     *         |16|17|19|19|
     *         
     */
    public abstract List<Integer> getAStarPath();
}