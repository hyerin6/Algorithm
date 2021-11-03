package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1541
public class B1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] subtraction = br.readLine().split("-");
		int sum = Integer.MAX_VALUE;

		for (int i = 0; i < subtraction.length; ++i) {
			int temp = 0;
			String[] addition = subtraction[i].split("\\+");

			for (int j = 0; j < addition.length; ++j) {
				temp += Integer.parseInt(addition[j]);
			}

			// 첫 번째 토큰인 경우 temp 값이 첫 번째 수가 됨
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}

		System.out.println(sum);

	}
}
