package com.java.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실패율 {
	static class Score implements Comparable {
		int id;
		double fail;

		public Score(int id, double fail) {
			this.id = id;
			this.fail = fail;
		}

		@Override
		public int compareTo(Object o) {
			Score s = (Score)o;
			if (s.fail == this.fail) {
				return this.id - s.id;
			}
			return Double.compare(s.fail, this.fail);
		}
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] cnt = new int[N + 1]; // 각 stage에 머물러있는 user 수
		List<Score> scores = new ArrayList<>();

		for (int i = 0; i < stages.length; ++i) {
			if (stages[i] > N) {
				continue;
			}
			cnt[stages[i]]++;
		}

		int total = stages.length;
		for (int i = 1; i < cnt.length; ++i) {
			if (cnt[i] == 0) { // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
				scores.add(new Score(i, 0d));
				continue;
			}
			double failureRate = (double)cnt[i] / (double)total;
			scores.add(new Score(i, failureRate));
			total -= cnt[i];
		}

		Collections.sort(scores);
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = scores.get(i).id;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		int[] answer = solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
		System.out.println(Arrays.toString(answer));
		int[] answer2 = solution(5, new int[] {2, 2, 2, 2, 2});
		System.out.println(Arrays.toString(answer2));
	}
}
