package ch07_object_oriented_design.q2_call_center;

public class CallCenterSimulator {

	public static void main(String[] args) {
		CallCenter callCenter = CallCenter.getInstance();
		callCenter.addEmployee(new Employee("Kutay", EmployeeType.Respondent));
		callCenter.addEmployee(new Employee("A", EmployeeType.Manager));
		callCenter.addEmployee(new Employee("B", EmployeeType.Director));
		
		Call call = new Call(1);
		callCenter.dispatchCall(call);
		Call call2 = new Call(2);
		callCenter.dispatchCall(call2);
		Call call3 = new Call(3);
		callCenter.dispatchCall(call3);
		Call call4 = new Call(4);
		callCenter.dispatchCall(call4);
		call.releaseRespondent();
	}

}
