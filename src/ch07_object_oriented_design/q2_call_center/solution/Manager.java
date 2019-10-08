package ch07_object_oriented_design.q2_call_center.solution;

public class Manager extends Employee {
	public Manager(CallHandler handler) {
		super(handler);
		rank = Rank.Manager;
	}
}
