package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1051 {

	private static boolean checkSquare(char[][] map, int i, int j, int l) {
		return map[i][j] == map[i + l][j] && map[i][j] == map[i][j + l] && map[i][j] == map[i + l][j + l];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < M; ++j) {
				map[i][j] = s.charAt(j);
			}
		}

		int maxLen = Math.max(N, M);
		int max = 1;

		loop:
		for (int l = maxLen; l > 0; --l) {
			for (int i = 0; i < N - l; ++i) {
				for (int j = 0; j < M - l; ++j) {
					if (checkSquare(map, i, j, l)) {
						max = l + 1;
						break loop;
					}
				}
			}
		}

		bw.write(max * max + "\n");
		bw.close();
		br.close();

	}
}
