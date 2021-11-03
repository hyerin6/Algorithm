package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1455
public class B1455 {

	private static int N;
	private static int M;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int answer = 0;
		map = new int[M][N];

		for (int i = 0; i < M; ++i) {
			String input = br.readLine();
			for (int j = 0; j < N; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

	}
}
