package net.skhu.graph.search;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class DFS_Example2a {

	public static HashMap<Character, String> createGraph() {
		HashMap<Character, String> map = new HashMap<>();
		map.put('A', "HFB");  // A 정점에 인접한 정점 목록 등록
		map.put('B', "FECA"); // B 정점에 인접한 정점 목록 등록
		map.put('C', "EDB");
		map.put('D', "EC");
		map.put('E', "DCB");
		map.put('F', "HGBA");
		map.put('G', "F");
		map.put('H', "FA");
		return map;
	}

	// 인접한 노드의 순서만 바꿔주니, DFS 구현 #1의 방문 순서와 동일하게 방문함을 확인할 수 있다.
	// DFS를 재귀호출로 구현한 경우에는, Stack 객체 대신 Stack Segment를 사용하며 탐색하게 된다.
	public static void DFS(HashMap<Character,String> 그래프, char 시작정점) {
		HashSet<Character> 방문한정점 = new HashSet<>();
		Stack<Character> 다음에방문할정점목록 = new Stack<>();
		방문한정점.add(시작정점);
		다음에방문할정점목록.push(시작정점);
		while (다음에방문할정점목록.isEmpty() == false) {
			char 현재정점 = 다음에방문할정점목록.pop();
			System.out.printf("%c ", 현재정점);
			String 인접정점목록 = 그래프.get(현재정점);
			for (char 인접정점 : 인접정점목록.toCharArray())
				if (방문한정점.contains(인접정점) == false) {
					방문한정점.add(인접정점);
					다음에방문할정점목록.add(인접정점);
				}
		}
	}

	public static void main(String[] args) {
		DFS(createGraph(), 'A');
	}
}