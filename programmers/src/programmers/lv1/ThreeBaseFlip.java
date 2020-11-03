package programmers.lv1;

public class ThreeBaseFlip {



	static class Solution {
		public static int solution(int n) {
			int answer = 0;

			StringBuilder threeBase = new StringBuilder();

			while (n != 0) {
				threeBase.append(n % 3);
				n = n / 3;
			}

			String[] splitThreeBase = threeBase.reverse()
					.toString()
					.split("");

			for (int i = 0; i < splitThreeBase.length; i++) {
				answer += Integer.parseInt(splitThreeBase[i]) * Math.pow(3, i);
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Solution.solution(45));
		System.out.println(Solution.solution(125));

		// Integer.toString 을 사용하면 10진수를 n진법으로 변환이 가능하다. 
		String third = Integer.toString(125, 3);
		System.out.println(third);
	}

}
