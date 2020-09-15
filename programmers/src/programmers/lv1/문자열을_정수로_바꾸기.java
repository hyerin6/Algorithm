package programmers.lv1;

public class 문자열을_정수로_바꾸기 {

	static class Solution {
		public int solution(String s) {
			return Integer.parseInt(s);
		}

		public int getStrToInt(String str) {
			boolean Sign = true;
			int result = 0;

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '-')
					Sign = false;
				else if(ch !='+')
					result = result * 10 + (ch - '0');
			}
			return Sign ? result : -1*result;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution("1234"));
		System.out.println(new Solution().solution("+1234"));
		System.out.println(new Solution().solution("-1234"));

		System.out.println("\n" + new Solution().getStrToInt("1234"));
		System.out.println(new Solution().getStrToInt("+1234"));
		System.out.println(new Solution().getStrToInt("-1234"));
	}

}
