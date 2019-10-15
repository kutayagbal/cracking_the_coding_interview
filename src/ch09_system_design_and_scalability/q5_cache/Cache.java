package ch09_system_design_and_scalability.q5_cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class Cache {
	private Map<String, Node> cacheMap;
	private Node head, tail;
	private int cacheSize;
	private int maxCacheSize;

	public Cache(int size) {
		cacheMap = new HashMap<String, Node>();
		maxCacheSize = size;
	}

	public String[] search(String query) {
		Node resultNode = cacheMap.get(query);

		if (resultNode != null) {
			System.out.println("Retrieving from cache... " + query);
			moveNodeToHead(resultNode);
		} else {
			System.out.println("Retrieving from DB... " + query);
			resultNode = processSearch(query);
			putToHead(resultNode);
			purgeLast();
			cacheMap.put(query, resultNode);
			cacheSize++;
		}

		return resultNode.results;
	}

	private void putToHead(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	private void purgeLast() {
		if (cacheSize > maxCacheSize) {
			System.out.println("Purging " + tail.query + " ....");
			
			cacheMap.remove(tail.query);
			
			tail.prev.next = null;
			tail = tail.prev;
		}
	}

	private void moveNodeToHead(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
			
			if(node.next != null)
				node.next.prev = node.prev;
			else { // node was tail
				tail = tail.prev;
			}
			
			node.next = head;
			head.prev = node;
			head = node;
			head.prev = null;
		}
	}

	private Node processSearch(String query) {
		return new Node(query, createRandomStringArr());
	}

	private String[] createRandomStringArr() {
		String[] arr = new String[new Random().nextInt(10) + 1];
		IntStream.range(0, arr.length).forEach(i -> arr[i] = java.lang.String.valueOf((new Random().nextInt(100))));
		return arr;
	}
}
