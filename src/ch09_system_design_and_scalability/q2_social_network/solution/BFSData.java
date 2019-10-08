package ch09_system_design_and_scalability.q2_social_network.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {

	public Queue<PathNode> toVisit = new LinkedList<PathNode>();
	public HashMap<Integer, PathNode> visited = new HashMap<>();

	public BFSData(Person root) {
		PathNode sourcePath = new PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root.getID(), sourcePath);
	}

	public boolean isFinished() {
		return toVisit.isEmpty();
	}

}
