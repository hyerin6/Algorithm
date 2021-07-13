package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309_v2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; ++i) {
			input[i] = Integer.parseInt(br.readLine());
			sum += input[i];
		}

		Arrays.sort(input);

		for (int i = 0; i < input.length; ++i) {
			for (int j = i + 1; j < input.length; ++j) {
				if (sum - input[i] - input[j] == 100) {
					for (int k = 0; k < input.length; k++) {
						if (i != k && j != k) {
							System.out.println(input[k]);
						}
					}
					return;
				}
			}
		}
	}
}

