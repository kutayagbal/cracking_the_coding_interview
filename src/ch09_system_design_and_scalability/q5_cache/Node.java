package ch09_system_design_and_scalability.q5_cache;

public class Node {
	String[] results;
	String query;
	Node next;
	Node prev;

	public Node(String query, String[] results) {
		this.query = query;
		this.results = results;
	}

}
