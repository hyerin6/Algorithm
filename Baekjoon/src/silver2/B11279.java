package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class B11279 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// PriorityQueue는 add와 poll 모두 O(log n)
		// PriorityQueue는 기본적으로 오름차순 정렬
		Queue<Integer> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		while (N-- > 0) {
			int k = Integer.parseInt(br.readLine());
			if (k == 0) {
				if (q.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					// 출력할 땐 다시 -1을 곱해서 양수로
					sb.append(q.poll() * -1 + "\n");
				}
			} else {
				// 최댓값을 삭제해야 하므로 삽입 시 -1을 곱해준다.
				q.add(k * -1);
			}
		}

		System.out.println(sb.toString());

	}
}
