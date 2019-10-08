package ch09_system_design_and_scalability.q2_social_network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class DoubleBFS {

	public static void main(String... args) {
		GNode n0 = new GNode<String>("n0");
		GNode n1 = new GNode<String>("n1");
		GNode n2 = new GNode<String>("n2");
		GNode n3 = new GNode<String>("n3");
		GNode n4 = new GNode<String>("n4");
		GNode n5 = new GNode<String>("n5");
		GNode n6 = new GNode<String>("n6");
		GNode n7 = new GNode<String>("n7");
		GNode n8 = new GNode<String>("n8");

		n0.adj.add(n1);
		n0.adj.add(n2);
		n0.adj.add(n3);

		n1.adj.add(n0);
		n1.adj.add(n2);
		n1.adj.add(n3);
		n1.adj.add(n4);

		n2.adj.add(n1);
		n2.adj.add(n0);

		n3.adj.add(n0);
		n3.adj.add(n1);
		n3.adj.add(n2);
		n3.adj.add(n4);
		n3.adj.add(n5);

		n4.adj.add(n1);
		n4.adj.add(n3);
		n4.adj.add(n5);
		n4.adj.add(n6);

		n5.adj.add(n3);
		n5.adj.add(n4);
		n5.adj.add(n7);
		n5.adj.add(n8);

		n6.adj.add(n4);

		n7.adj.add(n5);

		n8.adj.add(n5);
		n8.adj.add(n7);

		// isThereAPathBFS(n0, "n6");
		findPathDoubleBFS(n0, n8).stream().forEach(i -> System.out.println(i));
	}

	private static boolean isThereAPathBFS(GNode head, String value) {
		LinkedList<GNode<String>> toVisitQueue = new LinkedList<GNode<String>>();
		toVisitQueue.add(head);

		while (!toVisitQueue.isEmpty()) {
			GNode elem = toVisitQueue.removeFirst();

			if (elem.isProcessed == false) {
				System.out.println("Expending " + elem.val);
				for (GNode<String> child : (List<GNode<String>>) elem.getAdj()) {
					toVisitQueue.add(child);

					if (child.val.equals(value)) {
						return true;
					}
				}
			}

			elem.isProcessed = true;
		}

		return false;
	}

	private static List<String> findPathDoubleBFS(GNode startNode, GNode endNode) {
		LinkedList<PathNode> toVisitFromStartQueue = new LinkedList<PathNode>();
		LinkedList<PathNode> toVisitFromEndQueue = new LinkedList<PathNode>();
		toVisitFromStartQueue.add(new PathNode(startNode, null, null));
		toVisitFromEndQueue.add(new PathNode(endNode, null, null));

		Map<String, PathNode> processedFromStart = new HashMap<String, PathNode>();
		Map<String, PathNode> processedFromEnd = new HashMap<String, PathNode>();

		while (!toVisitFromStartQueue.isEmpty() && !toVisitFromEndQueue.isEmpty()) {
			PathNode elemFromStart = toVisitFromStartQueue.removeFirst();
			PathNode elemFromEnd = toVisitFromEndQueue.removeFirst();

			if (elemFromStart.node.isProcessed == false) {
				System.out.println("Expending from start " + elemFromStart.node.val);
				for (GNode<String> child : (List<GNode<String>>) elemFromStart.node.getAdj()) {
					PathNode n = new PathNode(child, elemFromStart, null);

					toVisitFromStartQueue.add(n);

					if (processedFromEnd.containsKey(n.node.val)) {
						return createPath(n, processedFromEnd.get(n.node.val));
					}
				}

				elemFromStart.node.isProcessed = true;
			}

			processedFromStart.put((String)elemFromStart.node.val, elemFromStart);

			if (elemFromEnd.node.isProcessed == false) {
				System.out.println("Expending from end " + elemFromEnd.node.val);
				for (GNode<String> child : (List<GNode<String>>) elemFromEnd.node.getAdj()) {
					PathNode n = new PathNode(child, null, elemFromEnd);
					toVisitFromEndQueue.add(n);

					if (processedFromStart.containsKey(n.node.val)) {
						return createPath(processedFromStart.get(n.node.val), n);
					}
				}

				elemFromEnd.node.isProcessed = true;
			}

			processedFromEnd.put((String)elemFromEnd.node.val, elemFromEnd);
		}
		
		return new ArrayList<String>();
	}
	
	static List<String> createPath(PathNode start, PathNode end) {
		List<String> path = new ArrayList<String>();
		
		PathNode current = start;
		while(current != null) {
			path.add(0, (String)current.node.val);
			current = current.prev;
		}
		
		current = end.next;
		while(current != null) {
			path.add((String)current.node.val);
			current = current.next;
		}
		
		return path;
	}

	static class GNode<T> {
		List<GNode<T>> adj;
		T val;
		boolean isProcessed = false;

		public GNode(T val) {
			this.val = val;
			this.adj = new ArrayList<GNode<T>>();
		}

		public List<GNode<T>> getAdj() {
			return adj;
		}

		public T getVal() {
			return val;
		}
	}

	static class PathNode {
		GNode node;
		PathNode prev;
		PathNode next;

		public PathNode(GNode node, PathNode prev, PathNode next) {
			this.node = node;
			this.prev = prev;
			this.next = next;
		}

		@Override
		public boolean equals(Object obj) {
			return node.val.equals(((PathNode) obj).node.val);
		}
		
		@Override
		public int hashCode() {
			return node.hashCode();
		}
	}
}
