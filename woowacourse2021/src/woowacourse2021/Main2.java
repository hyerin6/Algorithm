package woowacourse2021;

import java.util.Arrays;

public class Main2 {

	static class Solution {
		public static long[] solution(String s, String op) {
			long[] answer = new long[s.length()-1];

			for(int i = 0; i < s.length()-1; ++i) {
				int preNum = Integer.valueOf(s.substring(0, i+1));
				int curNum = Integer.valueOf(s.substring(i+1, s.length())); 

				switch (op) {
				case "+":  
					answer[i] = preNum+curNum; 
					break;
				case "-":  
					answer[i] = preNum-curNum; 
					break;
				case "*":  
					answer[i] = preNum*curNum; 
					break;
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] result = Solution.solution("1234", "+");
		System.out.println(Arrays.toString(result));		
	}

}
