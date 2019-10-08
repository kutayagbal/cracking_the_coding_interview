package ch04_trees_and_graphs.q11_random_node;

import java.util.Random;

public class BinarySearchTreeWithRandomNode {
	BSTNode root;
	private BSTNode nodesListHead;
	private BSTNode nodesListTail;
	private int nodeCount;

	public BinarySearchTreeWithRandomNode(int value) {
		this.root = new BSTNode(value);
		this.nodesListHead = this.root;
		this.nodesListTail = this.nodesListHead;
		nodeCount++;
	}

	public void print() {
		System.out.println();
		System.out.println("node count = " + nodeCount);
		printTree(this.root);
		printList();
	}

	private void printList() {
		BSTNode curr = nodesListHead;
		System.out.print("List: ");
		while (curr != null) {
			System.out.print(curr.value + ", ");
			curr = curr.next;
		}
		System.out.println();
		System.out.println();
	}

	// O(n)
	// O(log(n))
	private void printTree(BSTNode node) {
		if (node == null) {
			return;
		}

		if (node.left != null && node.right != null) {
			System.out.println(node.value + " => " + node.left.value + " , " + node.right.value);
		} else if (node.right != null) {
			System.out.println(node.value + " =>   , " + node.right.value);
		} else if (node.left != null) {
			System.out.println(node.value + " => " + node.left.value + " , ");
		} else {
			System.out.println(node.value + " =>  ,");
		}

		printTree(node.left);
		printTree(node.right);
	}

	public void insert(int value) {
		BSTNode node = new BSTNode(value);
		node.prev = this.nodesListTail;
		this.nodesListTail.next = node;
		this.nodesListTail = node;

		insertToBST(this.root, node);
		nodeCount++;
	}

	// O(log(n))
	// O(log(n))
	private void insertToBST(BSTNode node, BSTNode newNode) {
		if (newNode.value < node.value) {
			if (node.left == null) {
				node.left = newNode;
				newNode.parent = node;
				return;
			}

			insertToBST(node.left, newNode);
		} else if (newNode.value >= node.value) {
			if (node.right == null) {
				node.right = newNode;
				newNode.parent = node;
				return;
			}

			insertToBST(node.right, newNode);
		}
	}

	// O(log(n))
	// O(log(n))
	public BSTNode find(int value) {
		return findInTree(this.root, value);
	}

	// O(log(n))
	// O(log(n))
	private BSTNode findInTree(BSTNode node, int value) {
		if (node == null) {
			return null;
		}

		if (value > node.value) {
			return findInTree(node.right, value);
		} else if (value < node.value) {
			return findInTree(node.left, value);
		} else {
			return node;
		}
	}

	public boolean delete(int value) {
		return delete(this.root, value);
	}

	// O(log(n)) finding in tree
	// O(log(n)) call stack for two children
	private boolean delete(BSTNode root, int value) {
		BSTNode node = findInTree(root, value);

		if (node == null) {// not found in tree
			return false;
		}

		if (node.left == null && node.right == null) { // no children
			if (node.parent == null) {
				root = null;
			} else {
				if (node.parent.left == node) {
					node.parent.left = null;
				} else {
					node.parent.right = null;
				}
			}

			deleteFromLinkedList(node);
			nodeCount--;
		} else {
			if (node.left == null || node.right == null) { // one child
				if (node.parent == null) {
					if (node.right != null) {
						root = node.right;
					} else {
						root = node.left;
					}

					root.parent = null;
				} else {
					if (node.right != null) {
						if (node.parent.right == node) {
							node.parent.right = node.right;
						} else {
							node.parent.left = node.right;
						}
						node.right.parent = node.parent;
					} else {
						if (node.parent.right == node) {
							node.parent.right = node.left;
						} else {
							node.parent.left = node.left;
						}
						node.left.parent = node.parent;
					}
				}
				deleteFromLinkedList(node);
				nodeCount--;
			} else { // two children
				BSTNode subMin = getMinimumOfSubTree(node.right);
				node.value = subMin.value;

				delete(node.right, subMin.value);
			}
		}

		return true;
	}

	// O(1)
	// O(1)
	private void deleteFromLinkedList(BSTNode node) {
		if (node == nodesListHead) {
			nodesListHead = nodesListHead.next;
			return;
		}

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			nodesListHead = node.next;
			nodesListHead.prev = null;
		}

		if (node.next == null) {
			nodesListTail = node;
		}
	}

	// O(log(n))
	// O(1)
	private BSTNode getMinimumOfSubTree(BSTNode node) {
		while (node.left != null) {
			node = node.left;
		}

		return node;
	}

	// O(n)
	// O(1)
	public BSTNode getRandomNode() {
		int index = new Random().nextInt(nodeCount);

		BSTNode curr = nodesListHead;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}

		return curr;
	}
}
