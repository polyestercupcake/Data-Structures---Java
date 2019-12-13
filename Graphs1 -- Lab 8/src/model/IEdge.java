package model;

/**
 * Denotes an edge in a graph.
 * 
 * @author cberkstresser
 *
 */
public interface IEdge {
    /**
     * 
     * @return A reference to the first vertex of the edge.
     */
    IVertex getVertex1();

    /**
     * 
     * @return A reference to the second vertex of the edge.
     */
    IVertex getVertex2();

    /**
     * Sets the first vertex of the edge.
     * 
     * @param pVertex The vertex to attach to the beginning of the edge.
     */
    void setVertex1(IVertex pVertex);

    /**
     * Sets the second vertex of the edge.
     * 
     * @param pVertex The vertex to attach to the end of the edge.
     */
    void setVertex2(IVertex pVertex);

    /**
     * Sets both vertices of the edge at once.
     * 
     * @param pVertex1 The vertex to attach to the beginning of the edge.
     * @param pVertex2 The vertex to attach to the end of the edge.
     */
    void setVertices(IVertex pVertex1, IVertex pVertex2);
}