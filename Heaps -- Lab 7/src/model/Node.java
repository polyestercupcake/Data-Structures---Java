package model;

public class Node<T extends Comparable<T>> {
	private Node<T> leftChild;
	private Node<T> rightChild;
	private Node<T> parent;
	private Data<T> value;

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Data<T> getValue() {
		return value;
	}

	public void setValue(Data<T> value) {
		this.value = value;
	}
}
