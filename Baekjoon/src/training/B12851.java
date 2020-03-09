package training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12851 {
	static int visited[] = new int[100001];
	public static void solution(int 수빈, int 동생) {
		Queue<Integer> 다음에방문할정점목록 = new LinkedList<>();
		다음에방문할정점목록.add(수빈);

		while(!다음에방문할정점목록.isEmpty()) {
			int 현재정점 = 다음에방문할정점목록.remove();

			if(현재정점 == 동생) return;

			if(현재정점+1 <= 100000 && visited[현재정점+1] == 0) {
				다음에방문할정점목록.add(현재정점+1);
				visited[현재정점+1] = visited[현재정점]+1;
			}

			if(현재정점-1 >= 0 && visited[현재정점-1] == 0) {
				다음에방문할정점목록.add(현재정점-1);
				visited[현재정점-1] = visited[현재정점]+1;
			}

			if(현재정점*2 <= 100000 && visited[현재정점*2] == 0) {
				다음에방문할정점목록.add(현재정점*2);
				visited[현재정점*2] = visited[현재정점]+1;
			}

		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(br.readLine());

		int 수빈 = Integer.parseInt(t.nextToken());
		int 동생 = Integer.parseInt(t.nextToken());

		solution(수빈, 동생);
		System.out.println(visited[동생]);

	}

}
