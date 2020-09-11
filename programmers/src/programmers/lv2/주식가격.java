package programmers.lv2;

import java.util.Arrays;

public class 주식가격 {

	// 가격이 떨어지지 않은 기간은 몇 초인지 answer에 담아서 리턴 
	static class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];
			int cnt = 0;
			for(int i = 0; i < prices.length; ++i) {
				for(int j = i+1; j < prices.length; ++j) {
					cnt++;
					// 가격이 떨어지면 카운팅을 멈춥니다. 
					if(prices[i] > prices[j]) break;
				}
				answer[i] = cnt;
				cnt = 0;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(s.solution(prices)));
	}

}
