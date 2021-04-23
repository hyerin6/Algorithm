package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://blog.naver.com/hyerin_0611/222320534775
public class B1347 {

	static int dir = 2; // 처음엔 남쪽 방향을 바라보고 있음 : x = x+1, y=0

	// left, down, right, up : dir이 0, 1, 2, 3 일 때 이동 방향
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] map = new char[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		for (int i = 0; i < 101; i++) {
			Arrays.fill(map[i], '#');
		}

		int x = 50, y = 50; //홍준이의 현재 위치
		int minX = 50, maxX = 50, minY = 50, maxY = 50;
		map[x][y] = '.';

		for (int i = 0; i < input.length; ++i) {
			if (input[i] == 'R') { // 오른쪽 방향으로 90도, dir이 3보다 크면 다시 남쪽 방향
				dir = dir + 1 == 4 ? 0 : dir + 1;
			} else if (input[i] == 'L') { // 왼쪽 방향으로 90도, dir이 0보다 작으면 북쪽 방향
				dir = dir - 1 == -1 ? 3 : dir - 1;
			} else {
				x += dx[dir];
				y += dy[dir];
				map[x][y] = '.';
				minX = Math.min(x, minX);
				minY = Math.min(y, minY);
				maxX = Math.max(x, maxX);
				maxY = Math.max(y, maxY);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = minX; i <= maxX; ++i) {
			for (int j = minY; j <= maxY; ++j) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}
