package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if (abs1 == abs2) { // 절대값이 같은 경우
				return o1 > o2 ? 1 : -1;
			}
			return abs1 - abs2;
		});

		while (N-- > 0) {
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
