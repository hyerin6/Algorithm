package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
	static int[] switches;

	public static void male(int num) {
		for (int i = 0; i < switches.length; ++i) {
			if ((i + 1) >= num && (i + 1) % num == 0) {
				switches[i] = switches[i] == 1 ? 0 : 1;
			}
		}
	}

	public static void female(int num) {
		int upper = num - 1;
		int lower = num - 1;
		
		while (true) {
			upper++;
			lower--;
			if (upper >= switches.length || lower < 0 || switches[lower] != switches[upper]) {
				upper--;
				lower++;
				break;
			}
		}

		for (int i = lower; i <= upper; i++) {
			switches[i] = switches[i] == 1 ? 0 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		switches = new int[N];
		for (int i = 0; i < N; ++i) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			if ("1".equals(st.nextToken())) { // 남학생
				male(Integer.parseInt(st.nextToken()));
			} else { // 여학생
				female(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N; i++) {
			if (i != 0 && i % 20 == 0) {
				System.out.println();
			}
			System.out.print(switches[i] + " ");
		}

	}
}
