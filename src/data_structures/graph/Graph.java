package data_structures.graph;

import java.util.ArrayList;

public class Graph<E> {
	public ArrayList<GraphNode<E>> nodes;
	
	public Graph() {
		this.nodes = new ArrayList<GraphNode<E>>();
	}
}
