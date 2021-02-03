package silver1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class B2178_v2 {

	static class Node {
		int r, c, distance;

		public Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}

	static int search(char[][] map) {
		final int R = map.length, C = map[0].length;
		boolean[][] visited = new boolean[R][C];
		Queue<Node> queue = new ArrayDeque<>(); // 방문할 칸 목록
		queue.add(new Node(0, 0, 1));           // 시작 위치

		while (queue.size() > 0) {
			Node current = queue.remove(); // 현재 위치
			int r = current.r, c = current.c, distance = current.distance;
			if (r < 0 || r >= R)
				continue;
			if (c < 0 || c >= C)
				continue;
			if (r == R - 1 && c == C - 1)
				return current.distance; // 목적지 도착
			if (map[r][c] == '0')
				continue; // 벽
			if (visited[r][c])
				continue;    // 이미 방문한 칸인가?

			visited[r][c] = true;
			queue.add(new Node(r - 1, c, distance + 1)); // 위로
			queue.add(new Node(r + 1, c, distance + 1)); // 아래쪽으로
			queue.add(new Node(r, c - 1, distance + 1)); // 왼쪽으로
			queue.add(new Node(r, c + 1, distance + 1)); // 오른쪽으로
		}

		return -1; // 탐색 실패
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in)) {
			int R = scanner.nextInt();
			int C = scanner.nextInt();
			char[][] map = new char[R][];
			for (int r = 0; r < R; ++r)
				map[r] = scanner.next().toCharArray();
			System.out.println(search(map));
		}
	}
}
