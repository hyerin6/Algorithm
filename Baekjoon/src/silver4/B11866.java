package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; ++i) {
			q.offer(i);
		}

		int[] answer = new int[N];
		int idx = 0;
		int cnt = 0;
		while (!q.isEmpty()) {
			cnt++;
			int n = q.poll();
			if (cnt == K) {
				cnt = 0;
				answer[idx] = n;
				idx++;
			} else {
				q.add(n);
			}
		}

		System.out.print("<");
		for (int i = 0; i < N - 1; ++i) {
			System.out.print(answer[i] + ", ");
		}
		System.out.print(answer[N - 1] + ">");
	}
}
