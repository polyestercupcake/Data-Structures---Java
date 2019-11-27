package model;

/**
 * Represents a vertex in a graph.
 * 
 * @author cberkstresser
 *
 */
public interface IVertex {
    /**
     * 
     * @return The ID of the vertex.
     */
    char getId();

    /**
     * 
     * @param pId The ID of the vertex to set.
     */
    void setId(char pId);
}