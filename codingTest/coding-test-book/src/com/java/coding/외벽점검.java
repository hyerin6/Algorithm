package com.java.coding;

import java.util.ArrayList;
import java.util.List;

public class 외벽점검 {

	static boolean[] visit = new boolean[201];
	static List<Integer> list = new ArrayList<>();
	static List<Integer> w = new ArrayList<>();
	static int answer = 987654321, N = 0;
	static int[] d;

	public static int solution(int n, int[] weak, int[] dist) {
		init(weak, dist, n);
		recur(0);
		if (answer == 987654321) {
			answer = -1;
		}
		return answer;
	}

	private static void init(int[] weak, int[] dist, int n) {
		d = dist;
		N = n;
		for (int i = 0; i < weak.length; ++i) {
			w.add(weak[i]);
		}
	}

	private static void recur(int cnt) {
		if (cnt > d.length) {
			return;
		}
		if (cnt > 0) {
			check();
		}

		for (int i = 0; i < d.length; i++) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			list.add(d[i]);
			recur(cnt + 1);
			list.remove(list.size() - 1);
			visit[i] = false;
		}
	}

	private static void caseCheck(List<Integer> copyWeak) {
		int loc = copyWeak.get(0);
		int idx = 1;
		for (int i = 0; i < list.size(); ++i) {
			loc += list.get(i);
			if (i < list.size() - 1) {
				while (loc >= copyWeak.get(idx)) {
					idx++;
					if (idx > copyWeak.size() - 1) {
						idx--;
						break;
					}
				}
				loc = copyWeak.get(idx);
			}
		}
		if (loc >= copyWeak.get(copyWeak.size() - 1)) {
			answer = Math.min(answer, list.size());
		}
	}

	private static void check() {
		List<Integer> copyWeak = new ArrayList<>();
		copyWeak.addAll(w);
		for (int i = 0; i < w.size(); i++) {
			caseCheck(copyWeak);
			copyWeak.add(copyWeak.get(0) + N);
			copyWeak.remove(0);
		}
	}

	public static void main(String[] args) throws Exception {
		int answer = solution(12, new int[] {1, 5, 6, 10}, new int[] {1, 2, 3, 4});
		System.out.println(answer);
	}
}
