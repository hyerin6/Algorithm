package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579_v1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] stairs = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		// idx = 0 은 시작점이다.
		dp[1] = stairs[1];

		// N = 1, 예외처리
		if (N >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}

		for (int i = 3; i <= N; i++) {
			// dp[i - 2] : 이전에 연속으로 계단을 오르지 않음
			// dp[i - 3] + stairs[i - 1] : 이전 계단을 밟음, 즉 연속으로 계단을 오름
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
		}

		System.out.println(dp[N]);
	}
}