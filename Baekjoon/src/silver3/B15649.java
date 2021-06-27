package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://blog.naver.com/hyerin_0611/222342064483
public class B15649 {

	static int N;
	static int M;

	static boolean[] visit;
	static int[] arr;

	static StringBuilder sb;

	public static void dfs(int N, int M, int depth) {
		if (depth == M) { // depth가 M이랑 같으면 arr 출력
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; ++i) {
			if (visit[i] == false) {
				// 방문 처리
				visit[i] = true;
				arr[depth] = i;

				// 자신을 제외한 재귀 실행(visit 배열로 자신은 거를 수 있다.), 나머지 값 탐색
				dfs(N, M, depth + 1);

				// 백트래킹
				visit[i] = false;
			}
		}

		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		arr = new int[M];

		dfs(N, M, 0);
	}
}
