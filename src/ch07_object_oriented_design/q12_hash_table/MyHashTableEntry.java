package ch07_object_oriented_design.q12_hash_table;

public class MyHashTableEntry<K, V> {
	private K key;
	private V value;

	public MyHashTableEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
