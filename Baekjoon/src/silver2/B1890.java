package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로의 개수는 263-1보다 작거나 같다. = Long Integer로 구현하라.
public class B1890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		long[][] dp = new long[N + 1][N + 1];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp [i][j] = 이 칸 까지 올 수 있는 경우의 수
		dp[0][0] = 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i == N - 1 && j == N - 1) { // 종착점
					break;
				}
				int next = map[i][j];
				if (i + next < N) {
					dp[i + next][j] += dp[i][j];
				}
				if (j + next < N) {
					dp[i][j + next] += dp[i][j];
				}
			}
		}

		System.out.println(dp[N - 1][N - 1]);
	}

}
