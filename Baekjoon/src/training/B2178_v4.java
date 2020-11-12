package training;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

// 최장거리 구현 
public class B2178_v4 {

	static class Node {
		int r, c, distance;

		public Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}

	static int[][] D = {{-1,0}, {+1,0}, {0,-1}, {0,+1}};

	static int 탐색(char[][] map) {
		final int R = map.length, C = map[0].length;
		boolean[][] visited = new boolean[R][C];
		Queue<Node> queue = new ArrayDeque<>(); // 방문할 칸 목록
		queue.add(new Node(0, 0, 1));           // 시작 위치
		int max = -1;
		while (queue.size() > 0) {
			Node current = queue.remove();      // 현재 위치
			int r = current.r, c = current.c, distance = current.distance;
			if (r == R-1 && c == C-1) max = distance;  // 목적지 도착
			if (map[r][c] == '0') continue;   // 벽
			if (visited[r][c]) continue;      // 이미 방문한 칸인가?
			visited[r][c] = true;
			for (int[] d : D) {
				int r1 = r + d[0], c1 = c + d[1];
				if (r1 < 0 || r1 >= R) continue;
				if (c1 < 0 || c1 >= C) continue;
				queue.add(new Node(r1, c1, distance + 1));
			}
		}

		return max; // 탐색 실패
	}

	@SuppressWarnings("unused") 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in)) {
			int 행 = scanner.nextInt();
			int 열 = scanner.nextInt();
			char[][] map = new char[행][];
			for (int i = 0; i < 행; ++i)
				map[i] = scanner.next().toCharArray();
			System.out.println(탐색(map));
		}
	}
}
