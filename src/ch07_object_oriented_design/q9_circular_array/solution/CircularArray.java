package ch07_object_oriented_design.q9_circular_array.solution;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
	public T[] items;
	private int head = 0;

	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}

	public int convert(int index) {
		if (index < 0) {
			index += items.length;
		}

		return (head + index) % items.length;
	}

	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}

	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new IndexOutOfBoundsException();
		}

		return items[convert(i)];
	}

	public void set(int i, T item) {
		items[convert(i)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}
	
	
}
