package programmers.lv2;

import java.util.Arrays;

public class 쿼드압축후_개수세기 {

	static int[] answer = new int[2];

	public static int[] solution(int[][] arr) {
		quadtree(arr, 0, 0, arr.length);
		return answer;
	}

	private static void quadtree(int[][] arr, int x, int y, int size) {
		boolean check = false;
		int start = arr[x][y];

		for (int i = x; i < x + size; ++i) {
			for (int j = y; j < y + size; ++j) {
				if (start != arr[i][j]) {
					check = true;
					break;
				}
			}
			if (check) {
				break;
			}
		}

		// 같은 영역 안에 다른 수가 있으면 쪼갠다.
		if (check) {
			// 쪼개는 크기 : 4 -> 2 -> 1
			quadtree(arr, x, y, size / 2);
			quadtree(arr, x + size / 2, y, size / 2);
			quadtree(arr, x, y + size / 2, size / 2);
			quadtree(arr, x + size / 2, y + size / 2, size / 2);
		}
		// 같은 영역인데 모두 같은 수이면 하나로 계산
		else {
			if (start == 0) {
				answer[0]++;
			} else {
				answer[1]++;
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
		int[] result = solution(arr);
		System.out.println(Arrays.toString(result));
	}

}
