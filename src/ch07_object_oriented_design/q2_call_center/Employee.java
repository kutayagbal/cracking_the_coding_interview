package ch07_object_oriented_design.q2_call_center;

public class Employee {
	private String name;
	private long id;
	private EmployeeType empType;

	public Employee(String name, EmployeeType empType) {
		this.empType = empType;
		this.name = name;
		this.id = IdGenerator.getInstance().getNextId();
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public EmployeeType getEmpType() {
		return empType;
	}

}
