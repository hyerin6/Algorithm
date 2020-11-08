package woowacourse2021;

import java.util.HashMap;
import java.util.Map;

public class Main1 {

	static class Solution {
		final static Map<String, Integer> score = makeScore();

		public static int solution(String[] grades, int[] weights, int threshold) {
			int answer = -1234567890;

			int sum = 0;

			for(int i = 0 ; i < grades.length; ++i) {
				sum += score.get(grades[i]) * weights[i];
			}

			answer = sum-threshold;

			return answer;
		}

		private static Map<String, Integer> makeScore() {
			Map<String, Integer> score = new HashMap<>();
			score.put("A+", 10);
			score.put("A0", 9);
			score.put("B+", 8);
			score.put("B0", 7);
			score.put("C+", 6);
			score.put("C0", 5);
			score.put("D+", 4);
			score.put("D0", 3);
			score.put("F", 0);
			return score;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] grades = {"B+","A0","C+"};
		int[] weights = {6,7,8};
		int threshold = 200;
		int result = Solution.solution(grades, weights, threshold);
		System.out.println(result);

	}

}
