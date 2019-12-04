package model;

import java.util.List;

/**
 * An interface for the second graphs assignment.
 * 
 * @author cberkstresser
 *
 */
public interface IGraph2 extends IGraph {
	/**
	 * Depth First Search of the given graph.
	 * 
	 * It's a Stack!
	 * 
	 * start at A..get adjacent vertices
	 * add to Stack
	 * once stops, go to next line of edges on A
	 * repeat process
	 * 
	 * 
	 * @return Returns an array of vertices representing the path taken during the
	 *         search.
	 */
	List<IVertex> depthFirstSearch();

	/**
	 * Breadth First Search of the given graph.
	 * Searching to see what vertices are here in the graph
	 * NOTE: my isConnected() is very similar
	 * 
	 * From your starting point (vertices.get(0)) 
	 * Get all adjacent vertices...add them to queue
	 * dequeue your starting vertex
	 * 
	 * Go to the next vertex
	 * Get all adjacent vertices...add them to queue
	 * dequeue your next vertex
	 * 
	 * continue process until there's no more adjacent vertices
	 * 
	 *
	 * @return Returns an array of vertices representing the path taken during the
	 *         search.
	 */
	List<IVertex> breadthFirstSearch(IVertex vertex);

	/**
	 * Get the shortest path between two vertices.
	 * 
	 * Every edge has a weight of 1
	 * Think of it has a hop..how many hops to get from A -> B
	 * When hops or ==, just choose a path...it's like a fork in the road
	 * Be careful with terminating conditions...can StackOverflow quickly
	 * Call other methods (adjacent...)
	 * 
	 *
	 * @param start The starting vertex of the path.
	 * @param end   The ending vertex of the path.
	 * @return A list of vertices denoting the path. Returns an empty list if no
	 *         path is possible.
	 *         
	 */
	List<IVertex> getShortestPath(IVertex start, IVertex end);

	/**
	 * A Hamiltonian cycle visits each vertex in the graph once except the starting
	 * vertex, which is visited twice.
	 * 
	 * Conditions: must be connected.
	 *
	 * @param pVertex The vertex on which to start/end the cycle.
	 * @return Returns an array of vertices representing the path taken during the
	 *         search.
	 */
	default List<IVertex> hamiltonianCycle(IVertex pVertex) {
		throw new UnsupportedOperationException("Implement me for 5 bonus points");
	}
}