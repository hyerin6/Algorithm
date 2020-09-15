package programmers.lv1;

public class 수박수박수박수박수박수 {

	static class Solution {
		public String solution(int n) {
			String answer = "";

			for(int i = 0; i < (n/2); ++i) {
				answer += "수박";
			}

			if(n%2 != 0) answer += "수"; 
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(1));
		System.out.println(new Solution().solution(3));
		System.out.println(new Solution().solution(4));
	}

}
