package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11724 {

	public static boolean[] dfs(int[][] map, int i, boolean[] visited) {
		visited[i] = true;

		for (int j = 1; j < map.length; ++j) {
			if (i != j && map[i][j] == 1 && visited[j] == false) {
				visited = dfs(map, j, visited);
			}
		}

		return visited;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];
		int answer = 0;

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			map[p1][p2] = 1;
			map[p2][p1] = 1;
		}

		for (int i = 1; i < N + 1; ++i) {
			if (!visited[i]) {
				dfs(map, i, visited);
				answer++;
			}
		}

		System.out.println(answer);

	}
}
