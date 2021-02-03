package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5618 {

	static int gcd(int a, int b) {
		return b != 0 ? gcd(b, a % b) : a;
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	static void solution(int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			result = gcd(result, arr[i]);
		}

		for (int i = 1; i <= result; ++i) {
			if (result % i == 0)
				System.out.println(i);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] A = new int[N];

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(tokenizer.nextToken());
		}

		solution(A);
	}

}
