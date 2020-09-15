package programmers.lv1;

public class 짝수와홀수 {

	static class Solution {
		public String solution(int num) {
			return num%2==0 ? "Even" : "Odd";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution().solution(3));
		System.out.println(new Solution().solution(4));
	}

}
