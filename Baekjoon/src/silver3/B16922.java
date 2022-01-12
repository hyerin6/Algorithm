package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16922 {

	static int N;
	static int[] sum;
	static int[] num = {1, 5, 10, 50};
	static int result;

	private static void dfs(int depth, int idx, int s) {
		if (depth == N) {
			if (sum[s] == 0) {
				sum[s] = 1;
				result++;
			}
			return;
		}
		for (int i = idx; i < num.length; ++i) {
			dfs(depth + 1, i, s + num[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sum = new int[10001];
		result = 0;
		dfs(0, 0, 0);
		System.out.println(result);
	}
}
