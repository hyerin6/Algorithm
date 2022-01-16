package com.java.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드의 개수가 최대 300,000 개 이기 때문에 플로이드-워셜은 사용할 수 없다. 
public class 특정거리의_도시찾기 {

	public static int n, m, k, x;
	public static List<List<Integer>> graph = new ArrayList<>();
	public static int[] d = new int[300001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] sarr = br.readLine().split(" ");
		n = Integer.parseInt(sarr[0]);
		m = Integer.parseInt(sarr[1]);
		k = Integer.parseInt(sarr[2]);
		x = Integer.parseInt(sarr[3]);

		// 그래피 및 최단 거리 테이블 초기화
		for (int i = 0; i <= n; ++i) {
			graph.add(new ArrayList<>());
			d[i] = -1;
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}

		// 출발 도시까지의 거리는 0으로 설정
		d[x] = 0;

		// 너비 우선 탐색(BFS) 수행
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		while (!q.isEmpty()) {
			int now = q.poll();
			// 현재 도시에서 이동할 수 있는 모든 도시를 확인
			for (int i = 0; i < graph.get(now).size(); i++) {
				int nextNode = graph.get(now).get(i);
				// 아직 방문하지 않은 도시라면
				if (d[nextNode] == -1) {
					// 최단 거리 갱신
					d[nextNode] = d[now] + 1;
					q.offer(nextNode);
				}
			}
		}

		// 최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
		boolean check = false;
		for (int i = 1; i <= n; i++) {
			if (d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}

		// 만약 최단 거리가 K인 도시가 없다면, -1 출력
		if (!check) {
			System.out.println(-1);
		}
	}
}
