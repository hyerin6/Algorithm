package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2670 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		double[] input = new double[N];

		for (int i = 0; i < N; ++i) {
			input[i] = Double.parseDouble(br.readLine());
		}

		double max = input[0];
		for (int i = 1; i < N; ++i) {
			input[i] = Math.max(input[i], input[i - 1] * input[i]);
			max = Math.max(input[i], max);
		}

		System.out.printf("%.3f", max);

	}
}
