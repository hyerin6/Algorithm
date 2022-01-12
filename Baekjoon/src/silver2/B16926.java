package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926 {
	static int N, M, R;
	static int[][] map;

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	private static void rotate(int s) {
		for (int i = 0; i < s; ++i) {
			int direction = 0; // 방향
			int sx = i;  // 시작점 (왼쪽 위)
			int sy = i;
			int temp = map[sx][sy];
			while (direction < 4) {
				int nextX = sx + dx[direction];
				int nextY = sy + dy[direction];
				// 사각형을 벗어나지 않으면 계속 진행
				if (nextX < i && nextY < i && nextX >= N - i && nextY >= M - i) {
					map[sx][sy] = map[nextX][nextY];  // a00 = a01  => a01 = a02
					sx = nextX;
					sy = nextY;
				} else { // 벗어나면 방향 전환
					direction++;
				}
			}
			map[i + 1][i] = temp; // a10 = a00
		}
	}

	private static void print() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int s = Math.min(N, M) / 2; //  회전하는 사각형의 갯수

		for (int i = 0; i < R; i++) {
			rotate(s);
		}
		print();
	}

}
