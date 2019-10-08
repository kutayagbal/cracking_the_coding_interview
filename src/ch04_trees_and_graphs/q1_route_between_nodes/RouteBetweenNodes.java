package ch04_trees_and_graphs.q1_route_between_nodes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RouteBetweenNodes {

	public static void main(String[] args) {
		Node[] nodes = createRandomIntDirectedGraph(10, 4, 10);
		printGraph(nodes);
		
		Node start = nodes[new Random().nextInt(10)];
		Node end = nodes[new Random().nextInt(10)];
		
		while(start == end) {
			end = nodes[new Random().nextInt(10)];
		}
		
		System.out.println("start=" + start.id);
		System.out.println("end=" + end.id);
		System.out.println(findRoute(start, end));
	}

	static Node[] createRandomIntDirectedGraph(int nodeCount, int adjacentCountBound, int valueBound) {
		Node[] nodes = new Node[nodeCount];

		for (int i = 0; i < nodeCount; i++) {
			nodes[i] = new Node("N" + i, new Random().nextInt(valueBound));
		}

		for (int i = 0; i < nodeCount; i++) {
			Node cur = nodes[i];
			int adjCount = new Random().nextInt(adjacentCountBound);
			cur.adjacents = new Node[adjCount];

			ArrayList<Node> selectedAdjList = new ArrayList<Node>();
			selectedAdjList.add(cur);
			for (int j = 0; j < adjCount; j++) {
				int adjIndex = new Random().nextInt(nodeCount);
				Node adj = nodes[adjIndex];
				while (selectedAdjList.contains(adj)) {
					adjIndex = new Random().nextInt(nodeCount);
					adj = nodes[adjIndex];
				}
				selectedAdjList.add(adj);
				cur.adjacents[j] = adj;
			}
		}

		return nodes;
	}

	static void printGraph(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			Node n = nodes[i];
			System.out.print(n.id + "(" + n.value + ") -> ");
			for (int j = 0; j < n.adjacents.length; j++) {
				Node adj = n.adjacents[j];
				System.out.print(adj.id + "(" + adj.value + "),");
			}
			System.out.println();
		}
	}

	static boolean findRoute(Node start, Node end) {//BFS
		Stack<Node> queue = new Stack<Node>();
		start.visited = true;
		queue.add(start);

		Node n = null;
		while (!queue.isEmpty()) {
			n = queue.firstElement();
			queue.remove(0);

			if (n == end) {
				return true;
			}

			for (int i = 0; i < n.adjacents.length; i++) {
				Node adj = n.adjacents[i];
				if (!adj.visited) {
					adj.visited = true;
					queue.add(adj);
				}
			}
		}

		return false;
	}

	public static class Node {
		String id;
		boolean visited;
		Node[] adjacents;
		int value;

		public Node(String id, int value) {
			this.id = id;
			this.value = value;
		}
	}
}
