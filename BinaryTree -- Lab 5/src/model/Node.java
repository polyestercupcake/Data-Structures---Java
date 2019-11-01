package model;

public class Node<T> {
	private T value;
	private Node<T> rightChild;
	private Node<T> leftChild;
	private Node<T> parent;
	
	@Override
	public String toString() {
		return value.toString();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
}
