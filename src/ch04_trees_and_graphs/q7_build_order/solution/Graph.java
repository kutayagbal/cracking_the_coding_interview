package ch04_trees_and_graphs.q7_build_order.solution;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();

	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}

		return map.get(name);
	}

	public void addEdge(String startName, String endName) {
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		
		start.addNeigbor(end);
	}
	
	public ArrayList<Project> getNodes() {
		return nodes;
	}
}
