package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < B.length() - A.length() + 1; ++i) {
			String temp = B.substring(i, i + A.length());
			int cnt = 0;
			for (int j = 0; j < temp.length(); ++j) {
				if (A.charAt(j) != temp.charAt(j)) {
					++cnt;
				}
			}
			if (cnt < min) {
				min = cnt;
			}
		}

		System.out.println(min);
	}
}
