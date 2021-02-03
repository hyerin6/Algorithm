package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644 {

	static int BFS(ArrayList<Integer>[] list, int 정점1, int 정점2, int[] d) {
		Queue<Integer> 다음에방문할정점목록 = new LinkedList<>();
		다음에방문할정점목록.add(정점1);

		while (!다음에방문할정점목록.isEmpty()) {
			int 현재정점 = 다음에방문할정점목록.remove();

			if (현재정점 == 정점2)
				return d[현재정점] == 0 ? -1 : d[현재정점];

			for (int 인접정점 : list[현재정점]) {
				if (d[인접정점] != 0)
					continue;
				d[인접정점] = d[현재정점] + 1;
				다음에방문할정점목록.add(인접정점);
			}
		}

		return -1;
	}

	static int result = 0;

	static void DFS(ArrayList<Integer>[] list, int end, int now, int before, int count) {
		if (end == now) {
			result = count;
			return;
		}

		for (int 인접정점 : list[now]) {
			if (인접정점 == before)
				continue;
			DFS(list, end, 인접정점, now, count + 1);
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer t = new StringTokenizer(br.readLine());
		int 사람1 = Integer.parseInt(t.nextToken());
		int 사람2 = Integer.parseInt(t.nextToken());
		int 관계수 = Integer.parseInt(br.readLine());
		int[] d = new int[n + 1];
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; ++i)
			list[i] = new ArrayList<>();

		for (int i = 0; i < 관계수; ++i) {
			t = new StringTokenizer(br.readLine());
			int 부모 = Integer.parseInt(t.nextToken());
			int 자식 = Integer.parseInt(t.nextToken());
			list[부모].add(자식);
			list[자식].add(부모);
		}

		System.out.println(BFS(list, 사람1, 사람2, d));
		DFS(list, 사람2, 사람1, 0, 0);
		System.out.println(result == 0 ? -1 : result);

	}

}
