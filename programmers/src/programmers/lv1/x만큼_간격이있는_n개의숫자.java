package programmers.lv1;

import java.util.Arrays;

public class x만큼_간격이있는_n개의숫자 {

	static class Solution {
		public static long[] solution(int x, int n) {
			long[] answer = new long[n];
			answer[0] = x;

			for(int i = 1; i < n; ++i) {
				answer[i] = answer[i-1] + x;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] answer = Solution.solution(-4, 3);
		System.out.println(Arrays.toString(answer));
	}

}
