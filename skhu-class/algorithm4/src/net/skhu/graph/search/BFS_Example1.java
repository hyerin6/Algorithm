package net.skhu.graph.search;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Example1 {

	// 간선에 방향, 가중치가 없는 그래프 
	public static HashMap<Character, String> createGraph() {
		HashMap<Character, String> map = new HashMap<>();
		map.put('A', "BCD");  // A 정점에 인접한 정점 목록 등록
		map.put('B', "AC");   // B 정점에 인접한 정점 목록 등록
		map.put('C', "ABDE");
		map.put('D', "ACFG");
		map.put('E', "C");
		map.put('F', "DGH");
		map.put('G', "DFH");
		map.put('H', "FG");
		return map;
	}

	// 다음에 방문할 정점 목록을 Queue에 저장하면서 탐색하면 BFS이다. 
	public static void BFS(HashMap<Character,String> 그래프, char 시작정점) {
		HashSet<Character> visited = new HashSet<>();
		Queue<Character> 다음에방문할정점목록 = new LinkedList<Character>();

		visited.add(시작정점);
		다음에방문할정점목록.add(시작정점);

		while(다음에방문할정점목록.isEmpty() == false) {
			char 현재정점 = 다음에방문할정점목록.remove();

			System.out.printf("%c ", 현재정점);

			String 인접정점목록 = 그래프.get(현재정점);
			for(char 인접정점 : 인접정점목록.toCharArray())
				if (visited.contains(인접정점) == false) {
					visited.add(인접정점);
					다음에방문할정점목록.add(인접정점);
				}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS(createGraph(), 'A');
	}

}
