package com.java.coding;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Robot {
		Point p1;
		Point p2;
		int time;
		int vertical;

		public Robot(Point p1, Point p2, int time, int vertical) {
			this.p1 = p1;
			this.p2 = p2;
			this.time = time;
			this.vertical = vertical;
		}

		public Robot(int x1, int y1, int x2, int y2, int time, int vertical) {
			this.p1 = new Point(x1, y1);
			this.p2 = new Point(x2, y2);
			this.time = time;
			this.vertical = vertical;
		}
	}

	static int[][] op = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	private static int solution(int[][] board) {
		int answer = 0;
		boolean[][][] visited = new boolean[board.length][board.length][2];
		Queue<Robot> q = new LinkedList<>();
		q.offer(new Robot(new Point(0, 0), new Point(0, 1), 0, 0));

		while (!q.isEmpty()) {
			Robot now = q.poll();

			// 방문해도 되는지 확인
			if (check(now, board) || visited[now.p1.x][now.p1.y][now.vertical] &&
				visited[now.p2.x][now.p2.y][now.vertical]) {
				continue;
			}
			// 도착했는지 확인
			if ((now.p1.x == board.length - 1 && now.p1.y == board.length - 1) ||
				(now.p2.x == board.length - 1 && now.p2.y == board.length - 1)) {
				answer = now.time;
				break;
			}

			visited[now.p1.x][now.p1.y][now.vertical] = true;
			visited[now.p2.x][now.p2.y][now.vertical] = true;

			for (int i = 0; i < op.length; i++) {
				int nx1 = now.p1.x + op[i][0];
				int ny1 = now.p1.y + op[i][1];
				int nx2 = now.p2.x + op[i][0];
				int ny2 = now.p2.y + op[i][1];
				q.offer(new Robot(nx1, ny1, nx2, ny2, now.time + 1, now.vertical));
			}

			if (now.vertical == 1) {
				if (now.p1.y - 1 >= 0 && board[now.p1.x][now.p1.y - 1] == 0 &&
					board[now.p2.x][now.p2.y - 1] == 0) {
					q.offer(new Robot(now.p1.x, now.p1.y, now.p1.x, now.p1.y - 1, now.time + 1, 0));
					q.offer(new Robot(now.p2.x, now.p2.y, now.p2.x, now.p2.y - 1, now.time + 1, 0));
				}
				if (now.p1.y + 1 <= (board.length - 1) &&
					board[now.p1.x][now.p1.y + 1] == 0 && board[now.p2.x][now.p2.y + 1] == 0) {
					q.offer(new Robot(now.p1.x, now.p1.y, now.p1.x, now.p1.y + 1, now.time + 1, 0));
					q.offer(new Robot(now.p2.x, now.p2.y, now.p2.x, now.p2.y + 1, now.time + 1, 0));
				}
			} else {
				if (now.p1.x - 1 >= 0 && board[now.p1.x - 1][now.p1.y] == 0 &&
					board[now.p2.x - 1][now.p2.y] == 0) {
					q.offer(new Robot(now.p1.x, now.p1.y, now.p1.x - 1, now.p1.y, now.time + 1, 1));
					q.offer(new Robot(now.p2.x, now.p2.y, now.p2.x - 1, now.p2.y, now.time + 1, 1));
				}
				if (now.p1.x + 1 <= (board.length - 1) && board[now.p1.x + 1][now.p1.y] == 0 &&
					board[now.p2.x + 1][now.p2.y] == 0) {
					q.offer(new Robot(now.p1.x, now.p1.y, now.p1.x + 1, now.p1.y, now.time + 1, 1));
					q.offer(new Robot(now.p2.x, now.p2.y, now.p2.x + 1, now.p2.y, now.time + 1, 1));
				}
			}
		}
		return answer;
	}

	// 이동할 수 있으면 true 리턴
	private static boolean check(Robot robot, int[][] board) {
		return robot.p1.x < 0 || robot.p1.x >= board.length || robot.p1.y < 0 || robot.p1.y >= board.length ||
			robot.p2.x < 0 || robot.p2.x >= board.length || robot.p2.y < 0 || robot.p2.y >= board.length ||
			board[robot.p1.x][robot.p1.y] == 1 || board[robot.p2.x][robot.p2.y] == 1;
	}

	public static void main(String[] args) throws Exception {
		int result = solution(new int[][] {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}
			, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
		System.out.println(result);
	}
}
