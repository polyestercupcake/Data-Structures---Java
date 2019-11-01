package model;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> implements Treeable<T> {
	// DUPLICATES ARE ALWAYS ALLOWED
	private Node<T> root = null;

	@Override
	public Node<T> find(T value) {

		Node<T> current = root;
		if (current == null) {
			return null;
		} else {
			while (current != null) {
				if (current.getValue().compareTo(value) == 0) {
					return current;
				} else if (current.getValue().compareTo(value) < 0) {
					current = current.getRightChild();
				} else {
					current = current.getLeftChild();
				}
			}
		}
		return current;
	}

	@Override
	public boolean contains(T value) {
		return find(value) != null ? true : false;
	}

	@Override
	public void insert(T value) {
		/*
		 * Returns a negative integer, zero, or a positive integer as the compared
		 * object is less than, equal to, or greater than the specified object
		 * 
		 * root.getValue() is the specified object and value is the object to be
		 * compared
		 */
		Node<T> nodeToInsert = new Node<>();
		if (value == null) {
			return;
		}
		if (root == null) {
			root = nodeToInsert;
			root.setValue(value);
		} else {
			Node<T> current = root;
			Node<T> parent;
			while (true) {
				parent = current;
				if (current.getValue().compareTo(value) > 0) {
					current = current.getLeftChild();
					if (current == null) {
						parent.setLeftChild(nodeToInsert);
						parent.getLeftChild().setParent(parent);
						nodeToInsert.setValue(value);
						return; // ends the method
					}
				} else {
					current = current.getRightChild();
					if (current == null) {
						parent.setRightChild(nodeToInsert);
						parent.getRightChild().setParent(parent);
						nodeToInsert.setValue(value);
						return; // ends the method
					}
				}
			}
		}
	}

	@Override
	public void remove(T value) {
		// TODO Auto-generated method stub
		List<T> returnValues = new ArrayList<>();
		Node<T> nodeToDelete = find(value);
		Node<T> current = nodeToDelete;
			// if it's not found:
		if (current == null) {
			return;
			// if it's the root:
		} else if (nodeToDelete == root) {
			root = null;
				addIntoList(returnValues, nodeToDelete);
			// if it's the min value:
		} else if (getMinValue().compareTo(value) == 0) {
			nodeToDelete.getParent().setLeftChild(null);
			// if it's the max value:
		} else if (getMaxValue().compareTo(value) == 0) {
			nodeToDelete.getParent().setRightChild(null);
			// if it's not the root:
		} else if (current.getValue().compareTo(current.getParent().getValue()) > 0) {
			nodeToDelete.getParent().setRightChild(null);
				addIntoList(returnValues, nodeToDelete);
		} else {
			nodeToDelete.getParent().setLeftChild(null);
				addIntoList(returnValues, nodeToDelete);
		}
		// reinsertion point
		for (T n : returnValues) {
			insert(n);
		}
	}

	/**
	 * Helper for the remove method. Splits it up so I don't have a godzilla method.
	 * @param list
	 * @param nodeToDelete
	 */
	public void addIntoList(List<T> list, Node<T> nodeToDelete) {
		if (nodeToDelete.getLeftChild() != null || nodeToDelete.getRightChild() != null) {
			list.addAll(asList(nodeToDelete.getLeftChild()));
			list.addAll(asList(nodeToDelete.getRightChild()));
		}
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public T getMinValue() {

		Node<T> current = root;
		if (current == null) {
			return null;
		}
		while (current.getLeftChild() != null) {
			current = current.getLeftChild();
		}
		return current.getValue();
	}

	@Override
	public T getMaxValue() {

		Node<T> current = root;
		if (current == null) {
			return null;
		}
		while (current.getRightChild() != null) {
			current = current.getRightChild();
		}
		return current.getValue();
	}

	@Override
	public int getSize() {
		return getSize(root);
	}

	public int getSize(Node<T> node) {
		if (node == null) { // primitive stopping condition
			return 0;
		} else { // recursive case
			return getSize(node.getLeftChild()) + 1 + getSize(node.getRightChild());
		}
	}

//Overloading and Resursion

	@Override
	public String toString() {
		return toString(root);
		// .replaceAll("^,","").replaceAll(",$", "")
	}

	private String toString(Node<T> node) {
		if (node == null) { // primitive stopping condition
			return "";
		} else { // recursive case
			return toString(node.getLeftChild()) + node.getValue() + ","
					+ toString(node.getRightChild()).replaceAll(",,", ",");
		}
	}

	/**
	 * @author cberkstresser
	 * @return The tree as a List
	 */
	public List<T> asList() {
		return asList(root);
	}

	/**
	 * Recursion(Recursion(Recursion(Recursion(Recursion rules))))
	 * 
	 * @author cberkstresser
	 * @return The tree as a List from any node.
	 */
	private List<T> asList(Node<T> node) {
		List<T> returnValue = new ArrayList<>();
		if (node != null) {
			returnValue.addAll(asList(node.getLeftChild()));
			returnValue.add(node.getValue());
			returnValue.addAll(asList(node.getRightChild()));
		}
		return returnValue;
	}
}
