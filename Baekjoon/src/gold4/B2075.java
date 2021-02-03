package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N - 1; ++i) {
			q.poll();
		}

		System.out.println(q.poll());
	}
}
