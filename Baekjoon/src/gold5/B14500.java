package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {
	static int N, M, answer;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	private static void dfs(int y, int x, int cnt, int sum, boolean[][] visit) {
		if (cnt >= 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < 4; ++i) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
				continue;
			}
			visit[ny][nx] = true;
			dfs(ny, nx, cnt + 1, sum + map[ny][nx], visit);
			visit[ny][nx] = false;
		}
	}

	private static void check(int y, int x) {
		if (y < N - 2 && x < M - 1) {
			answer = Math.max(answer, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1]);
		}
		if (y < N - 2 && x > 0) {
			answer = Math.max(answer, map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1]);
		}
		if (y < N - 1 && x < M - 2) {
			answer = Math.max(answer, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1]);
		}
		if (y > 0 && x < M - 2) {
			answer = Math.max(answer, map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, map[i][j], visit);
				visit[i][j] = false;
				check(i, j);
			}
		}
		System.out.println(answer);
	}
}