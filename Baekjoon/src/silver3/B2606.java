package silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2606 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine()); // 컴퓨터 수 
		int N = Integer.parseInt(br.readLine()); // 연결 라인 수  

		ArrayList<Integer>[] list = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; ++i)
			list[i] = new ArrayList<Integer>();

		for (int i = 0; i < N; ++i) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			int 정점1 = Integer.parseInt(t.nextToken());
			int 정점2 = Integer.parseInt(t.nextToken());
			list[정점1].add(정점2);
			list[정점2].add(정점1);
		}

		// DFS 
		HashSet<Integer> 방문한정점 = new HashSet<>();
		Stack<Integer> 다음에방문할정점목록 = new Stack<>();

		다음에방문할정점목록.push(1);
		방문한정점.add(1);

		int count = 0;
		while (!다음에방문할정점목록.isEmpty()) {
			int 현재정점 = 다음에방문할정점목록.pop();
			for (int 인접정점 : list[현재정점])
				if (!방문한정점.contains(인접정점)) {
					방문한정점.add(인접정점);
					다음에방문할정점목록.push(인접정점);
					count++;
				}
		}

		System.out.println(count);

	}

}
