package programmers.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래도시 {
	private static final int INF = (int)1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(graph[i], INF);
		}

		for (int a = 1; a <= N; a++) {
			for (int b = 1; b <= N; b++) {
				if (a == b)
					graph[a][b] = 0;
			}
		}

		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = 1;
			graph[end][start] = 1;
		}

		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				for (int l = 1; l <= N; ++l) {
					graph[j][l] = Math.min(graph[j][l], graph[j][i] + graph[i][l]);
				}
			}
		}

		int result = graph[1][K] + graph[K][X];

		if (result >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}
