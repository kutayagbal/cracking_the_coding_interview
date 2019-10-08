package ch04_trees_and_graphs.q1_route_between_nodes.solution;

import java.util.LinkedList;

public class RouteBetweenNodes {

	public static void main(String[] args) {

	}

	private static enum State {
		Unvisited, Visiting, Visited
	}

	static boolean search(Graph g, Node start, Node end) {
		if(start == end)
			return true;
		
		//operates as Queue
		LinkedList<Node> q = new LinkedList<Node>();
		
		for(Node u : g.nodes) {
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		
		Node u;
		
		while(!q.isEmpty()) {
			u = q.removeFirst(); //i.e. dequeue
			if(u != null) {
				for(Node v : u.getAdjacent()) {
					if(v.state == State.Unvisited) {
						if(v == end) {
							return true;
						}else {
							v.state = State.Visiting;
							q.addLast(v);
						}
					}
				}
				
				u.state = State.Visited;
			}
		}
		
		return false;
		
	}

	public static class Node {
		State state;
		private Node[] adjacent;

		public Node[] getAdjacent() {
			return adjacent;
		}
	}

	public static class Graph {
		Node[] nodes;
	}
}
