package ch07_object_oriented_design.q2_call_center;

import java.util.LinkedList;

public class CallCenter {
	private LinkedList<Employee> availableRespondentQueue = new LinkedList<>();
	private LinkedList<Employee> availableManagerQueue = new LinkedList<>();
	private LinkedList<Employee> availableDirectorQueue = new LinkedList<>();
	private LinkedList<Call> waitingCallQueue = new LinkedList<>();

	private static CallCenter _instance;

	public static CallCenter getInstance() {
		if (_instance == null) {
			_instance = new CallCenter();
		}

		return _instance;
	}

	public void dispatchCall(Call call) {
		if (availableRespondentQueue.isEmpty()) {
			if (availableManagerQueue.isEmpty()) {
				if (availableDirectorQueue.isEmpty()) {
					System.out.println("no awailable employee. " + call.getCallerPhone() + " added to waiting list");
					waitingCallQueue.add(call);
				} else {
					call.assignRespondent(availableDirectorQueue.removeFirst());
				}
			} else {
				call.assignRespondent(availableManagerQueue.removeFirst());
			}
		} else {
			call.assignRespondent(availableRespondentQueue.removeFirst());
		}
	}

	public void releaseEmployee(Employee respondent) {
		if (respondent.getEmpType() == EmployeeType.Respondent) {
			availableRespondentQueue.add(respondent);
		} else if (respondent.getEmpType() == EmployeeType.Manager) {
			availableManagerQueue.add(respondent);
		} else if (respondent.getEmpType() == EmployeeType.Director) {
			availableDirectorQueue.add(respondent);
		} else {
			return;
		}

		if (!waitingCallQueue.isEmpty()) {
			dispatchCall(waitingCallQueue.removeFirst());
		}
	}

	public void addEmployee(Employee e) {
		if (e.getEmpType() == EmployeeType.Respondent) {
			availableRespondentQueue.add(e);
		} else if (e.getEmpType() == EmployeeType.Manager) {
			availableManagerQueue.add(e);
		} else if (e.getEmpType() == EmployeeType.Director) {
			availableDirectorQueue.add(e);
		}
	}

}
