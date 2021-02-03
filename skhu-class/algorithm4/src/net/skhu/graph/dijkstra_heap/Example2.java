package net.skhu.graph.dijkstra_heap;

import java.util.HashMap;

public class Example2 {

	static Vertex[] createGraph() {
		Vertex[] V = new Vertex[] {
				new Vertex("A"), new Vertex("B"), new Vertex("C"), new Vertex("D"),
				new Vertex("E"), new Vertex("F"), new Vertex("G"), new Vertex("H") };
		final int A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6, H = 7;
		V[A].edge = new Edge[] { new Edge(11, V[B]), new Edge(9, V[C]), new Edge(8, V[D]) };
		V[B].edge = new Edge[] { new Edge(8, V[E]), new Edge(8, V[F]) };
		V[C].edge = new Edge[] { new Edge(3, V[B]), new Edge(6, V[D]), new Edge(1, V[G]) };
		V[D].edge = new Edge[] { new Edge(10, V[G]) };
		V[E].edge = new Edge[] { new Edge(7, V[F]) };
		V[F].edge = new Edge[] { new Edge(12, V[C]), new Edge(5, V[H]) };
		V[G].edge = new Edge[] { new Edge(2, V[H]) };
		V[H].edge = new Edge[] { new Edge(4, V[E]) };
		return V;
	}

	static void dijkstra(Vertex[] V, Vertex start, HashMap<Vertex, Vertex> previous) {
		VertexHeap heap = new VertexHeap(V);
		start.distance = 0;
		heap.heapifyUp(start.index);
		while (heap.size() > 0) {
			Vertex u = heap.extractMin();
			u.visited = true;
			for (Edge e : u.edge) {
				Vertex v = e.vertex;
				if (v.visited == false && v.distance > u.distance + e.weight) {
					v.distance = u.distance + e.weight;
					heap.heapifyUp(v.index);
					previous.put(v, u);
				}
			}
		}
	}

	public static void main(String[] args) {
		Vertex[] V = createGraph();
		HashMap<Vertex, Vertex> previous = new HashMap<>();
		dijkstra(V, V[0], previous);

		for (Vertex v : V) {
			Vertex parent = previous.get(v);
			System.out.printf("Vertex:%s  parent:%s distance:%d\n",
					v.title, parent != null ? parent.title : "", v.distance);
		}
	}
}
