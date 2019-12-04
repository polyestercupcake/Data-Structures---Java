package model;

import java.util.List;
import java.util.Set;

/**
 * The properties and methods associated with a graph.
 * 
 * @author cberkstresser
 *
 */
public interface IGraph {
    /**
     * Adds an edge to the graph.
     *
     * @param pEdge The edge to add to the graph.
     * @implNote Should reject the edge if the vertices don't exist in the graph.
     * Two vertices are the same if their IDs match.
     */
    void addEdge(IEdge pEdge);

    /**
     * Adds a vertex to the graph.
     *
     * @param pVertex The vertex to add to the graph.
     */
    void addVertex(IVertex pVertex);

    /**
     * Show a list of the ids of all adjacent vertices.
     *
     * @param pVertex The vertex of which to show all adjacent vertices.
     * @return A set of the vertices that are adjacent.
     */
    Set<IVertex> getAdjacentVertices(IVertex pVertex);

    /**
     *
     * @return The edges contained in the graph.
     */
    List<IEdge> getEdges();

    /**
     * An Euler cycle traverses each edge in the graph once. In the case of this
     * function, we denote a strong Euler cycle to require a graph be connected.
     *
     * @param pVertex The vertex with which to start/end the cycle.
     * @return Returns a list of vertices of the cycle if it exists. Otherwise
     *         returns an array of size zero.
     */
    List<IVertex> getStrongEulerCycle(IVertex pVertex);

    /**
     *
     * @return The list of vertices in this graph. Return an empty list if none.
     */
    List<IVertex> getVertices();

    /**
     * An Euler cycle traverses each edge in the graph once. In the case of this
     * function, we denote a strong Euler cycle to require a graph be connected.
     *
     * @return Returns true if the graph is connected and an Euler Cycle exists
     *         starting and ending with pVertexID.
     */
    boolean hasStrongEulerCycle();

    /**
    *
    * @param pVertex1 The first vertex.
    * @param pVertex2 The second vertex.
    * @return True if the two vertices are adjacent.
    */
   boolean isAdjacent(IVertex pVertex1, IVertex pVertex2);

   /**
    * Is the graph complete.
    *
    * @return Returns true if the graph is complete. To show a graph is complete,
    *         choose any two vertices--an edge will exist between them.
    */
   boolean isComplete();

   /**
     * starting point is the first vertex is vertices visit the next vertex and
	 * determine if they are adjacent must end at the point where I began so I can
	 * check it's adjacent
	 * 
	 * --Try 1-- for loops if vertex has a loop, disregard it for each edge, add
	 * both vertices to an arrayList for each vertex, check if char don't add if
	 * connected to itself
    *
    *
    * @return True if the graph is a connected graph. A graph is connected if a
    *         path exists between any two vertices.
    */
   boolean isConnected();

   /**
    * Removes an edge from the graph.
    *
    * @param pIndex The index of the edge to remove from the graph.
    * @implNote Should leave the vertices that are associated with the edge in the
    *           graph.
    */
   void removeEdge(int pIndex);

   /**
    * Removes a vertex from the graph.
    *
    * @param pIndex The index of the vertex to remove from the graph.
    */
   void removeVertex(int pIndex);

   /**
    * Sets the edges affiliated with this graph.
    *
    * @param pEdges The list of edges to add.
    * @see addEdge for a more granular approach. Edges should generally be set
    *      through that function.
    */
   void setEdges(List<IEdge> pEdges);

   /**
    * Sets the vertices in this graph.
    *
    * @param pVertices The list of edges to add.
    * @see addVertex for a more granular approach. Vertices should generally be set
    *      through that function
    */

   void setVertices(List<IVertex> pVertices);
}