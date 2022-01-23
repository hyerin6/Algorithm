package com.java.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][m];
			int[][] dp = new int[n][m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = arr[i][j]; // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
				}
			}

			for (int j = 1; j < m; ++j) {
				for (int i = 0; i < n; ++i) {
					int leftUp, leftDown, left;
					// 왼쪽 위에서 오는 경우
					if (i == 0) {
						leftUp = 0;
					} else {
						leftUp = dp[i - 1][j - 1];
					}
					// 왼쪽 아래에서 오는 경우
					if (i == n - 1) {
						leftDown = 0;
					} else {
						leftDown = dp[i + 1][j - 1];
					}
					// 왼쪽에서 오는 경우
					left = dp[i][j - 1];
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
				}
			}

			int result = 0;
			for (int i = 0; i < n; ++i) {
				result = Math.max(result, dp[i][m - 1]);
			}
			System.out.println(result);
		}
	}
}