package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1699 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];

		// 제곱근 존재하는 수만 먼저 설정 -> 안해도된다.
		// 대신, 1이 몇 개 존재하는지 초기 설정을 해준다. (최댓값으로 초기 설정)
		for (int i = 1; i <= n; i++) {
			dp[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			// 최소가 되는 제곱수 = n의 이전 수 들 중 제곱수 + n - 제곱수의 최수항 개수
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - (j * j)] + 1) {
					dp[i] = dp[i - (j * j)] + 1;
				}
			}
		}

		bw.write(dp[n] + "\n");
		bw.flush();
		bw.close();
	}
}
