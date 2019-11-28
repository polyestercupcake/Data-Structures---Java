package model;

public interface IDirectedEdge {
    
	/**
	 * @return the weight of the edge.
	 */
	int getWeight();

	/**
	 * Sets the weight of an edge.
	 * @param pWeight the weight to be set
	 */
    default void setWeight(int pWeight) {
	}
}
