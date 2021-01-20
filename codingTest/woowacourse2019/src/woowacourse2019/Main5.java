package woowacourse2019;

public class Main5 {

	static class Solution {
		public static int solution(int number) {
			int answer = 0;

			for(int i = 1; i <= number; ++i) {
				String s = String.valueOf(i);

				for(int j = 0; j < s.length(); ++j) {
					char ch = s.charAt(j);

					if(ch == '3' || ch == '6' || ch == '9') {
						answer++;
					}
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Solution.solution(13));

	}

}
