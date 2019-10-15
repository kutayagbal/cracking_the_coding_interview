package ch09_system_design_and_scalability.q5_cache.solution;

import java.util.HashMap;

import ch09_system_design_and_scalability.q5_cache.Node;

public class Cache {
	public static int MAX_SIZE = 10;
	public Node head, tail;
	public HashMap<String, Node> map;
	public int size = 0;
	
	public Cache() {
		map = new HashMap<>();
	}
	
	/*Moves node to front of linked list*/
	public void moveToFront(Node node) {

	}
	
	/*Removes node from linked list*/
	public void removeFromLinkedList(Node node) {

	}
	
	/*Gets results from linked list and updates linked list*/
	public String[] getResults(String query) {
		if(!map.containsKey(query))
			return null;
		
		Node node  = map.get(query);
		moveToFront(node);	//update freshness
		return node.results;
	}
	
	/*Insert results into linked list and hash*/
	public void insertResults(String query, String[] results) {
		if(map.containsKey(query)) {	//update values
			Node node = map.get(query);
			node.results = results;
			moveToFront(node);	//update freshness
			return;
		}
		
		Node node = new Node(query, results);
		moveToFront(node);
		map.put(query, node);
		
		if(size > MAX_SIZE) {
			map.remove(tail.query);
			removeFromLinkedList(tail);
		}
		
	}
 }
