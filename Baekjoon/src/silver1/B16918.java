package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16918 {
	private static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, T;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; ++i) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; ++j) {
				if (input[j] == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		for (int t = 2; t <= T; ++t) {
			if (t % 2 == 0) {
				setBoom(t);
			} else {
				findBoom(t);
				boom();
			}
		}
		print();
	}

	private static void setBoom(int num) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
					map[i][j] = num;
				}
			}
		}
	}

	private static void findBoom(int num) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= num - 2) {
					q.add(new Node(i, j));
				}
			}
		}
	}

	private static void boom() {
		while (!q.isEmpty()) {
			Node temp = q.poll();
			map[temp.x][temp.y] = 0;

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					map[nx][ny] = 0;
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				System.out.format("%c", map[i][j] == 0 ? '.' : 'O');
			}
			System.out.println();
		}
	}

}