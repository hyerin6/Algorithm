package programmers.lv1;

import java.util.Arrays;

public class 평균구하기 {

	static class Solution {
		public double solution(int[] arr) {
			return Arrays.stream(arr).average().getAsDouble();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(new int[] {1, 2, 3, 4}));
		System.out.println(new Solution().solution(new int[] {5, 5}));

	}

}
