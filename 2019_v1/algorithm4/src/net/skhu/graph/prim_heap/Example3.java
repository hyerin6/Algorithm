package net.skhu.graph.prim_heap;

import java.util.HashMap;

public class Example3 {

	static Vertex[] createGraph() {
		Vertex[] V = new Vertex[] { new Vertex("A"), new Vertex("B"), new Vertex("C"),
				new Vertex("D"), new Vertex("E"), new Vertex("F"), new Vertex("G") };
		final Vertex A = V[0], B = V[1], C = V[2], D = V[3], E = V[4], F = V[5], G = V[6];
		A.edge = new Edge[] { new Edge(11,B), new Edge(9,C), new Edge(8,D) };
		B.edge = new Edge[] { new Edge(11,A), new Edge(13,C), new Edge(8,E) };
		C.edge = new Edge[] { new Edge(9,A), new Edge(13,B), new Edge(12,F), new Edge(5,G) };
		D.edge = new Edge[] { new Edge(8,A), new Edge(10,G) };
		E.edge = new Edge[] { new Edge(8,B), new Edge(7,F) };
		F.edge = new Edge[] { new Edge(12,C), new Edge(7,E) };
		G.edge = new Edge[] { new Edge(5,C), new Edge(10,D) };
		return V;
	}

	static void prim(Vertex[] V, Vertex start, HashMap<Vertex, Vertex> tree) {
		VertexHeap heap = new VertexHeap(V);
		start.distance = 0;                // 시작 정점의 거리를 0으로 설정
		heap.heapifyUp(start.index);       // 거리 값이 바뀐 시작 정점 heap 위치 재조정
		while (heap.size() > 0) {
			Vertex u = heap.extractMin();  // 힙에서 최소 거리 정점을 제거.
			u.visited = true;              // 최소 거리 정점을 방문함.
			for (Edge e : u.edge) {        // 최소 거리 정점에 연결된 간선 각각에 대해서
				Vertex v = e.vertex;       // 간선으로 열결된 이웃 정점
				// 아직 방문하지 않은 정점이고, 정점의 거리가 간선의 가중치보다 작다면
				if (v.visited == false && v.distance > e.weight) {
					v.distance = e.weight; // 정점의 거리를 간선의 가중치로 변경함.
					heap.heapifyUp(v.index); // 정점의 거리가 변경되었으므로, heap 위치 재조정
					tree.put(v, u);  // 정점의 부모를 현재 정점(최소거리 정점)으로 변경함.
				}
			}
		}
	}

	public static void main(String[] args) {
		Vertex[] V = createGraph();
		HashMap<Vertex, Vertex> tree = new HashMap<>();
		prim(V, V[0], tree);

		for (Vertex v : V) {
			Vertex parent = tree.get(v);
			System.out.printf("Vertex:%s  parent:%s distance:%d\n",
					v.title, parent != null ? parent.title : "없음", v.distance);
		}
	}
}
