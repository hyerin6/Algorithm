package net.skhu.graph.topologicalSort;

import java.util.HashSet;
import java.util.LinkedList;

public class Example3 {

	static class Vertex {
		String title;
		int parentCount = 0;
		Vertex[] children = new Vertex[0];

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

	static LinkedList<Vertex> topologicalSort(Vertex[] V) {
		LinkedList<Vertex> A = new LinkedList<>();
		HashSet<Vertex> visited = new HashSet<>();
		for (Vertex v : V)
			if (visited.contains(v) == false) DFS_TS(v, visited, A);
		return A;
	}

	static void DFS_TS(Vertex v, HashSet<Vertex> visited, LinkedList<Vertex> A) {
		visited.add(v);
		for (Vertex child : v.children)
			if (visited.contains(child) == false) DFS_TS(child, visited, A);
		A.addFirst(v); // constant
	}

	public static void main(String[] args) {
		Vertex[] V = createGraph();
		LinkedList<Vertex> A = topologicalSort(V);
		for (Vertex v : A)
			System.out.println(v.title);
	}
}
