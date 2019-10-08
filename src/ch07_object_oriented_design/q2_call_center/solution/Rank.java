package ch07_object_oriented_design.q2_call_center.solution;

public enum Rank {
	Responder(0), Manager(1), Director(2);

	private int value;

	private Rank(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}
}
