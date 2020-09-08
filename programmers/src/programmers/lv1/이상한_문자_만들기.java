package programmers.lv1;

public class 이상한_문자_만들기 {

	static class Solution {
		public String solution(String s) {
			String answer = "";
			int cnt = 0;
			String[] array = s.split("");

			for(String a : array) {
				cnt = a.contains(" ") ? 0 : cnt+1;
				answer += cnt%2 == 0 ? a.toLowerCase() : a.toUpperCase(); 
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.solution("  hello  hello he llo   "));
	}

}
