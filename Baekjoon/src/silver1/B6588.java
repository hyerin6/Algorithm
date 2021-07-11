package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B6588 {

	static boolean[] prime;

	static void getPrimeNumbers(int end) {
		prime = new boolean[end + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; (i * i) <= end; ++i) {
			if (prime[i]) {
				for (int j = i * 2; j <= end; j += i) {
					prime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		getPrimeNumbers(1000000);

		while (true) {
			int num = Integer.parseInt(br.readLine());
			boolean ok = false;
			if (num == 0) {
				break;
			}
			for (int i = 2; i <= num / 2; i++) {
				if (prime[i] && prime[num - i]) {
					sb.append(num + " = " + i + " + " + (num - i) + "\n");
					ok = true;
					break;
				}
			}
			if (!ok) {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
		}

		System.out.println(sb);
	}
}
