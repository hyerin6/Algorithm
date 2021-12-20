package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B9657 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 1;
		dp[3] = 1;
		dp[4] = 1;

		for (int i = 5; i < N + 1; ++i) {
			// 1,3,4 = 합 3이면 뭐를 넣어도 다음 사람이 이김
			if (dp[i - 1] + dp[i - 3] + dp[i - 4] < 3) {
				dp[i] = 1;
			}
		}

		if (dp[N] == 1) {
			bw.write("SK");
		} else {
			bw.write("CY");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
