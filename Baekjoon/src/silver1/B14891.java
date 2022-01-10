package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14891 {

	static final int x = 8;
	static final int y = 4;

	static int[][] wheel = new int[y][x];
	static int[][] turn;
	static int k;

	private static void solution(int currentWheel, int dir) {
		leftTurnCheck(currentWheel - 1, -dir);
		rightTurnCheck(currentWheel + 1, -dir);
		rotate(currentWheel, dir);
	}

	private static void rotate(int idx, int dir) {
		if (dir == 1) {
			int temp = wheel[idx][7];
			for (int i = 7; i > 0; --i) {
				wheel[idx][i] = wheel[idx][i - 1];
			}
			wheel[idx][0] = temp;
		} else {
			int temp = wheel[idx][0];
			for (int i = 0; i < 7; ++i) {
				wheel[idx][i] = wheel[idx][i + 1];
			}
			wheel[idx][7] = temp;
		}
	}

	// 왼쪽 바퀴 회전 여부 체크
	private static void leftTurnCheck(int currentWheel, int dir) {
		if (currentWheel < 0) {
			return;
		}
		if (wheel[currentWheel][2] != wheel[currentWheel + 1][6]) {
			leftTurnCheck(currentWheel - 1, -dir);
			rotate(currentWheel, dir);
		}
	}

	// 오른쪽 바퀴 회전 여부 체크
	private static void rightTurnCheck(int currentWheel, int dir) {
		if (currentWheel > 3) {
			return;
		}
		if (wheel[currentWheel][6] != wheel[currentWheel - 1][2]) {
			rightTurnCheck(currentWheel + 1, -dir);
			rotate(currentWheel, dir);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < y; ++i) {
			String input = br.readLine();
			for (int j = 0; j < x; ++j) {
				wheel[i][j] = input.charAt(j) - '0';
			}
		}

		k = Integer.parseInt(br.readLine());
		turn = new int[k][2];

		for (int i = 0; i < k; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < k; ++i) {
			solution(turn[i][0] - 1, turn[i][1]);
		}

		int total = 0;
		if (wheel[0][0] == 1) {
			total += 1;
		}
		if (wheel[1][0] == 1) {
			total += 2;
		}
		if (wheel[2][0] == 1) {
			total += 4;
		}
		if (wheel[3][0] == 1) {
			total += 8;
		}

		bw.write(total + "\n");
		bw.close();
		br.close();
	}
}
