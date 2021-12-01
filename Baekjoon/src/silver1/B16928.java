package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16928 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] snakeAndladder = new int[101];
		boolean[] isVisited = new boolean[101];
		int[] count = new int[101];

		for (int i = 0; i < N + M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			snakeAndladder[a] = b;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		count[1] = 0;
		isVisited[1] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == 100) { // 먼저 100에 도착하면 cnt 출력
				System.out.println(count[now]);
				break;
			}

			for (int i = 1; i <= 6; ++i) {
				int next = now + i;

				if (100 < next || isVisited[next]) {
					continue;
				}

				// 사다리 혹은 뱀인 경우
				if (snakeAndladder[next] != 0) {
					if (!isVisited[snakeAndladder[next]]) { // 방문하지 않았으면
						isVisited[snakeAndladder[next]] = true; // 방문
						count[snakeAndladder[next]] = count[now] + 1; // 몇번째로 방문한건지 저장
						queue.offer(snakeAndladder[next]); // queue에 위치 저장
					}
				}
				// 아무것도 아닐 때
				else {
					isVisited[next] = true; // 방문
					count[next] = count[now] + 1; // 몇번째로 방문한건지 저장
					queue.offer(next); // queue에 위치 저장
				}
			}
		}
	}
}