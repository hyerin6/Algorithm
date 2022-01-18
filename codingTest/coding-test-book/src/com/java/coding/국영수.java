package com.java.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수 {
	static class Score implements Comparable {
		String name;
		int korean;
		int english;
		int math;

		public Score(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Object o) {
			Score score = (Score)o;
			if (this.korean == score.korean) {
				if (this.english == score.english) {
					if (this.math == score.math) {
						return this.name.compareTo(score.name);
					}
					return score.math - this.math;
				}
				return this.english - score.english;
			}
			return score.korean - this.korean;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Score> scores = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			scores.add(new Score(st.nextToken(),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}
		Collections.sort(scores);
		for (Score s : scores) {
			System.out.println(s.name);
		}
	}
}
