package programmers.lv1;

import java.util.Arrays;

public class 예산 {

	static class Solution {
		public static int solution(int[] d, int budget) {
			int answer = 0;

			Arrays.sort(d);

			for(int i : d) {
				budget -= i;
				if(budget < 0) {
					break;
				}
				answer++;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] d = {1, 3, 2, 5, 4};
		int budget = 9;

		System.out.println(Solution.solution(d, budget));
	}

}
