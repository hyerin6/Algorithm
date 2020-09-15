package programmers.lv1;

import java.util.Arrays;

public class 제일작은수_제거하기 {

	static class Solution {
		public int[] solution(int[] arr) {
			if(arr.length <= 1) return new int[]{-1};			
			int min = Arrays.stream(arr).min().getAsInt();
			return Arrays.stream(arr).filter(i -> i != min).toArray();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(new Solution().solution(new int[]{4,3,2,1})));
		System.out.println(Arrays.toString(new Solution().solution(new int[]{10})));
	}

}
