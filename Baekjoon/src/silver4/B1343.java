package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1343 {

	static StringBuilder sb = new StringBuilder();
	static final String A = "AAAA";
	static final String B = "BB";

	static void print(int cnt) {
		while (cnt > 0) {
			if (cnt >= 4) {
				sb.append(A);
				cnt -= 4;
			} else {
				sb.append(B);
				cnt -= 2;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int cnt = 0;

		for (int i = 0; i < str.length(); ) {
			if (str.charAt(i) == '.') {
				++i;
				sb.append(".");
				continue;
			}

			for (int j = i; j < str.length() && str.charAt(j) == 'X'; ++j) {
				cnt++;
			}

			i += cnt;

			if (cnt % 2 != 0) {
				System.out.println(-1);
				return;
			}

			print(cnt);
			cnt = 0;
		}

		System.out.println(sb.toString());
	}
}
