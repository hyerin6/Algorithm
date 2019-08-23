package net.skhu.graph.dijkstra;
import java.util.HashMap;
import java.util.HashSet;

public class Example2 {

	static class Vertex {   // 정점
		String title;       // 제목
		Edge[] edge;        // 연결된 간선 목록

		public Vertex(String title) {
			this.title = title;
		}
	}
	static class Edge {     // 간선
		int weight;         // 가중치
		Vertex vertex;      // 간선의 끝 정점

		public Edge(int weight, Vertex vertex) {
			this.weight = weight;
			this.vertex = vertex;
		}
	}

	static Vertex[] createGraph() {
		Vertex[] V = new Vertex[] {
				new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D"),
				new Vertex("E"), new Vertex("F"), new Vertex("G"), new Vertex("H") };
		V[0].edge = new Edge[] { new Edge(11, V[1]), new Edge(9, V[2]), new Edge(8, V[3]) };
		V[1].edge = new Edge[] { new Edge(8, V[4]), new Edge(8, V[5]) };
		V[2].edge = new Edge[] { new Edge(3, V[1]), new Edge(6, V[3]), new Edge(1, V[6]) };
		V[3].edge = new Edge[] { new Edge(10, V[6]) };
		V[4].edge = new Edge[] { new Edge(7, V[5]) };
		V[5].edge = new Edge[] { new Edge(12, V[2]), new Edge(5, V[7]) };
		V[6].edge = new Edge[] { new Edge(2, V[7]) };
		V[7].edge = new Edge[] { new Edge(4, V[4]) };
		return V;
	}

	// 아직 방문하지 않은 정점 중에서, 가중치 최소 간선으로 방문 가능한 정점 찾기
	//   V: 그래프의 모든 정점 목록,  visited:  방문한 정점 목록
	//   distance: 방문한 정점 중 하나에서, 방문하지 않은 정점 하나를 직접 연결하는 간선의 가중치
	// 이 메소드는, 아직 방문하지 않은 정점 중에서, distance 값이 최소인 정점을 찾아 리턴한다.
	static Vertex extractMin(Vertex[] V, HashSet<Vertex> visited, HashMap<Vertex, Integer> distance) {
		int min = Integer.MAX_VALUE;
		Vertex vertex = null;
		for (Vertex v : V)
			if (visited.contains(v) == false && distance.get(v) < min) {
				vertex = v;
				min = distance.get(v);
			}
		return vertex;
	}

	// dijkstra 알고리즘 구현
	//  V: 그래프의 모든 정점 목록, start: 시작정점,
	//  distance: 방문한 정점 중 하나에서, 방문하지 않은 정점 하나를 직접 연결하는 간선의 가중치
	//  tree: dijkstra 최단 경로 트리를 구성하는 간선 목록
	static void dijkstra(Vertex[] V, Vertex start, HashMap<Vertex, Integer> distance,
			HashMap<Vertex, Vertex> tree) {
		HashSet<Vertex> visited = new HashSet<>(); // 방문한 정점 목록 초기화
		for (Vertex v : V)
			distance.put(v, Integer.MAX_VALUE);    // distance 값을 전부 최대값으로 설정
		distance.put(start, 0);                    // 시작 정점의 distance에 0 대입
		while (visited.size() < V.length) {        // 그래프의 모든 정점을 방문할 때까지 반복
			Vertex u = extractMin(V, visited, distance); // distnance 값이 최소인 정점 선택
			visited.add(u);           // 그 정점 방문
			for (Edge e : u.edge) {   // 그 정점과 연결된 간선 각각에 대해서
				Vertex v = e.vertex;
				// 그 간선에 연결된 정점 v의 distance 값이 간선의 가중치 보다 작다면
				if (visited.contains(v) == false && distance.get(v) > distance.get(u) + e.weight) {
					distance.put(v, distance.get(u) + e.weight); // v의 distance 값 수정
					tree.put(v, u);        // 최소 신장트리에서 v의 부모를 u로 수정
				} // 시작부터 누적 거리를 계산하는 부분만 다르고 나머지는 prim 알고리즘과 동일함
			}
		}
	}

	public static void main(String[] args) {
		Vertex[] V = createGraph();
		HashMap<Vertex, Integer> distance = new HashMap<>();
		HashMap<Vertex, Vertex> tree = new HashMap<>();
		dijkstra(V, V[0], distance, tree);

		for (Vertex v : V) {
			Vertex parent = tree.get(v);
			System.out.printf("Vertex:%s  parent:%s distance:%d\n",
					v.title, parent != null ? parent.title : "없음", distance.get(v));
		}
	}
}