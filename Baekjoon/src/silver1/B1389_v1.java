package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드 와샬(Floyd-Warshall) 알고리즘
public class B1389_v1 {

	private static int N;
	private static int M;
	private static int min = Integer.MAX_VALUE;
	private static int index = 0;
	private static int[][] distance;
	private static int INF = 5001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		distance = new int[N + 1][N + 1];

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (i == j) {
					distance[i][j] = 0;
				} else {
					distance[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			distance[start][end] = 1;
			distance[end][start] = 1;
		}

		for (int k = 1; k <= N; ++k) {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}

		for (int i = 1; i <= N; ++i) {
			int sum = 0;
			for (int j = 1; j <= N; ++j) {
				sum += distance[i][j];
			}
			if (sum < min) {
				min = sum;
				index = i;
			}
		}

		System.out.print(index);

	}
}
