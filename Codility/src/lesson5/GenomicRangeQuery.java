package lesson5;

import java.util.Arrays;

public class GenomicRangeQuery {

	public static int[] solution(String S, int[] P, int[] Q) {
		int N = S.length();
		int M = P.length;
		int[] result = new int[M];
		int[][] path = new int[4][N];
		
		switch (S.charAt(0)) {
			case 'A':
				path[0][0] = 1;
				break;
			case 'C':
				path[1][0] = 1;
				break;
			case 'G':
				path[2][0] = 1;
				break;
			case 'T':
				path[3][0] = 1;
				break;
		}

		for (int i = 1; i < N; ++i) {
			char c = S.charAt(i);
			switch (c) {
				case 'A':
					path[0][i] = path[0][i - 1] + 1;
					path[1][i] = path[1][i - 1];
					path[2][i] = path[2][i - 1];
					path[3][i] = path[3][i - 1];
					break;
				case 'C':
					path[0][i] = path[0][i - 1];
					path[1][i] = path[1][i - 1] + 1;
					path[2][i] = path[2][i - 1];
					path[3][i] = path[3][i - 1];
					break;
				case 'G':
					path[0][i] = path[0][i - 1];
					path[1][i] = path[1][i - 1];
					path[2][i] = path[2][i - 1] + 1;
					path[3][i] = path[3][i - 1];
					break;
				case 'T':
					path[0][i] = path[0][i - 1];
					path[1][i] = path[1][i - 1];
					path[2][i] = path[2][i - 1];
					path[3][i] = path[3][i - 1] + 1;
					break;
			}
		}

		for (int i = 0; i < M; ++i) {
			for (int p = 0; p < 4; ++p) {
				int sub = 0;
				if (P[i] > 0) {
					sub = path[p][P[i] - 1];
				}
				if (path[p][Q[i]] - sub > 0) {
					result[i] = p + 1;
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] answer = solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6});
		System.out.println(Arrays.toString(answer));
	}
}
