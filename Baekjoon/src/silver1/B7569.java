package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	int z;

	public Tomato(int z, int x, int y) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class B7569 {

	private static int M;
	private static int N;
	private static int H;
	private static int[][][] board;
	private static Queue<Tomato> tomatoQ;
	private static int[] dx = {-1, 0, 1, 0, 0, 0}; // 상, 하, 좌, 우, 위, 아래
	private static int[] dy = {0, 1, 0, -1, 0, 0};
	private static int[] dz = {0, 0, 0, 0, 1, -1};

	public static int bfs() {
		while (!tomatoQ.isEmpty()) {
			Tomato tomato = tomatoQ.remove();
			int z = tomato.z;
			int x = tomato.x;
			int y = tomato.y;

			for (int i = 0; i < 6; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (nx >= 0 && ny >= 0 && nz >= 0
					&& nx < N && ny < M && nz < H) {
					if (board[nz][nx][ny] == 0) {
						tomatoQ.add(new Tomato(nz, nx, ny));
						board[nz][nx][ny] = board[z][x][y] + 1;
					}
				}
			}
		}

		int result = Integer.MIN_VALUE;
		for (int h = 0; h < H; ++h) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (board[h][i][j] == 0) {
						return -1;
					}
					result = Math.max(result, board[h][i][j]);
				}
			}
		}

		return result - 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][N][M];
		tomatoQ = new LinkedList<>();

		for (int h = 0; h < H; ++h) {
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j) {
					board[h][i][j] = Integer.parseInt(st.nextToken());
					if (board[h][i][j] == 1) {
						tomatoQ.add(new Tomato(h, i, j));
					}
				}
			}
		}

		int answer = bfs();
		System.out.println(answer);

	}
}
