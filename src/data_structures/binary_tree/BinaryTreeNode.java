package data_structures.binary_tree;

public class BinaryTreeNode<E> {
	public E value;
	public BinaryTreeNode<E> left;
	public BinaryTreeNode<E> right;
	public BinaryTreeNode<E> parent;
	public boolean marked = false;

	public BinaryTreeNode(E value) {
		this.value = value;
	}
	
	public BinaryTreeNode(E value, BinaryTreeNode<E> parent) {
		this.parent = parent;
		this.value = value;
	}
}
