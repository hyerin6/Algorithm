package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] numbers = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int result = numbers[end] - numbers[start - 1];
			System.out.println(result);
		}
	}
}
