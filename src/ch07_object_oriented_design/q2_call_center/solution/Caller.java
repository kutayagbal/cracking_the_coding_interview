package ch07_object_oriented_design.q2_call_center.solution;

public class Caller {
	private String name;
	private String phoneNumber;

	public Caller(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
