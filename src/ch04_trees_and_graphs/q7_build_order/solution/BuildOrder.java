package ch04_trees_and_graphs.q7_build_order.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Stack;

import ch04_trees_and_graphs.q7_build_order.solution.Project.State;

public class BuildOrder {

	public static void main(String[] args) {
		char[] projectArr = "abcdefghij".toCharArray();
		String[][] dependencies = createRandomDependencyMatrix(projectArr, 3);

		String[] projects = new String[projectArr.length];
		for (int i = 0; i < projectArr.length; i++) {
			projects[i] = String.valueOf(projectArr[i]);
		}

		Project[] ordered = findBuildOrder(projects, dependencies);

		if (ordered == null) {
			System.out.println("There is a loop");
		} else {
			System.out.println();
			for (Project p : ordered) {
				System.out.print(p.getName() + " ,");
			}
		}
		
		System.out.println();
		
		Stack<Project> orderedDFS = findBuildOrderDFS(projects, dependencies);
		
		if (orderedDFS == null) {
			System.out.println("There is a loop");
		} else {
			System.out.println();
			while (!orderedDFS.isEmpty()) {
				System.out.print(orderedDFS.pop().getName() + " ,");
			}
		}

	}

	private static String[][] createRandomDependencyMatrix(char[] projectArr, int dependencyBound) {
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

		String[][] depMatrix = new String[depList.size()][2];
		for (int i = 0; i < depList.size(); i++) {
			HashMap<Character, Character> elem = depList.get(i);
			Iterator<Map.Entry<Character, Character>> it = elem.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Character, Character> entry = it.next();
				depMatrix[i][0] = entry.getKey().toString();
				depMatrix[i][1] = entry.getValue().toString();
			}
		}

		return depMatrix;
	}

	//O(P+D) time, where P is the number of projects and D is the number of dependency pairs.
	public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}

	//O(P+D) time, where P is the number of projects and D is the number of dependency pairs.
	public static Stack<Project> findBuildOrderDFS(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjectsDFS(graph.getNodes());
	}

	private static Stack<Project> orderProjectsDFS(ArrayList<Project> projects) {
		Stack<Project> stack = new Stack<Project>();

		for (Project project : projects) {
			if (project.getState() == State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}

		return stack;
	}

	private static boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == State.PARTIAL) {
			return false; //cycle
		}

		if (project.getState() == State.BLANK) {
			project.setState(State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}

			project.setState(State.COMPLETED);
			stack.push(project);
		}

		return true;
	}

	/*
	 * Build the graph, adding the edge (a, b) if b is dependent on a. Assumes a
	 * pair is listed in "build order". The pair (a, b) in dependencies indicates
	 * that b depends on a and a must be built before b.
	 */
	public static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();

		for (String project : projects) {
			graph.getOrCreateNode(project);
		}

		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}

		return graph;
	}

	/* Return a list of the projects a correct build order. */
	public static Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];

		/* Add "roots" to the build order first. */
		int endOfList = addNonDependent(order, projects, 0);

		int toBeProcessed = 0;
		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];

			/*
			 * We have a circular dependency since there are no remaining projects with zero
			 * dependencies.
			 */
			if (current == null) {
				return null;
			}

			/* Remove myself as a dependency. */
			ArrayList<Project> children = current.getChildren();
			for (Project child : children) {
				child.decrementDependencies();
			}

			endOfList = addNonDependent(order, children, endOfList);
			toBeProcessed++;
		}

		return order;
	}

	/*
	 * A helper function to insert projects with zero dependencies into the order
	 * array, starting at index offset.
	 */
	private static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getNumberDependencies() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		return offset;
	}
}
