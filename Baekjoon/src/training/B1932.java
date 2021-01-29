package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932 {

	static int[][] triangle;
	static Integer[][] dp;
	static int N;

	/**
	 *
	 * @param depth : 행
	 * @param idx : 열
	 */
	static int find(int depth, int idx) {
		// 마지막 행일 경우 현재 위치의 dp값 반환
		if (depth == N - 1)
			return dp[depth][idx];

		// 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
		if (dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + triangle[depth][idx];
		}

		return dp[depth][idx];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		triangle = new int[N][N];
		dp = new Integer[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i + 1; ++j) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = triangle[N - 1][i];
		}

		System.out.println(find(0, 0));
	}
}
