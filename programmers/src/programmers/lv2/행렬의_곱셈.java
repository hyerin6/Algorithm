package programmers.lv2;

import java.util.Arrays;

public class 행렬의_곱셈 {
	/*
	1 4         3 3		15 15 15
	3 2	   * 	3 3	 =	15 15 15
	4 1					15 15 15

	2 3 2		5 4 3	22 22 11
	4 2 4   *	2 4 1 = 36 28 18
	3 1 4		3 1 1   29 20 14

	 */
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; ++i) {
			for (int j = 0; j < arr2[0].length; ++j) {
				for (int k = 0; k < arr1[0].length; ++k) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[][] result = solution(new int[][] {{1, 4}, {3, 2}, {4, 1}},
			new int[][] {{3, 3}, {3, 3}});

		for (int i = 0; i < result.length; ++i) {
			System.out.println(Arrays.toString(result[i]));
		}

	}
}
