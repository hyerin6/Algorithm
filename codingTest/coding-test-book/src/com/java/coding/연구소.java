package com.java.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
	static int N, M;
	static int[][] map;
	static int result = Integer.MIN_VALUE;

	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	private static void dfs(int depth) {
		if (depth == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		int[][] virus = new int[N][M];
		Queue<Virus> q = new LinkedList<>();

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				virus[i][j] = map[i][j];
				if (virus[i][j] == 2) {
					q.add(new Virus(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Virus v = q.poll();
			for (int i = 0; i < 4; ++i) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (virus[nx][ny] == 0) {
						virus[nx][ny] = 2;
						q.add(new Virus(nx, ny));
					}
				}
			}
		}
		safeCnt(virus);
	}

	private static void safeCnt(int[][] virus) {
		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (virus[i][j] == 0) {
					cnt++;
				}
			}
		}
		result = Math.max(result, cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		dfs(0);
		System.out.println(result);
	}

	private static class Virus {
		int x;
		int y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
