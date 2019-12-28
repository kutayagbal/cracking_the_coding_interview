package ch10_sorting_and_searching.q10_rank_from_stream;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class RankFromStream {
	private static SortedMap<Integer, Integer> syncMap = null;

	public static void main(String[] args) {
		syncMap = Collections.synchronizedSortedMap(new TreeMap<>());

		int[] arr = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };

		for (int i : arr) {
			track(i);
		}

		System.out.println(getRankOfNumber(1));
		System.out.println(getRankOfNumber(3));
		System.out.println(getRankOfNumber(4));
	}

	public static void track(int x) {
		Integer count = syncMap.get(x);
		if (count != null) {
			syncMap.put(x, count + 1);
		} else {
			syncMap.put(x, 1);
		}
	}

	public static int getRankOfNumber(int x) {
		synchronized (syncMap) {
			Iterator<Integer> it = syncMap.keySet().iterator();
			int total = 0;

			while (it.hasNext()) {
				Integer key = it.next();

				if (key > x)
					return total - 1;

				total += syncMap.get(key);
			}
		}

		return 0;
	}
}
