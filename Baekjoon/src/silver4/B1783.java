package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1783 {

	public static int solution(int n, int m) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return Math.min(4, (m + 1) / 2);
		} else if (m < 7) {
			return Math.min(4, m);
		}
		return m - 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int answer = solution(N, M);
		System.out.println(answer);
	}
}
