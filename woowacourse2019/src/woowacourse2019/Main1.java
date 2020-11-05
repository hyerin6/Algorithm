package woowacourse2019;

import java.util.Arrays;

public class Main1 {

	static class Solution {
		public static int[] solution(int money) {
			int[] answer = new int[9];
			int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};	

			answer[0] = money/moneyArr[0];

			for(int i = 1; i < moneyArr.length; ++i) {
				answer[i] = (money%moneyArr[i-1]) / moneyArr[i];
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(Solution.solution(50237)));
		System.out.println(Arrays.toString(Solution.solution(15000)));
	}

}
