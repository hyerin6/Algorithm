package programmers.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전보 {
	static class Node implements Comparable<Node> {

		private int index;
		private int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public int getIndex() {
			return this.index;
		}

		public int getDistance() {
			return this.distance;
		}

		// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
		@Override
		public int compareTo(Node other) {
			if (this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
	}

	public static final int INF = (int)1e9;

	public static int N, M, C;

	public static List<List<Node>> graph = new ArrayList<>();

	public static int[] d = new int[100001];

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			if (d[now] < dist) {
				continue;
			}
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end, cost));
		}

		Arrays.fill(d, INF);

		dijkstra(C);

		// 도달할 수 있는 노드의 개수
		int count = 0;
		// 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
		int maxDistance = 0;
		for (int i = 1; i <= N; i++) {
			// 도달할 수 있는 노드인 경우
			if (d[i] != INF) {
				count += 1;
				maxDistance = Math.max(maxDistance, d[i]);
			}
		}

		// 시작 노드는 제외해야 하므로 count - 1을 출력
		System.out.println((count - 1) + " " + maxDistance);
	}

}
