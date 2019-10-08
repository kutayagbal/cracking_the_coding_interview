package ch07_object_oriented_design.q2_call_center.solution;

public class Director extends Employee {
	public Director(CallHandler handler) {
		super(handler);
		rank = Rank.Director;
	}
}
