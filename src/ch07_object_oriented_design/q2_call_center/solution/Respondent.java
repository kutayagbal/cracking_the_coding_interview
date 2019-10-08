package ch07_object_oriented_design.q2_call_center.solution;

public class Respondent extends Employee {
	public Respondent(CallHandler handler) {
		super(handler);
		rank = Rank.Responder;
	}
}
