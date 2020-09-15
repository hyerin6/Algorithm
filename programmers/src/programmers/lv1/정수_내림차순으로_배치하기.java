package programmers.lv1;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {

	static class Solution {
		public long solution(long n) {
			long answer = 0;
			String[] strArr = String.valueOf(n).split("");
			Arrays.sort(strArr);
			StringBuilder sb = new StringBuilder();
			Arrays.stream(strArr).forEach(x -> sb.append(x));
			answer = Long.parseLong(sb.reverse().toString());
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(118372));

	}

}
