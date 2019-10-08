package ch04_trees_and_graphs.q7_build_order.solution;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	private int dependencies = 0;
	private State state;

	public enum State {
		BLANK, PARTIAL, COMPLETED
	}

	public Project(String name) {
		this.name = name;
		this.state = State.BLANK;
	}

	public void addNeigbor(Project node) {
		if (!map.containsKey(node.name)) {
			children.add(node);
			map.put(node.name, node);
			node.incrementDependencies();
		}
	}

	public void incrementDependencies() {
		dependencies++;
	}

	public void decrementDependencies() {
		dependencies--;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Project> getChildren() {
		return children;
	}

	public int getNumberDependencies() {
		return dependencies;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
