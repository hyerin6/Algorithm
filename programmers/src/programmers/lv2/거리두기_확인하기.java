package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int i = 0; i < places.length; ++i) {
			String tmp[] = places[i];
			boolean isCheck = true;
			for (int r = 0; r < 5 && isCheck; ++r) {
				for (int c = 0; c < 5 && isCheck; ++c) {
					if (tmp[r].charAt(c) == 'P') {
						if (!bfs(tmp, r, c))
							isCheck = false;
					}
				}
			}
			answer[i] = isCheck ? 1 : 0;
		}

		return answer;
	}

	public static boolean bfs(String[] board, int x, int y) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[board.length][board.length];
		q.offer(new Node(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

				if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length)
					continue;
				if (visited[nx][ny] || manhattan > 2)
					continue;

				visited[nx][ny] = true;
				if (board[nx].charAt(ny) == 'X') { // 상하좌우에 X가 있으면 파티션이므로 더이상 탐색할 필요가 없다.
					continue;
				} else if (board[nx].charAt(ny) == 'P') { // 바로 인접한 상하좌우에 P가 있으면 거리두기 실패
					return false;
				} else {
					q.offer(new Node(nx, ny)); // 빈자리인 경우 탐색이 필요함
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] places = {
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};

		int[] result = solution(places);
		System.out.println(Arrays.toString(result));
	}

}
