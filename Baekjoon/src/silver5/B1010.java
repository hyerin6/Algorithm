package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1010 {

	static int[][] dp = new int[30][30];

	// M개중 N개를 뽑는 경우이므로 nCr 에서 n = M, r = N
	private static int combi(int n, int r) {
		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		if (n == r || r == 0) {
			return dp[n][r] = 1;
		}

		// dp[N][M] = dp[N][M-1] + dp[N-1][M-1]
		return combi(n - 1, r - 1) + combi(n - 1, r);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[][] site = new int[30][30];

		// 2번 성질 (n == r, r == 0)
		for (int i = 0; i < 30; i++) {
			site[i][i] = 1;
			site[i][0] = 1;
		}

		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				// 1번 성질
				site[i][j] = site[i - 1][j - 1] + site[i - 1][j];
			}
		}

		for (int i = 0; i < T; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			bw.write(site[M][N] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
