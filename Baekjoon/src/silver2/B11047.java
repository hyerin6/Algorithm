package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];
		int cnt = 0;
		int idx = 0;

		while (idx < N) {
			coin[idx] = Integer.parseInt(br.readLine());
			idx++;
		}

		for (int i = N - 1; i >= 0; --i) {
			if (coin[i] <= K) {
				cnt += K / coin[i];
				K = K % coin[i];
			}
		}

		System.out.println(cnt);
	}
}
