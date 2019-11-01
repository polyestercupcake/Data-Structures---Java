package model;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> implements Heapable<T> {

	private Node<T> root = new Node<>();
	private int accumulator = 0; // for keeping track of insertion point

	@Override
	public void insert(Data<T> value) {
		Node<T> parent = root;
		Node<T> nodeToInsert = new Node<>();
// BASE CASE (insertion of root)
		if (root.getValue() == null) {
			root.setValue(value);
			accumulator++;
		} else {
			accumulator++;
// CONVERT TO BINARY, FIND THE POSITION, and MAKE THE CONNECTION
			String n = String.format(Integer.toBinaryString(accumulator)).replace(' ', '0');
			// removes first binary number
			n = n.substring(1);
			// if counter is 1 and we substring it, this will catch the null
			if (n.equals("")) {
				parent.setLeftChild(nodeToInsert);
				nodeToInsert.setParent(parent); // CONNECTION MADE
				nodeToInsert.setValue(value);
			}
			char[] binArray = n.toCharArray();
			for (char binNum : binArray) {
				if (binNum == '1') {
					if (parent.getRightChild() == null) {
						parent.setRightChild(nodeToInsert);
						nodeToInsert.setParent(parent); // CONNECTION MADE
						nodeToInsert.setValue(value);
					} else {
						parent = parent.getRightChild();
					}
				} else {
					if (parent.getLeftChild() == null) {
						parent.setLeftChild(nodeToInsert);
						nodeToInsert.setParent(parent); // CONNECTION MADE
						nodeToInsert.setValue(value);
					} else {
						parent = parent.getLeftChild();
					}
				}
			}
			// compareTo() the current and parent priorities
			int comparison = nodeToInsert.getValue().compareTo(parent.getValue());
// SORT IT
			// If inserted value > parent, swap them
			while (comparison > 0) { // once they are in correct position, comparison will kick out a negative value
				swap(nodeToInsert, parent);
				if (parent.getParent() != null) {
					parent = parent.getParent();
					nodeToInsert = nodeToInsert.getParent();
				}
				comparison = nodeToInsert.getValue().compareTo(parent.getValue());
			}
		}
	}

	/**
	 * Makes life easier.
	 * 
	 * @param one
	 * @param two
	 */
	public void swap(Node<T> one, Node<T> two) {
		Data<T> temp = one.getValue();
		one.setValue(two.getValue());
		two.setValue(temp);
	}

	/**
	 * Remove 1. Remove root (only removes the root) - Take most recent inserted
	 * value and make it the root (that node is now gone = disconnect) - Compare
	 * side that has the greater value of the 2 children on level 2, swap them -
	 * Keep comparing on that side until value is in correct position in heap - When
	 * swapping down and the two children are ==, just choose a side to swap
	 *
	 */
	@Override
	public Data<T> remove() {
		Node<T> nodeToRemove = new Node<>();
		nodeToRemove.setValue(root.getValue());
		Node<T> parent = root;
// FIND NODE TO MOVE TO ROOT POSITION
		// base case
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			root.setValue(null);
			accumulator--;
		} else {
			String n = String.format(Integer.toBinaryString(accumulator)).replace(' ', '0');
			// removes first binary number
			n = n.substring(1);
			// if counter is 1 and we substring it, this will catch the null
			if (n.equals("")) {
				root.setValue(root.getLeftChild().getValue());
				root.setLeftChild(null);
				return nodeToRemove.getValue();
			}
			char[] binArray = n.toCharArray();
			for (char binNum : binArray) {
				if (binNum == '1') {
					parent = parent.getRightChild();
					if (parent.getRightChild() == null) {
						root.setValue(parent.getValue());
						parent = parent.getParent();
						parent.setRightChild(null);
					}
				} else {
					parent = parent.getLeftChild();
					if (parent.getLeftChild() == null) {
						root.setValue(parent.getValue());
						parent = parent.getParent();
						parent.setLeftChild(null);
					}
				}
			}
			accumulator--;
		}
//needed a better naming covention for the 2nd part of the method
		Node<T> tempRoot = root;
		Node<T> childOfTemp = parent;
//BASE CASE
		if (tempRoot.getValue() == childOfTemp.getValue()) {
			return nodeToRemove.getValue();
		}
// make sure left and right children exist before figuring out which is bigger
		if (tempRoot.getRightChild() != null) {
			int rightPriority = tempRoot.getRightChild().getValue().getPriority();
			int leftPriority = tempRoot.getLeftChild().getValue().getPriority();
// comparing the greater priority of the two children of the root
			if (rightPriority < leftPriority) {
				childOfTemp = tempRoot.getRightChild();
			} else
				childOfTemp = tempRoot.getLeftChild();
		} else
			childOfTemp = tempRoot.getLeftChild();
		
		int comparison = tempRoot.getValue().compareTo(childOfTemp.getValue());
//SORT IT
		// If inserted value > parent, swap them
		while (comparison < 0) { // once they are in correct position, comparison will kick out a negative value
			swap(tempRoot, childOfTemp);
			// resetting nodes to traverse down the tree
			if (childOfTemp == tempRoot.getRightChild()) {
				if (childOfTemp.getRightChild() != null) {
					childOfTemp = childOfTemp.getRightChild();
					tempRoot = tempRoot.getRightChild();
				}
			} else {
				if (childOfTemp.getLeftChild() != null) {
					childOfTemp = childOfTemp.getLeftChild();
					tempRoot = tempRoot.getLeftChild();
				}
			}
			comparison = tempRoot.getValue().compareTo(childOfTemp.getValue());
		}
		return nodeToRemove.getValue();
	}

	@Override
	public void clear() {
		root = null;
		root = new Node<>();
		accumulator = 0;
	}

	@Override
	public int getSize() {
		return getSize(root);
	}

	public int getSize(Node<T> node) {
//		if (node == null) { // primitive stopping condition
//			return 0;
//		} else { // recursive case
//			return getSize(node.getLeftChild()) + 1 + getSize(node.getRightChild());
//		}
		return accumulator;
	}

	@Override
	public List<Data<T>> removeAllIntoSortedList() {
		// Heap Sort
		List<Data<T>> sortedList = new ArrayList<>();
		while (root.getLeftChild() != null && root.getRightChild() != null && root != null) {
			sortedList.add(remove());
		}
		return sortedList;
	}

	@Override
	public String toString() {
		return toString(root);
	}

	private String toString(Node<T> node) {
		if (node == null) {
			return "";
		} else {
			return toString(node.getLeftChild()) + node.getValue() + ","
					+ toString(node.getRightChild()).replaceAll(",,", ",");
		}
	}
//		int[] values = new int[getSize()];
//		Node<T> current = root;
//		for (int n = 0; n < getSize(); n++) {
//		while (current.getLeftChild() != null && current.getRightChild() != null && current != null) {
//			values[n] = current;
//		}
//		}
//
//
//			String output = "";
//			int depth = 0;
//			int arraySpots = getSize();
//
//			while (arraySpots > 0) {
//				arraySpots /= 2;
//				++depth;
//			}
//
//			int maxWidth = (int) (Math.pow(2, depth));
//			int charWidth = 4 * maxWidth;
//			int index = 0;
//
//			for (int i = 0; i < depth; ++i) {
//				int level = (int) Math.pow(2, i);
//				for (int j = 0; j < level; ++j) {
//					int preSpace = (int) ((charWidth / (Math.pow(2, (i + 1))) - 1));
//
//					for (int k = 0; k < preSpace; ++k) {
//						output += " ";
//					}
//					output += values[i];//wrong
//					++index;
//
//					if (index >= getSize()) {
//						output += "\n";
//						break;
//					}
//
//					for (int k = 0; k < preSpace; ++k) {
//						output += " ";
//					}
//				}
//				output += "\n\n";
//			}
//			return output;
//		}
}
