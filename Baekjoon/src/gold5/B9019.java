package gold5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9019 {

	// n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4
	static class Register {
		int num;
		String command;

		Register(int num, String command) {
			this.num = num;
			this.command = command;
		}

		int D() {
			return (num * 2) % 10000;
		}

		int S() {
			return num == 0 ? 9999 : num - 1;
		}

		int L() {
			return num % 1000 * 10 + num / 1000;
		}

		int R() {
			return num % 10 * 1000 + num / 10;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[10000];
			visit[A] = true;

			Queue<Register> que = new LinkedList<>();
			que.add(new Register(A, ""));

			while (!que.isEmpty()) {
				Register cur = que.poll();

				if (cur.num == B) {
					bw.write(cur.command + "\n");
					break;
				}

				if (!visit[cur.D()]) {
					que.add(new Register(cur.D(), cur.command + "D"));
					visit[cur.D()] = true;
				}
				if (!visit[cur.S()]) {
					que.add(new Register(cur.S(), cur.command + "S"));
					visit[cur.S()] = true;
				}
				if (!visit[cur.L()]) {
					que.add(new Register(cur.L(), cur.command + "L"));
					visit[cur.L()] = true;
				}
				if (!visit[cur.R()]) {
					que.add(new Register(cur.R(), cur.command + "R"));
					visit[cur.R()] = true;
				}

			}
		}

		bw.close();
		br.close();

	}
}
