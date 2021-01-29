package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11720 {

	public static int sum(String[] input) {
		int answer = 0;
		int[] arr = new int[input.length];

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = Integer.parseInt(input[i]);
		}

		for (int a : arr) {
			answer += a;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("");

		int answer = sum(arr);
		System.out.println(answer);
	}
}
