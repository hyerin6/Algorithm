package com.java.coding;

import java.util.Arrays;

public class DP_효율적인화폐구성 {

	private static void solution(int n, int m, int[] coin) {
		int[] dp = new int[m + 1];
		Arrays.fill(dp, 10001);

		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= m; j++) {
				// (i - k)원을 만드는 방법이 존재하는 경우
				if (dp[j - coin[i]] != 10001) {
					dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
				}
			}
		}

		if (dp[m] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[m]);
		}
	}

	public static void main(String[] args) {
		solution(2, 15, new int[] {2, 3});
		solution(3, 4, new int[] {3, 5, 7});
	}
}
