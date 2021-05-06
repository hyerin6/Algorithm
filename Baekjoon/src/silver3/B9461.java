package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21, ...
public class B9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < input.length; ++i) {
			input[i] = Integer.parseInt(br.readLine());
		}

		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;

		for (int p = 0; p < N; ++p) {
			for (int i = 5; i <= input[p]; ++i) {
				dp[i] = dp[i - 2] + dp[i - 3];
			}
			System.out.println(dp[input[p]]);
		}

	}
}
