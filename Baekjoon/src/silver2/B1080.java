package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1080
public class B1080 {

	private static int N;
	private static int M;
	private static int[][] A;
	private static int[][] B;

	// i,j 기준으로 3*3 크기만큼 비트 뒤집기
	private static void change(int x, int y) {
		for (int i = x; i < x + 3; ++i) {
			for (int j = y; j < y + 3; ++j) {
				A[i][j] = A[i][j] ^ 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < M; ++j) {
				A[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < M; ++j) {
				B[i][j] = s.charAt(j) - '0';
			}
		}

		int cnt = 0;
		// 탐색 시작 (배열 범위 넘어가지않게 row-2 , col-2 까지만 반복한다.)
		for (int i = 0; i < N - 2; ++i) {
			for (int j = 0; j < M - 2; ++j) {
				// i,j 가 다르다면 뒤집는다. (이 지점은 다시뒤집을수 없는 지점이므로 무조건 뒤집음)
				if (A[i][j] != B[i][j]) {
					change(i, j);
					cnt++;
				}
			}
		}

		// A,B 배열이 같은지 확인
		int flag = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (A[i][j] == B[i][j])
					flag++;
			}
		}

		if (flag != N * M) {
			cnt = -1;
		}

		System.out.println(cnt);
	}

}