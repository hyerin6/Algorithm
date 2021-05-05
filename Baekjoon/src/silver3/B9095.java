package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] inputs = new int[N];

		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 10; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		for (int i = 0; i < N; ++i) {
			inputs[i] = Integer.parseInt(br.readLine());
		}

		for (int i : inputs) {
			System.out.println(dp[i]);
		}

	}
}
