package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; ++i) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; ++i) {
			for (int j = 1; j <= i; ++j) {
				dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
			}
		}

		bw.write(dp[N] + "\n");
		bw.close();
		br.close();
	}
}
