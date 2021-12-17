package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3085 {
	static int answer;
	static char[][] map;
	static int n;

	public static void check() {
		for (int i = 0; i < n; ++i) {
			int cnt = 1;
			for (int j = 1; j < n; ++j) {
				if (map[i][j] == map[i][j - 1]) {
					++cnt;
				} else {
					answer = Math.max(answer, cnt);
					cnt = 1;
				}
			}
			answer = Math.max(answer, cnt);
		}

		for (int i = 0; i < n; ++i) {
			int cnt = 1;
			for (int j = 1; j < n; ++j) {
				if (map[j][i] == map[j - 1][i]) {
					++cnt;
				} else {
					answer = Math.max(answer, cnt);
					cnt = 1;
				}
			}
			answer = Math.max(answer, cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];

		for (int i = 0; i < n; ++i) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n - 1; ++j) {
				char temp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = temp;
				check();
				temp = map[i][j + 1];
				map[i][j + 1] = map[i][j];
				map[i][j] = temp;

				temp = map[j][i];
				map[j][i] = map[j + 1][i];
				map[j + 1][i] = temp;
				check();
				temp = map[j + 1][i];
				map[j + 1][i] = map[j][i];
				map[j][i] = temp;
			}
		}

		System.out.println(answer);

	}
}
