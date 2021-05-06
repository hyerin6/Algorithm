package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11727 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; ++i) {
			// dp[i - 2]를 추가로 더해주는 이유는
			// 2*2 블럭이 추가되어 왼쪽에 남는 여백의 가로길이가 n-2이기 때문이다.
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[n]);
	}
}
