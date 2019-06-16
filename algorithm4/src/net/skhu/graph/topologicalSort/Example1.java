package net.skhu.graph.topologicalSort;

public class Example1 {

	static class Vertex {
		String title;
		int parentCount = 0; // 부모가 없는 정점을 선택하기 위해 부모 수를 count한다.

		public Vertex(String title) {
			this.title = title;
		}
	}

	static class Edge {
		Vertex parent, child;

		public Edge(Vertex parent, Vertex child) {
			this.parent = parent;
			this.child = child;
			child.parentCount++; // 간선이 하나 만들어질때마다 부모수++;
		}
	}
	// 정점 목록
	static Vertex[] V = new Vertex[] {
			new Vertex("냄비에 물붓기"), new Vertex("점화"), new Vertex("라면넣기"),
			new Vertex("계란 풀어넣기"), new Vertex("라면봉지 뜯기"), new Vertex("수프넣기")
	};
	// 간선 목록
	static Edge[] E = new Edge[] {
			new Edge(V[0], V[1]), new Edge(V[1], V[2]), new Edge(V[1], V[3]),
			new Edge(V[1], V[5]), new Edge(V[2], V[3]), new Edge(V[4], V[2]),
			new Edge(V[4], V[5]), new Edge(V[5], V[3])
	};

	static Vertex[] topologicalSort() {
		Vertex[] A = new Vertex[V.length];
		for (int i = 0; i < A.length; ++i) { // A에 넣기 위해 A.length
			for (int j = 0; j < V.length; ++j) // V에서 부모가 없는 정점 선택하기 위해 
				if (V[j] != null && V[j].parentCount == 0) { // 진입 간선이 없는 정점 V[j] 선택
					A[i] = V[j];                             // V[j]를 A 배열에 추가
					for (int k = 0; k < E.length; ++k)
						if (E[k] != null && E[k].parent == V[j]) { // V[j] 진출 간선 찾기
							E[k].child.parentCount--;              // V[j] 진출 간선 제거
							E[k] = null;
						}
					V[j] = null;                                   // V[j] 제거
					break; 
					// break; 는 부모 정점이 없는 정점을 골라서 목록에 넣고 전부 제거했으니까 다음단계 즉, 줄37로 넘어감
				}
		}
		return A;
	}

	public static void main(String[] args) {
		Vertex[] a = topologicalSort();
		for (Vertex v : a)
			System.out.println(v.title);
	}
}
