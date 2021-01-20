package sep11;

public class Main1 {

	static class Solution {
		public String solution(String new_id) {
			String answer = new_id.toLowerCase();

			answer = answer.replaceAll("[^a-zA-Z0-9._-]", "");
			answer = answer.replaceAll("[\\.]+", ".");
			answer = answer.startsWith(".") ? answer.substring(1) : answer;
			answer = answer.endsWith(".") ? answer.substring(0, answer.length()-1) : answer;
			answer = answer.length() == 0 ? "a" : answer;
			answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
			answer = answer.endsWith(".") ? answer.substring(0, answer.length()-1) : answer;

			if(answer.length() <= 2) {
				for(int i = answer.length(); i < 3; ++i) {
					answer += answer.charAt(answer.length()-1);
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution().solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(new Solution().solution("z-+.^."));

		System.out.println(new Solution().solution("=.="));

		System.out.println(new Solution().solution("123_.def"));

		System.out.println(new Solution().solution("abcdefghijklmn.p"));

	}

}
