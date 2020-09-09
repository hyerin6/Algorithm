package programmers.lv1;

public class 자릿수_더하기 {

	static class Solution {
		public int solution(int n) {
			int answer = 0;

			while(true) {
				answer += n%10;
				if(n < 10) break;
				n = n/10;
			}
			
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.solution(123));

	}

}
