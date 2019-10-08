package ch07_object_oriented_design.q12_hash_table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashTable<K, V> {
	private static final int CAPACITY = 10;
	private List<LinkedList<MyHashTableEntry<K, V>>> table;

	public MyHashTable() {
		table = new ArrayList<>();
	}

	public void put(K key, V value) {
		int index = hash(key);

		MyHashTableEntry<K, V> entry = new MyHashTableEntry<K, V>(key, value);
		table.get(index).add(entry);
	}

	public V get(K key) {
		int index = hash(key);

		LinkedList<MyHashTableEntry<K, V>> linkedList = table.get(index);

		Iterator<MyHashTableEntry<K, V>> it = linkedList.iterator();
		while (it.hasNext()) {
			MyHashTableEntry<K, V> e = (MyHashTableEntry<K, V>) it.next();
			if (e.getKey().equals(key)) {
				return e.getValue();
			}
		}

		return null;
	}

	public boolean remove(K key) {
		int index = hash(key);

		LinkedList<MyHashTableEntry<K, V>> linkedList = table.get(index);

		Iterator<MyHashTableEntry<K, V>> it = linkedList.iterator();
		while (it.hasNext()) {
			MyHashTableEntry<K, V> e = (MyHashTableEntry<K, V>) it.next();
			if (e.getKey().equals(key)) {
				it.remove();
				return true;
			}
		}

		return false;

	}

	private int hash(K key) {
		if (key instanceof Integer) {
			return (Integer) key % CAPACITY;
		}

		return -1;
	}
}
