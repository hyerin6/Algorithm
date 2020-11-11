package programmers.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {

	static class Node {
		int r, c; // 행, 열

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] D = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		final int R = picture.length, C = picture[0].length;
		boolean[][] visited = new boolean[R][C];
		Queue<Node> q = new ArrayDeque<>(); 

		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[i].length; j++) {
				int size = 0;

				if (picture[i][j] != 0 && !visited[i][j]) {
					q.add(new Node(i, j));
					visited[i][j] = true;
					size++;

					while (!q.isEmpty()) {
						Node current = q.poll();

						for (int[] d : D) {
							int r = current.r + d[0];
							int c = current.c + d[1];

							if (r < 0 || c < 0 || r >= R || c >= C) continue; 
							if(picture[current.r][current.c] != picture[r][c] || visited[r][c]) continue;

							visited[r][c] = true;
							q.add(new Node(r, c));
							size++;
						}
					} 

					numberOfArea++;
					maxSizeOfOneArea = maxSizeOfOneArea < size ? size : maxSizeOfOneArea;
				}

			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m1 = 6;
		int n1 = 4;
		int[][] picture1 = {{1, 1, 1, 0}, {1, 2, 2, 0}, 
				{1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] result1 = solution(m1, n1, picture1);
		System.out.println(Arrays.toString(result1));

		int m2 = 6;
		int n2 = 4;
		int[][] picture2 = {{1, 1, 1, 0}, {1, 1, 1, 0}, 
				{0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
		int[] result2 = solution(m2, n2, picture2);
		System.out.println(Arrays.toString(result2));
	}

}
