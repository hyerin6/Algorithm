package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10709 {
	static int H, W;
	static char[][] map;
	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		result = new int[H][W];

		for (int i = 0; i < H; ++i) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < H; ++i) {
			int cnt = 0;
			boolean flag = false;
			for (int j = 0; j < W; ++j) {
				if (map[i][j] == 'c') {
					result[i][j] = 0;
					cnt = 0;
					flag = true;
				}
				if (flag && map[i][j] == '.') {
					result[i][j] = ++cnt;
				}
				if (!flag && map[i][j] == '.') {
					result[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.close();
		br.close();
	}
}
