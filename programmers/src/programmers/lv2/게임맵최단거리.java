package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	static class Solution {

		class Node {
			int x;
			int y;
			int cost;

			public Node(int x, int y, int cost) {
				this.x = x;
				this.y = y;
				this.cost = cost;
			}
		}

		static int[] dx = {-1, 0, 1, 0};
		static int[] dy = {0, 1, 0, -1};
		static int m, n;

		public int solution(int[][] maps) {
			m = maps.length;
			n = maps[0].length;
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(0, 0, 1));
			int[][] visit = new int[m][n];
			visit[0][0] = 1;

			while (!q.isEmpty()) {
				Node node = q.poll();
				if (node.x == m - 1 && node.y == n - 1) {
					return node.cost;
				}
				for (int i = 0; i < 4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
						if (maps[nx][ny] == 1 && visit[nx][ny] == 0) {
							visit[nx][ny] = 1;
							q.offer(new Node(nx, ny, node.cost + 1));
						}
					}
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] maps = {
			{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1},
			{0, 0, 0, 0, 1}};
		int answer = s.solution(maps);
		System.out.println(answer);
	}
}
