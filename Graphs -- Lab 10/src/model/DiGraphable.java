package model;

import java.util.List;

/**
 * Interface for a directed graph
 * 
 * @author cberkstresser
 *
 */
public interface DiGraphable extends IGraph2 {

    /**
     * Get the shortest path between two vertices.
     * 
     * @param start The starting vertex of the path.
     * @param end   The ending vertex of the path.
     * @return A list of vertices denoting the path. Returns an empty list if no
     *         path is possible.
     * @implNote Should respect direction!!!!!!!!!!!!!
     */
    List<IVertex> getShortestPath(IVertex start, IVertex end);

    /**
     * Is the graph weakly connected?
     * 
     * @return True if the graph would be connected provided the edges were
     *         bidirectional.
     * @implNote Previous behavior based on your parent interface.
     */
    boolean isWeaklyConnected();

    /**
     * Is the graph strongly connected?
     * 
     * @return True if for any two vertices, there exists a directed path between
     *         them.
     */
    boolean isStronglyConnected();

    /**
     * Is the directed graph complete?
     * 
     * @return True if for any two vertices A, B, there exists a directed edge from
     *         A to B.
     */
    boolean isComplete();
}
