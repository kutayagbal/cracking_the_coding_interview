package ch04_trees_and_graphs.q7_build_order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;

public class BuildOrder {

	public static void main(String[] args) {
		char[] projectArr = "abcdefghij".toCharArray();
		ArrayList<HashMap<Character, Character>> dependencies = createRandomDependencyList(projectArr, 3);
		ArrayList<Project> projectList = createProjectList(projectArr, dependencies);

		ArrayList<Project> buildOrder = buildOrder(projectList);
		if (buildOrder == null) {
			System.out.println("There is a loop");
		} else {
			System.out.println();
			for (Project p : buildOrder) {
				System.out.print(p.name + " ,");
			}
		}
	}

	private static ArrayList<Project> buildOrder(ArrayList<Project> projectList) {
		if (projectList.size() == 0) {
			return new ArrayList<Project>();
		}

		ArrayList<Project> resultList = new ArrayList<>();

		// set incoming counts
		for (Project p : projectList) {
			for (Project dep : p.dependencies) {
				dep.incomingCount++;
			}
		}

		// add independents to processNext queue.
		ArrayList<Project> processNextQueue = new ArrayList<>();
		for (Project p : projectList) {
			if (p.incomingCount == 0) {
				processNextQueue.add(p);
			}
		}

		while (!processNextQueue.isEmpty()) {
			Project curr = processNextQueue.remove(processNextQueue.size() - 1);// remove last, because of shifting.

			for (Project dep : curr.dependencies) {
				dep.incomingCount--;

				if (dep.incomingCount == 0) {
					processNextQueue.add(dep);
				}
			}

			resultList.add(curr);
		}

		if (resultList.size() != projectList.size()) {
			return null;// there is cycle
		}

		return resultList;
	}

	private static ArrayList<Project> createProjectList(char[] projectArr,
			ArrayList<HashMap<Character, Character>> dependencies) {
		if (projectArr == null || projectArr.length == 0) {
			return new ArrayList<Project>();
		}

		HashMap<String, Project> projectMap = new HashMap<String, Project>();
		for (char n : projectArr) {
			Project p = new Project(String.valueOf(n));
			projectMap.put(String.valueOf(n), p);
		}

		ArrayList<Project> projectList = new ArrayList<Project>();

		for (Entry<String, Project> projectEntry : projectMap.entrySet()) {
			for (HashMap<Character, Character> depMap : dependencies) {
				for (Entry<Character, Character> dep : depMap.entrySet()) {
					if (String.valueOf(dep.getValue()).equals(projectEntry.getKey())) {
						projectEntry.getValue().dependencies.add(projectMap.get(String.valueOf(dep.getKey())));
					}
				}
			}

			projectList.add(projectEntry.getValue());
		}

		return projectList;
	}

	private static ArrayList<HashMap<Character, Character>> createRandomDependencyList(char[] projectArr,
			int dependencyBound) {
		ArrayList<HashMap<Character, Character>> depList = new ArrayList<>();

		for (int i = 0; i < projectArr.length; i++) {
			char node = projectArr[i];
			int dependencyCount = new Random().nextInt(dependencyBound);

			HashSet<Integer> used = new HashSet<Integer>();
			for (int j = 0; j < dependencyCount; j++) {
				int depIndex = new Random().nextInt(10);

				if (depIndex == i || used.contains(depIndex)) {// one random try, if ok add dependency if not go on.
					continue;
				}

				char dependency = projectArr[depIndex];

				HashMap<Character, Character> map = new HashMap<Character, Character>();
				System.out.println(node + " --> " + dependency);
				map.put(dependency, node);
				used.add(depIndex);
				depList.add(map);
			}
		}

		return depList;
	}

	private static class Project {
		String name;
		int incomingCount = 0;
		ArrayList<Project> dependencies;

		public Project(String name) {
			this.name = name;
			this.dependencies = new ArrayList<Project>();
		}
	}

}
