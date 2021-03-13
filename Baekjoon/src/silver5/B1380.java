package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1380 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;

		while (n != 0) {
			String[] names = new String[n];
			for (int i = 0; i < n; ++i) {
				names[i] = br.readLine();
			}

			String[] memo = new String[n + 1];
			StringTokenizer st;

			for (int i = 0; i < n * 2 - 1; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());
				String str = st.nextToken();
				memo[num] = memo[num] + str;
			}

			for (int i = 1; i < n + 1; ++i) {
				if (!(memo[i].contains("A") && memo[i].contains("B"))) {
					System.out.println(cnt + " " + names[i - 1]);
				}
			}

			n = Integer.parseInt(br.readLine());
			cnt++;
		}
	}
}