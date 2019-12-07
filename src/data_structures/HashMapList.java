package data_structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<K, V> {
	private HashMap<K, ArrayList<V>> map = new HashMap<>();

	// Insert item into list at key
	public void put(K key, V value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}

		map.get(key).add(value);
	}

	// Insert list of items at key
	public void put(K key, ArrayList<V> values) {
		map.put(key, values);
	}

	// Get lsit of items at key
	public ArrayList<V> get(K key) {
		return map.get(key);
	}

	// Check if hashmaplist contains key
	public boolean containsKey(K key) {
		return map.containsKey(key);
	}

	// Check if list at key contains value
	public boolean containsKeyValue(K key, V value) {
		ArrayList<V> l = map.get(key);
		if (l == null)
			return false;

		return l.contains(value);
	}

	// Get the list of keys
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public String toString() {
		return map.toString();
	}
}
