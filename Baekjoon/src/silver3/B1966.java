package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1966 {

	static StringBuilder sb;

	public static void solution(LinkedList<int[]> q, int M) {
		int count = 0;

		while (!q.isEmpty()) {
			int[] front = q.poll();
			boolean isMax = true;

			for (int i = 0; i < q.size(); ++i) {
				if (front[1] < q.get(i)[1]) {
					q.offer(front);
					for (int j = 0; j < i; ++j) {
						q.offer(q.poll());
					}
					isMax = false;
					break;
				}
			}

			if (!isMax) {
				continue;
			}

			count++;
			if (front[0] == M) { // 찾고자 하는 문서라면 해당 테스트 종료
				break;
			}
		}

		sb.append(count).append('\n');
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			LinkedList<int[]> q = new LinkedList<>();
			for (int i = 0; i < N; ++i) {
				// { 초기 위치, 중요도 }
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}

			solution(q, M);
		}

		System.out.println(sb.toString());
	}
}
