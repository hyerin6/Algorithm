package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2577 {

	private static void solution2(int A, int B, int C) {
		int[] counts = new int[10];
		int number = A * B * C;
		while (number > 0) {
			counts[number % 10]++;
			number /= 10;
		}

		for (int i = 0; i < counts.length; ++i) {
			System.out.println(counts[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		int[] counts = new int[10];
		String input = String.valueOf(A * B * C);
		for (int i = 0; i < input.length(); ++i) {
			counts[input.charAt(i) - '0']++;
		}

		for (int i = 0; i < counts.length; ++i) {
			System.out.println(counts[i]);
		}

		System.out.println("\n========\n");

		int A2 = Integer.parseInt(br.readLine());
		int B2 = Integer.parseInt(br.readLine());
		int C2 = Integer.parseInt(br.readLine());
		solution2(A2, B2, C2);
	}

}
