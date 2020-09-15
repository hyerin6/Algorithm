package programmers.lv1;

public class 시저암호 {

	static class Solution {
		public String solution(String s, int n) {
			String answer = "";

			for(int i = 0; i < s.length(); ++i) {
				char ch = s.charAt(i);
				if(Character.isLowerCase(ch)) ch = (char)((ch + n % 26 - 'a') % 26 + 'a');
				else if (Character.isUpperCase(ch)) ch = (char)((ch + n % 26 - 'A') % 26 + 'A');
				answer += ch;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution().solution("AB", 1));
		System.out.println(new Solution().solution("z", 1));
		System.out.println(new Solution().solution("a B z", 4));
	}

}
