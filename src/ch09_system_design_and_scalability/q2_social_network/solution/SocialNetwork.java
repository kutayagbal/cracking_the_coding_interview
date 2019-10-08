package ch09_system_design_and_scalability.q2_social_network.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SocialNetwork {

	public static void main(String[] args) {

	}

	public LinkedList<Person> findPathBidirectionalBFS(HashMap<Integer, Person> people, int source, int destination) {

		BFSData sourceData = new BFSData(people.get(source));
		BFSData destData = new BFSData(people.get(destination));

		while (!sourceData.isFinished() && !destData.isFinished()) {
			/* Search out from source. */
			Person collision = searchLevel(people, sourceData, destData);

			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getID());
			}

			/* Search out from destination */
			collision = searchLevel(people, destData, sourceData);

			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getID());
			}
		}

		return null;
	}

	private Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {
		/*
		 * We only want to search one level at a time. Count how many nodes are
		 * currently in the primary's level and only do that many nodes. We'll continue
		 * to add nodes to the end.
		 */

		int count = primary.toVisit.size();
		for (int i = 0; i < count; i++) {
			/* Pull out first node */
			PathNode pathNode = primary.toVisit.poll();
			int personId = pathNode.getPerson().getID();

			/* Check if it's already been visited */
			if (secondary.visited.containsKey(personId)) {
				return pathNode.getPerson();
			}

			/* Add friends to queue */
			Person person = pathNode.getPerson();
			ArrayList<Integer> friends = person.getFriends();

			for (int friendId : friends) {
				if (!primary.visited.containsKey(friendId)) {
					Person friend = people.get(friendId);
					PathNode next = new PathNode(friend, pathNode);
					primary.visited.put(friendId, next);
					primary.toVisit.add(next);
				}
			}
		}

		return null;
	}

	private LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
		/* Merge paths where searches met at connection. */
		PathNode end1 = bfs1.visited.get(connection); // end1 -> source
		PathNode end2 = bfs2.visited.get(connection); // end2 -> dest

		LinkedList<Person> pathOne = end1.collapse(false);
		LinkedList<Person> pathTwo = end2.collapse(true); // reverse

		pathTwo.removeFirst(); // remove connection
		pathOne.addAll(pathTwo); // add second path

		return pathOne;
	}
}
