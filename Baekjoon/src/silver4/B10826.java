package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B10826 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		BigInteger[] dp = new BigInteger[n + 1];
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.ONE;

		for (int i = 3; i <= n; ++i) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}

		System.out.println(dp[n]);
	}
}
