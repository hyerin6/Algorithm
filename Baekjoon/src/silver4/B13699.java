package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B13699 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		long dp[] = new long[36];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(i + " " + j);
				dp[i] += (dp[j] * dp[i - 1 - j]);
			}
		}

		bw.write(String.valueOf(dp[n]));
		bw.close();
	}
}
