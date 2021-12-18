package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] numbers = new int[T];
		int[][] dp = new int[100001][4];
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[1][3] = 0;

		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[2][3] = 0;

		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 0; i < T; ++i) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 4; i < 10001; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}

		for (int i = 0; i < T; ++i) {
			int num = numbers[i];
			System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
		}

	}
}