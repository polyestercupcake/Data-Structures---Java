package model;

public interface IDirectedEdge extends IEdge {
    int getWeight();

    default void setWeight(int pWeight) {
        throw new UnsupportedOperationException("Make a constructor for new Edge(vertex1, vertex2, weight)");
    }
}
