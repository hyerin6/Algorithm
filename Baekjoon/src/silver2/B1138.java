package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] memo = new int[N + 1];
		List<Integer> answer = new ArrayList<>();

		for (int i = 1; i < N + 1; ++i) {
			memo[i] = Integer.parseInt(st.nextToken());
		}

		// 키가 큰 사람부터 넣어준다.
		for (int i = N; i > 0; --i) {
			answer.add(memo[i], i);
		}

		for (int i : answer) {
			bw.write(i + " ");
		}

		bw.write("\n");
		bw.close();
		br.close();

	}
}
