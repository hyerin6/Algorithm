package woowacourse2021;

public class Main3 {

	static class Solution {
		public static int solution(int money, String[] expected, String[] actual) {
			int betting = 100;

			for(int i = 0; i < expected.length; ++i) {
				if(betting >= money) betting = money;

				if(expected[i].equals(actual[i])) {
					money += betting;
					betting = 100;
				} else {
					money -= betting;
					betting = betting*2;
				}

				if(money <= 0) break;
			}

			return money;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money1 = 1000;
		String[] expected1 = {"H", "T", "H", "T", "H", "T", "H"};
		String[] actual1 = {"T", "T", "H", "H", "T", "T", "H"};
		int result1 = Solution.solution(money1, expected1, actual1);
		System.out.println(result1);

		int money2 = 1200;
		String[] expected2 = {"T", "T", "H", "H", "H"};
		String[] actual2 = {"H", "H", "T", "H", "T"};
		int result2 = Solution.solution(money2, expected2, actual2);
		System.out.println(result2);
	}

}
