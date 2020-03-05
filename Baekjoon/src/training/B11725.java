package training;

import java.util.*;
import java.io.*;

public class B11725 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  

		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 0; i < N+1; ++i)
			list[i] = new ArrayList<Integer>();

		for(int i = 0; i < N-1; ++i) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			int 정점1 = Integer.parseInt(t.nextToken()); 
			int 정점2 = Integer.parseInt(t.nextToken()); 
			list[정점1].add(정점2);
			list[정점2].add(정점1);
		}

		HashSet<Integer> 방문한정점 = new HashSet<>();
		Stack<Integer> 다음에방문할정점목록 = new Stack<>();

		int[] parent = new int[N+1];

		다음에방문할정점목록.push(1);
		방문한정점.add(1);

		while(!다음에방문할정점목록.isEmpty()) {
			int 현재정점 = 다음에방문할정점목록.pop();

			for(int 인접정점 : list[현재정점])
				if(!방문한정점.contains(인접정점)) {
					다음에방문할정점목록.push(인접정점);
					방문한정점.add(인접정점);
					parent[인접정점] = 현재정점;
				}
		}

		for(int i = 2; i < parent.length; ++i) {
			System.out.println(parent[i]);
		}

	}

}
