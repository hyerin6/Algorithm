package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B9094 {

	public static int solution(int n, int m) {
		int cnt = 0;
		for (int i = 1; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if ((i * i + j * j + m) % (i * j) == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			bw.write(solution(n, m) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
