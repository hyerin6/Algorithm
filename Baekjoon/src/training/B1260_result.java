package training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_result {
	private static int N, M, V; 
	private static int[][] map; 
	private static boolean[] visit; 

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer t = new StringTokenizer(br.readLine());
		N = Integer.parseInt(t.nextToken());
		M = Integer.parseInt(t.nextToken());
		V = Integer.parseInt(t.nextToken());

		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i = 0; i < N; ++i) 
			list[i] = new ArrayList<Integer>();

		map = new int[N+1][N+1]; 
		visit = new boolean[N+1];

		for(int i = 0; i < M; ++i) {
			t = new StringTokenizer(br.readLine());
			int 정점1 = Integer.parseInt(t.nextToken());
			int 정점2 = Integer.parseInt(t.nextToken());
			map[정점1][정점2] = map[정점2][정점1] = 1; 
		}

		// dfs 시작 
		dfs(V, N); 
		System.out.println("");

		visit = new boolean[N+1]; 
		// bfs 시작 
		bfs(V, N);

	} 

	private static void bfs(int k, int n) {
		Queue<Integer> queue = new LinkedList<>(); 
		queue.offer(k); 

		while(!queue.isEmpty()) {
			int temp = queue.poll(); 
			visit[temp] = true; 
			System.out.print(temp + " ");

			for(int i = 1; i <= n; i++) { 
				if(map[temp][i] == 1 && !visit[i]) { 
					queue.offer(i); 
					visit[i]= true;
				}
			} 
		}
	} 

	private static void dfs(int k, int n) { 
		if(visit[k]) 
			return; 

		// 방문
		visit[k] = true;
		System.out.print(k + " ");

		for(int i = 1; i <= n; i++) {
			if(map[k][i] == 1) { 
				dfs(i, n); 
			} 
		} 
	} 
}
