package ch07_object_oriented_design.q2_call_center;

public class Call {
	private long callerPhone;
	private Employee respondent;

	public Call(long phoneNumber) {
		this.callerPhone = phoneNumber;
	}

	public void assignRespondent(Employee e) {
		System.out.println(callerPhone + " call assigned to " + e.getName());
		this.respondent = e;
	}

	public void releaseRespondent() {
		CallCenter.getInstance().releaseEmployee(respondent);
		System.out.println(callerPhone + " call ended. " + respondent.getName() + " was freed");
		this.respondent = null;
	}

	public long getCallerPhone() {
		return callerPhone;
	}

	public Employee getRespondent() {
		return respondent;
	}

}
