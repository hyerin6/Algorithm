package programmers.practice;

public class DP_1로만들기 {
	private static void solution(int x) {
		int[] dp = new int[x + 1];
		for (int i = 2; i < x + 1; ++i) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
			if (i % 5 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 5] + 1);
			}
		}

		System.out.println(dp[x]);
	}

	public static void main(String[] args) {
		solution(26);
	}
}
