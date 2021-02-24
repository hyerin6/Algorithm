package silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B19947 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 1년, 3년, 5년 = 5%, 20%, 35%
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[] dp = new int[Y + 1];
		dp[0] = H;
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i < Y + 1; ++i) {
			list.clear();
			list.add(dp[i - 1] + dp[i - 1] * 5 / 100);
			if (i - 3 >= 0) {
				list.add(dp[i - 3] + dp[i - 3] * 20 / 100);
			}
			if (i - 5 >= 0) {
				list.add(dp[i - 5] + dp[i - 5] * 35 / 100);
			}
			Collections.sort(list);
			dp[i] = list.get(list.size() - 1);
		}

		bw.write(dp[Y] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
