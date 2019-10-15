package ch09_system_design_and_scalability.q5_cache;

import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		Cache cache = new Cache(3);

		String[] queries = { "a", "b", "a", "p", "q", "c", "d", "b", "z", "z", "d", "a", "b", "m", "a", "a", "c", "t",
				"k", "l", "k", "e", "a", "a", "b" };

		Stream.of(queries).forEach(q -> System.out.println(q + ": " + cache.search(q).length + " results\n"));
	}

}
