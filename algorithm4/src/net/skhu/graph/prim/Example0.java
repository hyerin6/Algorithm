package net.skhu.graph.prim;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Example0 {

	static class Edge implements Comparable<Edge> {
		public String 정점1,정점2;
		public int 가중치;

		public Edge(String 정점1, int 가중치, String 정점2) {
			this.정점1 = 정점1;
			this.가중치 = 가중치;
			this.정점2 = 정점2;
		}

		@Override
		public int compareTo(Edge 간선1) {
			return this.가중치 - 간선1.가중치;
		}
	}

	public static HashMap<String, Edge[]> createGraph() {
		HashMap<String, Edge[]> map = new HashMap<>();
		map.put("철수", new Edge[] { new Edge("철수",9,"영희"), new Edge("철수",7,"동건"), new Edge("철수",5,"준호"), new Edge("철수",6,"승우") });
		map.put("영희", new Edge[] { new Edge("영희",9,"철수"), new Edge("영희",9,"동건"), new Edge("동건",5,"재상") });
		map.put("동건", new Edge[] { new Edge("동건",7,"철수"), new Edge("동건",5,"재상"), new Edge("동건",9,"영희") });
		map.put("재상", new Edge[] { new Edge("재상",5,"동건"), new Edge("재상",1,"승우") });
		map.put("준호", new Edge[] { new Edge("준호",5,"철수"), new Edge("준호",5,"승우") });
		map.put("승우", new Edge[] { new Edge("승우",1,"재상"), new Edge("승우",5,"준호"), new Edge("승우",6,"철수") });
		return map;
	}

	public static void prim(HashMap<String,Edge[]> 그래프, String 시작정점, ArrayList<Edge> 트리) {
		HashSet<String> 방문한정점 = new HashSet<>();
		PriorityQueue<Edge> 방문할정점 = new PriorityQueue<>();
		방문할정점.add(new Edge("없음", 0, 시작정점)); // 시작정점을 방문하기 위한 dummy 간선 생성
		while (방문할정점.size() > 0) {
			Edge 최소간선 = 방문할정점.remove(); // 가중치 최소 간선 선택
			if (방문한정점.contains(최소간선.정점2)) continue;// 이미 방문한 정점에 대한 간선이라면 무시
			트리.add(최소간선);                  // 그 간선을 최소 신장 트리에 추가
			String 현재정점 = 최소간선.정점2;    // 최소 간선에 연결된 정점 방문
			방문한정점.add(현재정점);
			for (Edge 간선 : 그래프.get(현재정점))  // 방문한 정점에 연결된 간선 각각에 대해서
				if (방문한정점.contains(간선.정점2) == false) // 그 간선으로 연결된 정점을 방문안했으면
					방문할정점.add(간선);           // 그 간선을 방문할 간선 목록에 추가
		}
	}

	public static void main(String[] args) {
		ArrayList<Edge> 트리 = new ArrayList<>();
		prim(createGraph(), "철수", 트리);
		for (Edge 간선 : 트리)
			System.out.printf("Vertex:%s  parent:%s distance:%d\n",간선.정점2, 간선.정점1, 간선.가중치);

	}
}