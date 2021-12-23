package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B11057 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < 10; j++) {
				if (i == 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += dp[N][i];
		}

		bw.write(answer % 10007 + "\n");
		bw.close();
		br.close();
	}
}
