package net.skhu.graph.dijkstra_heap;

public class VertexHeap {

	Vertex[] a;
	int end;

	public VertexHeap(Vertex[] a) {
		this.a = a.clone();
		this.end = a.length - 1;
		buildHeap();
		for (int i = 0; i < a.length; ++i) {
			a[i].distance = Integer.MAX_VALUE;
			a[i].index = i;
		}
	}

	public Vertex extractMin() {
		Vertex min = a[0];
		a[0] = a[end];
		--end;
		heapifyDown(0);
		return min;
	}

	public int size() {
		return end + 1;
	}

	void swap(int i, int j) {
		Vertex temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		a[i].index = i;
		a[j].index = j;
	}

	void buildHeap() {
		for (int i = end / 2; i >= 0; --i)
			heapifyDown(i);
	}

	void heapifyDown(int k) {
		int left = 2 * k, right = 2 * k + 1;
		int smaller;
		if (right <= end)
			smaller = (a[left].compareTo(a[right]) < 0) ? left : right;
		else if (left <= end) smaller = left;
		else return;
		if (a[smaller].compareTo(a[k]) < 0) {
			swap(smaller, k);
			heapifyDown(smaller);
		}
	}

	public void heapifyUp(int k) {
		while (k > 0) {
			int parent = (k - 1) / 2;
			if (a[parent].compareTo(a[k]) < 0) break;
			swap(parent, k);
			k = parent;
		}
	}
}