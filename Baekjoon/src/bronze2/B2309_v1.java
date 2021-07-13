package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class B2309_v1 {
	static boolean flag;

	public static void comb(int[] arr, boolean[] visited, int depth, int r, int sum) {
		if (flag) {
			return;
		}

		if (r == 0 && sum == 100) {
			print(arr, visited);
			flag = true;
			return;
		}
		if (depth == arr.length) {
			return;
		} else {
			visited[depth] = true;
			comb(arr, visited, depth + 1, r - 1, sum + arr[depth]);
			visited[depth] = false;
			comb(arr, visited, depth + 1, r, sum);
		}
	}

	public static void print(int[] arr, boolean[] visited) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 9; ++i) {
			if (visited[i]) {
				result.add(arr[i]);
			}
		}
		result.sort(Comparator.comparingInt(x -> x));
		result.forEach(System.out::println);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = new int[9];
		for (int i = 0; i < 9; ++i) {
			input[i] = Integer.parseInt(br.readLine());
		}

		comb(input, new boolean[9], 0, 7, 0);
	}
}
