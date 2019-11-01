package ui;

import model.Tree;
import model.Treeable;

public class Main {

	public static void main(String[] args) {
		Treeable<Integer> tree = new Tree<>();
		tree.insert(5);
		tree.insert(10);
		tree.insert(2);
		tree.insert(23);
		tree.insert(12);
		tree.insert(7);
		tree.insert(-1);
		tree.insert(81000);
		System.out.println(tree);
		System.out.println(tree.find(23));
		System.out.println(tree.contains(19));
		System.out.println(tree.contains(5));
		System.out.println(tree.getMinValue());
		System.out.println(tree.getMaxValue());
		System.out.println(tree.getSize());
		tree.remove(12);
		tree.remove(5);
		tree.remove(10);
		tree.insert(5);
		System.out.println(tree);
		System.out.println(tree.getSize());
		tree.clear();
		System.out.println(tree);
		System.out.println(tree.getSize());
	}
}
