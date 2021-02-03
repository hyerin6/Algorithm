package bronze2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1173 {
	/*
	N: 운동하려는 시간
	m: 초기 맥박
	M: 맥박 max
	T: 운동 시 1분 동안 증가하는 맥박
	R: 휴식 시 1분 동안 감소하는 맥박
	 */
	static int N;
	static int m;
	static int M;
	static int T;
	static int R;
	static int current;

	private static int simulate() {
		int time = 0;
		int cnt = 0;

		if (m + T > M) {
			return -1;
		}

		while (time < N) {
			if (current + T <= M) {
				exercise();
				time++;
				cnt++;
			} else {
				rest();
				cnt++;
			}
		}

		return cnt;
	}

	private static void rest() {
		int tmp = current - R;

		if (tmp < m) {
			current = m;
		} else {
			current = tmp;
		}
	}

	private static void exercise() {
		current += T;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		m = current = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		bw.write(simulate() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
