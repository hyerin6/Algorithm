package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10026 {

	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, 1, -1, 0};
	static int N;
	static char[][] map;

	static void dfs(int y, int x, boolean[][] visit, char ch) {
		visit[y][x] = true;

		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] != ch) {
				continue;
			}
			dfs(ny, nx, visit, ch);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		int[] ans = {0, 0};
		boolean[][][] visit = new boolean[2][N][N];

		for (int i = 0; i < N; ++i) {
			map[i] = br.readLine().toCharArray();
		}

		for (int k = 0; k < 2; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (!visit[k][i][j]) {
						dfs(i, j, visit[k], map[i][j]);
						ans[k]++;
					}
					if (map[i][j] == 'G') {
						map[i][j] = 'R';
					}
				}
			}
		}

		bw.write(ans[0] + " " + ans[1] + "\n");
		bw.close();
		br.close();

	}
}
