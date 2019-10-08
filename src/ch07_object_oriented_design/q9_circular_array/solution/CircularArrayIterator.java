package ch07_object_oriented_design.q9_circular_array.solution;

import java.util.Iterator;

public class CircularArrayIterator<T> implements Iterator<T> {
	/*
	 * current reflects the offset from the rotated head, not from the actual start
	 * of the raw array.
	 */
	private int current = -1;
	private CircularArray<T> arr;

	public CircularArrayIterator(CircularArray<T> array) {
		arr = array;
	}

	@Override
	public boolean hasNext() {
		return current < arr.items.length - 1;
	}

	@Override
	public T next() {
		current++;
		return (T) arr.items[arr.convert(current)];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
