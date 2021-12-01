package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class B1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			if (val == 0) {
				if (q.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(q.poll());
				}
			} else {
				q.add(val);
			}
		}

	}
}
