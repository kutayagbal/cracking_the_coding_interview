package data_structures.graph;

import java.util.ArrayList;

public class GraphNode<E> {
	public int id;
	public E value;
	public ArrayList<GraphNode<E>> adjacencies;
	
	public GraphNode(int id, E value){
		this.id = id;
		this.value = value;
		this.adjacencies = new ArrayList<GraphNode<E>>();
	}
}
