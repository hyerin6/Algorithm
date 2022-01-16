package com.java.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시피하기 {
	static int N;
	static char[][] map;
	static List<Position> teacher = new ArrayList<>();
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {-1, 0, 1, 0};
	private static boolean result = false;

	private static void dfs(int depth) {
		if (depth == 3) {
			if (watch()) {
				result = true;
			}
			return;
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(depth + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	private static boolean watch() {
		for (Position p : teacher) {
			int x = p.getX();
			int y = p.getY();
			for (int j = 0; j < 4; ++j) {
				if (!watch(x, y, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean watch(int x, int y, int dir) {
		int nx = x;
		int ny = y;
		while (true) {
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				break;
			}
			if (map[nx][ny] == 'O') {
				return true;
			} else if (map[nx][ny] == 'S') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T') {
					teacher.add(new Position(i, j));
				}
			}
		}

		dfs(0);
		System.out.println(result ? "YES" : "NO");
	}

	private static class Position {
		private int x;
		private int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}

}
