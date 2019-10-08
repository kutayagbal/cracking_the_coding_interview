package ch07_object_oriented_design.q2_call_center;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	private static IdGenerator _instance;
	private AtomicInteger atomicInteger;

	private IdGenerator(int initialValue) {
		this.atomicInteger = new AtomicInteger(initialValue);
	}

	public static IdGenerator getInstance() {
		if (_instance == null) {
			_instance = new IdGenerator(100);
		}
		return _instance;
	}
	
	public int getNextId() {
		return atomicInteger.getAndIncrement();
	}

}
