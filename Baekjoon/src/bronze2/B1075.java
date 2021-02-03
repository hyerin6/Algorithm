package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());

		int temp = (N / 100) * 100; // 맨 뒤 2자리 없애기

		while (true) {
			if (temp % F == 0) {
				int result = temp % 100;
				if (result < 10) {
					System.out.println("0" + result);
				} else {
					System.out.println(result);
				}
				return;
			}
			temp++;
		}
	}
}
