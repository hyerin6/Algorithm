package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B20055 {
	public static int N;
	public static int K;
	public static int[] belt;
	public static int beltSize;
	public static boolean[] robot;

	public static int simulation(int cnt) {
		while (isOK()) {
			// 1. 벨트 한 칸 회전
			int temp = belt[beltSize - 1]; // 1. 벨트 한 칸 회전
			for (int i = beltSize - 1; i > 0; --i) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;

			// 벨트와 함께 로봇도 회전 
			for (int i = robot.length - 1; i > 0; --i) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;

			robot[N - 1] = false; // 내려가는 위치에 있는 로봇 내리기

			// 2. 로봇 이동가능하면 이동
			for (int i = N - 1; i > 0; --i) {
				if (robot[i - 1] && !robot[i] && belt[i] >= 1) {
					robot[i] = true;
					robot[i - 1] = false;
					belt[i]--;
				}
			}

			// 3. 올라가는 위치에 로봇 올리기
			if (belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			cnt++;
		}

		return cnt;
	}

	// 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료해야 한다.
	public static boolean isOK() {
		int cnt = 0;
		for (int i = 0; i < belt.length; ++i) {
			if (belt[i] == 0) {
				cnt++;
			}
			if (cnt >= K) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		beltSize = N * 2;
		belt = new int[beltSize];
		robot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < belt.length; ++i) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int answer = simulation(0);
		bw.write(answer + "\n");
		bw.close();
		br.close();
	}
}
