package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_v1 {

	// DFS를 재귀호출로 구현한 경우, Stack 객체 대신 Stack Segment를 사용하며 탐색한다.  
	static HashSet<Integer> 방문한정점 = new HashSet<>();

	public static void DFS(ArrayList<Integer>[] list, int 정점) {
		if (방문한정점.contains(정점))
			return;

		방문한정점.add(정점);
		System.out.printf("%d ", 정점 + 1);

		for (int 인접정점 : list[정점])
			if (!방문한정점.contains(인접정점))
				DFS(list, 인접정점);
	}

	public static void BFS(ArrayList<Integer>[] list, int 시작정점) {
		HashSet<Integer> 방문한정점 = new HashSet<>();
		Queue<Integer> 다음에방문할정점목록 = new LinkedList<>();

		다음에방문할정점목록.add(시작정점);
		방문한정점.add(시작정점);

		while (!다음에방문할정점목록.isEmpty()) {
			int 현재정점 = 다음에방문할정점목록.remove();
			System.out.printf("%d ", 현재정점 + 1);

			for (int 인접정점 : list[현재정점])
				if (!방문한정점.contains(인접정점)) {
					다음에방문할정점목록.add(인접정점);
					방문한정점.add(인접정점);
				}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer t = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(t.nextToken());
		int M = Integer.parseInt(t.nextToken());
		int V = Integer.parseInt(t.nextToken()) - 1;

		ArrayList<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; ++i)
			list[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; ++i) {
			t = new StringTokenizer(br.readLine());
			int 정점1 = Integer.parseInt(t.nextToken()) - 1;
			int 정점2 = Integer.parseInt(t.nextToken()) - 1;
			list[정점1].add(정점2);
			list[정점2].add(정점1);
		}

		for (int i = 1; i < N; i++)
			Collections.sort(list[i]);

		DFS(list, V);
		System.out.println();
		BFS(list, V);

	}

}
