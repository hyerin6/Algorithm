package programmers.lv2;

public class 나라의숫자 {

	static class Solution {
		String[] numbers = {"4", "1", "2"};

		public String solution(int n) {
			String answer = "";

			int num = n;
			while(num > 0) {
				int remainder = num % 3;
				num /= 3;

				if(remainder == 0) --num;

				answer = numbers[remainder] + answer;
			}

			return answer;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(10));
	}

}
