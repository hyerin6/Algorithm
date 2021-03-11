package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://blog.naver.com/hyerin_0611/222271973010
public class B1331 {

	static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
	static int dy[] = {2, 1, -1, -2, -2, -1, 1, 2};

	static int visited[][] = new int[6][6];
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();

		int x = start.charAt(0) - 'A';
		int y = start.charAt(1) - '1';

		visited[x][y] = 1;

		// 현재 좌표
		int tx = x;
		int ty = y;

		for (int i = 0; i < 35; i++) {
			String last = br.readLine();

			int lx = last.charAt(0) - 'A';
			int ly = last.charAt(1) - '1';

			flag = false;

			// 어떤 좌표에서 이동할 수 있는 경우의 수는 8가지
			for (int k = 0; k < 8; k++) {
				int nx = dx[k] + tx;
				int ny = dy[k] + ty;

				//  6×6 체스판 범위 체크
				if (nx < 0 || 6 < nx || ny < 0 || 6 < ny) {
					continue;
				}

				// 입력된 좌표가 이동할 수 있는 좌표이며 방문한 적이 없으면 방문한다.
				if (nx == lx && ny == ly && visited[nx][ny] == 0) {
					visited[lx][ly] = 1;
					flag = true;
					break;
				}

			}

			// 입력된 좌표가 방문 가능이면, 방문하고 현재 좌표를 입력 좌표(마지막 좌표)로 변경한다.
			if (flag) {
				tx = lx;
				ty = ly;
			}
			// 입력된 좌표를 이미 방문했거나 방문할 수 없으면 나이트 투어가 아니다.
			else {
				System.out.println("Invalid");
				return;
			}

		}

		/*
		x, y는 시작 좌표, tx, ty는 마지막 좌표이다.
		마지막으로 방문한 칸에서 8가지 방문 가능한 좌표 중 시작 좌표가 존재하면 나이트 투어이다.
		즉 (마지막 좌표 + 방문 가능 좌표 인덱스) == 시작 좌표 인 경우 나이트 투어
		 */
		flag = false;
		for (int i = 0; i < 8; i++) {
			if ((tx + dx[i]) == x && (ty + dy[i]) == y) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}
}
