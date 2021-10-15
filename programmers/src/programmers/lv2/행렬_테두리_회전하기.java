package programmers.lv2;

import java.util.Arrays;

public class 행렬_테두리_회전하기 {

	private static int[][] createQueries(int r, int c) {
		int[][] queries = new int[r][c];
		int value = 1;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				queries[i][j] = value++;
			}
		}
		return queries;
	}

	public static int rotate(int[] query, int[][] map) {
		int r1 = query[0] - 1;
		int c1 = query[1] - 1;
		int r2 = query[2] - 1;
		int c2 = query[3] - 1;

		int temp = map[r1][c1]; // 시작 값
		int min = temp;
		for (int i = r1; i < r2; i++) { // 오른쪽으로 회전
			map[i][c1] = map[i + 1][c1];
			if (min > map[i][c1])
				min = map[i][c1];
		}
		for (int i = c1; i < c2; i++) { // 아래로 회전
			map[r2][i] = map[r2][i + 1];
			if (min > map[r2][i])
				min = map[r2][i];
		}
		for (int i = r2; i > r1; i--) { // 왼쪽으로 회전
			map[i][c2] = map[i - 1][c2];
			if (min > map[i][c2])
				min = map[i][c2];
		}
		for (int i = c2; i > c1; i--) { // 위로 회전
			map[r1][i] = map[r1][i - 1];
			if (min > map[r1][i])
				min = map[r1][i];
		}
		map[r1][c1 + 1] = temp; // 첫번째 값 대입
		return min;
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[][] map = createQueries(rows, columns);
		int[] answer = new int[queries.length];
		int index = 0;

		for (int i = 0; i < queries.length; ++i) {
			answer[index++] = rotate(queries[i], map);
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] result = solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
		System.out.println(Arrays.toString(result));
	}

}