package net.skhu.graph.topologicalSort;

public class Example2 {

	static class Vertex {
		String title;
		int parentCount = 0;
		Vertex[] children = new Vertex[0]; // 자식 목록이 있으면 연결된 간선만 확인하면되기 때문

		public Vertex(String title) {
			this.title = title;
		}

		public void addChildren(Vertex ... children) {
			this.children = children;
			for (Vertex child : children)
				child.parentCount++;
		}
	}

	static Vertex[] createGraph() {
		Vertex[] V = new Vertex[] {
				new Vertex("냄비에 물붓기"), new Vertex("점화"), new Vertex("라면넣기"),
				new Vertex("계란 풀어넣기"), new Vertex("라면봉지 뜯기"), new Vertex("수프넣기")
		};
		V[0].addChildren(V[1]);
		V[1].addChildren(V[2], V[3], V[5]);
		V[2].addChildren(V[3]);
		V[4].addChildren(V[2], V[5]);
		V[5].addChildren(V[3]);
		return V;
	}

	static Vertex[] topologicalSort(Vertex[] V) {
		Vertex[] A = new Vertex[V.length];
		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < V.length; ++j)
				if (V[j] != null && V[j].parentCount == 0) { // 진입 간선이 없는 정점 V[j] 선택
					A[i] = V[j];                             // V[j]를 A 배열에 추가
					for (Vertex child : V[j].children)       // 선택된 정점의 자식 목록만 검사하면됨
						child.parentCount--;                 // V[j] 진출 간선 제거
					V[j] = null;
					break;
				}
		}
		return A;
	}

	public static void main(String[] args) {
		Vertex[] V = createGraph();
		Vertex[] A = topologicalSort(V);
		for (Vertex v : A)
			System.out.println(v.title);
	}
}
