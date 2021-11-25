package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {

	private static int[][] map;
	private static int[] cnt = {0, 0};

	public static void partition(int row, int col, int size) {
		if (check(row, col, size)) {
			cnt[map[row][col]]++;
			return;
		}

		int newSize = size / 2;
		partition(row, col, newSize);
		partition(row, col + newSize, newSize);
		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);
	}

	private static boolean check(int row, int col, int size) {
		int color = map[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		partition(0, 0, N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}
}
