package model;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> implements Heapable<T> {

	private Node<T> root = new Node<>();
	private int accumulator = 0; // for keeping track of insertion point

	/**
	 * This method will insert nodes into a Priority Max Heap. It also has
	 * functionality to sort the nodes into correct order once the insertion is
	 * made.
	 */
	@Override
	public void insert(Data<T> value) {

		if (value == null || value.getValue() == null || value.getPriority() > 10 || value.getPriority() < 1)
			return;
		else {
			Node<T> parent = root;
			Node<T> nodeToInsert = new Node<>();
// BASE CASE (insertion of root)
			if (root.getValue() == null) {
				root.setValue(value);
				accumulator++;
			} else {
				accumulator++;
// CONVERT TO BINARY, FIND THE POSITION, and MAKE THE CONNECTION
				// set parent to this so parent will not be root when called method is returned
				parent = findInsertionPoint(parent, nodeToInsert, value);
				trickleUp(parent, nodeToInsert);
			}
		}
	}

	private Node<T> findInsertionPoint(Node<T> parent, Node<T> nodeToInsert, Data<T> value) {
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
		return parent;
	}

	/**
	 * Used to help with the sorting in my insert method.
	 * 
	 * @param parent
	 * @param nodeToInsert
	 */
	private void trickleUp(Node<T> parent, Node<T> nodeToInsert) {
		// compareTo() the current and parent priorities
		int comparison = nodeToInsert.getValue().compareTo(parent.getValue());
//SORT IT
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

	/**
	 * 
	 * This method will remove nodes into a Priority Max Heap. It also has
	 * functionality to sort the nodes into correct order once the removal is made.
	 * --Pseudocode-- Remove root (only removes the root) Take most recent inserted
	 * value and make it the root (that node is now gone = disconnect) Compare side
	 * that has the greater value of the 2 children on level 2, swap them Keep
	 * comparing on that side until value is in correct position in heap When
	 * swapping down and the two children are ==, just choose a side to swap
	 *
	 */
	@Override
	public Data<T> remove() {
		Node<T> nodeToRemove = new Node<>();
		nodeToRemove.setValue(root.getValue());
		Node<T> parent = root;
// FIND NODE TO MOVE TO ROOT POSITION
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			root.setValue(null);
			accumulator--;
		} else {
			// set parent to this so parent will not be root when called method is returned
			parent = findRemovalPoint(parent, nodeToRemove);
			accumulator--;
			trickleDown(parent, nodeToRemove);
		}
		return nodeToRemove.getValue();
	}

	private Node<T> findRemovalPoint(Node<T> parent, Node<T> nodeToRemove) {
		String n = String.format(Integer.toBinaryString(accumulator)).replace(' ', '0');
		// removes first binary number
		n = n.substring(1);
		// if counter is 1 and we substring it, this will catch the null
		if (n.equals("")) {
			root.setValue(root.getLeftChild().getValue());
			root.setLeftChild(null);
		}
		char[] binArray = n.toCharArray();
		for (char binNum : binArray) {
			if (binNum == '1') {
				parent = parent.getRightChild();
				if (parent.getLeftChild() == null) {
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
		return parent;
	}

	/**
	 * Used to help with the sorting in my remove method.
	 * 
	 * @param parent
	 * @param nodeToRemove
	 */
	private void trickleDown(Node<T> parent, Node<T> nodeToRemove) {
		// needed a better naming convention for the 2nd part of the method
		Node<T> tempRoot = root;
		Node<T> childOfTemp = parent;
		// BASE CASE
		if (tempRoot.getValue() == childOfTemp.getValue()) {
			return;
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
		// SORT IT
		// If inserted value > parent, swap them
		while (comparison < 0) { // once they are in correct position, comparison will kick out a negative value
			swap(tempRoot, childOfTemp);
			// resetting nodes to traverse down the tree
//BUG HERE SOMEWHERE
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
	}

	/**
	 * Makes life easier when swapping any two nodes.
	 * 
	 * @param one is node1
	 * @param two is node2
	 */
	public void swap(Node<T> one, Node<T> two) {
		Data<T> temp = one.getValue();
		one.setValue(two.getValue());
		two.setValue(temp);
	}

	@Override
	public void clear() {
		root = null;
		root = new Node<>();
		accumulator = 0;
	}

	@Override
	public int getSize() {
		return accumulator;
	}

	/**
	 * This is essentially Heap Sort. It consequently removes all nodes in the
	 * Priority Heap.
	 */
	@Override
	public List<Data<T>> removeAllIntoSortedList() {
		List<Data<T>> sortedList = new ArrayList<>();
		while (getSize() > 0) {
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
}
//int[] values = new int[getSize()];
//Node<T> current = root;
//for (int n = 0; n < getSize(); n++) {
//while (current.getLeftChild() != null && current.getRightChild() != null && current != null) {
//	values[n] = current;
//}
//}
//
//
//	String output = "";
//	int depth = 0;
//	int arraySpots = getSize();
//
//	while (arraySpots > 0) {
//		arraySpots /= 2;
//		++depth;
//	}
//
//	int maxWidth = (int) (Math.pow(2, depth));
//	int charWidth = 4 * maxWidth;
//	int index = 0;
//
//	for (int i = 0; i < depth; ++i) {
//		int level = (int) Math.pow(2, i);
//		for (int j = 0; j < level; ++j) {
//			int preSpace = (int) ((charWidth / (Math.pow(2, (i + 1))) - 1));
//
//			for (int k = 0; k < preSpace; ++k) {
//				output += " ";
//			}
//			output += values[i];//wrong
//			++index;
//
//			if (index >= getSize()) {
//				output += "\n";
//				break;
//			}
//
//			for (int k = 0; k < preSpace; ++k) {
//				output += " ";
//			}
//		}
//		output += "\n\n";
//	}
//	return output;
//}