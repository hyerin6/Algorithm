package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3460 {
	public static String findOne(int n) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while (n > 0) {
			int i = n % 2;
			n /= 2;
			if (i == 1) {
				sb.append(idx + " ");
			}
			idx++;
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String result = findOne(n);
			System.out.println(result);
		}

	}
}
