package silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B8394 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int x = 1, y = 1;

		for (int i = 2; i <= N; i++) {
			int temp = x;
			x = (x + y) % 10;
			y = temp;
		}

		System.out.println(x);
	}
}
