package ch09_system_design_and_scalability.q2_social_network.solution;

import java.util.HashMap;

public class Server {

	HashMap<Integer, Machine> machines = new HashMap<>();
	HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

	public Machine getMachineWithId(int machineId) {
		return machines.get(machineId);
	}

	public int getMachineIdForUser(int personId) {
		Integer machineId = personToMachineMap.get(personId);
		return machineId == null ? -1 : machineId;
	}

	public Person getPersonWithId(int personId) {
		Integer machineId = personToMachineMap.get(personId);
		if (machineId == null)
			return null;

		Machine machine = machines.get(machineId);
		if (machine == null)
			return null;

		return machine.getPersonWithId(personId);
	}
}
