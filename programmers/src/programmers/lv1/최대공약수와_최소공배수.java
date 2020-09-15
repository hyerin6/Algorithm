package programmers.lv1;

import java.util.Arrays;

public class 최대공약수와_최소공배수 {

	static class Solution {
		public int[] solution(int n, int m) {
			int[] answer = new int[2];
			int largeVal = 0;

			// 큰 수 찾기
			if(n < m) {
				largeVal = m;
			} else {
				largeVal = n;
			}

			// 최대공약수 구하기
			int i = largeVal;
			while(1 < largeVal) {
				if (n%i == 0 && m%i == 0) {
					// 유클리드 호제법 : 두 수를 곱한 뒤 최대공약수로 나누면 최소공배수
					answer[0] = i;
					answer[1] = n*m / i;
					break;
				}
				i = i - 1;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(new Solution().solution(3,  12)));
		System.out.println(Arrays.toString(new Solution().solution(2,  5)));

	}

}
