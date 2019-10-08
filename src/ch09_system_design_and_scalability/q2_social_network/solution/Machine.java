package ch09_system_design_and_scalability.q2_social_network.solution;

import java.util.HashMap;

public class Machine {
	private String IpAddress;
	private String machineName;
	private HashMap<Integer, Person> persons = new HashMap<>();

	public Machine(String ip, String name) {
		machineName = name;
		IpAddress = ip;
	}

	public Person getPersonWithId(int personId) {
		return persons.get(personId);
	}

	public void addPerson(Person p) {
		persons.put(p.getID(), p);
	}

	public String getIpAddress() {
		return IpAddress;
	}

	public String getMachineName() {
		return machineName;
	}

}
