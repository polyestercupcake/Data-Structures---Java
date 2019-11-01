package model;

/**
 * @author cberkstresser
 * @param <T> The type of Tree values it will hold.
 * @version 1.1 Added extends Comparable<T>
 */
public interface Treeable<T extends Comparable<T>> {
     Node<T> find(T value);
     boolean contains (T value);
     void insert(T value);
     void remove(T value);
     void clear();
     T getMinValue();
     T getMaxValue();
     int getSize();
     /**
      * @return The number of nodes in the longest branch including the root. 
      * @implNote Returns 0 for an empty tree
      */
     default int getMaxDepth( ) {
        throw new IllegalArgumentException("Implement for 2 bonus points"); 
     }
}