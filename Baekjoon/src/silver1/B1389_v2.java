package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1389_v2 {

	private static int N;
	private static int M;
	private static int[][] distance;
	static boolean visit[];
	static int count[][];

	public static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		visit[num] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; ++i) {
				// 방문하지 않은 노드 && 인접한 노드
				if (!visit[i] && distance[cur][i] == 1) {
					q.offer(i);
					visit[i] = true;
					count[num][i] = count[num][cur] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		distance = new int[N + 1][N + 1];
		count = new int[N + 1][N + 1];
		int sum[] = new int[N + 1];
		int min = Integer.MAX_VALUE;
		int index = 0;

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			distance[start][end] = 1;
			distance[end][start] = 1;
		}

		for (int i = 1; i <= N; ++i) {
			visit = new boolean[N + 1];
			bfs(i);
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				sum[i] += count[i][j];
			}
		}

		for (int i = 1; i <= N; ++i) {
			if (sum[i] < min) {
				min = sum[i];
				index = i;
			}
		}

		System.out.println(index);
	}
}
