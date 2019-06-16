package net.skhu.graph.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Edge implements Comparable<Edge> {
	String 정점1,정점2;
	int 가중치;

	public Edge(String 정점1, int 가중치, String 정점2) {
		this.정점1 = 정점1;
		this.가중치 = 가중치;
		this.정점2 = 정점2;
	}

	@Override
	public int compareTo(Edge arg) { // 가중치 오름차순 정렬을 위해서 구현함.
		return this.가중치 - arg.가중치;
	}
}

public class Example1 {
	static String[] 정점목록 = new String[] { "철수", "영희", "준호", "승우", "재상", "동건" };

	static Edge[] 간선목록 = new Edge[] {
			new Edge("철수",9,"영희"), new Edge("철수",7,"동건"), new Edge("철수",5,"준호"),
			new Edge("철수",6,"승우"),new Edge("영희",9,"동건"),
			new Edge("준호",5,"승우"), new Edge("승우",1,"재상"),
			new Edge("재상",5,"동건")
	};

	// key: 정점, value: 정점이 소속된 집합
	static HashMap<String,HashSet<String>> 소속집합 = new HashMap<>();
	static ArrayList<Edge> 최소신장트리 = new ArrayList<>();

	/*
	// 집합2에 소속된 정점들을 집합1에 넣는다
	static void 합집합(HashSet<String> 집합1, HashSet<String> 집합2) {
		for (String 정점2 : 집합2)       // 집합2에 소속된 정점들 각각에 대해서
			소속집합.put(정점2, 집합1);  // 소속 집합을 집합1로 변경한다
		집합1.addAll(집합2);             // 집합2의 모든 원소들을 집합1에 넣는다
	}                                    // 집합2 객체는 garbage collection 된다.
	 */

	// 개선된 합집합 
	// 집합2에 소속된 정점들을 집합1에 넣는다
	static void 합집합(HashSet<String> 집합1, HashSet<String> 집합2) {
		if (집합2.size() > 집합1.size()) {
			HashSet<String> temp = 집합1;
			집합1 = 집합2;
			집합2 = temp;
		}
		for (String 정점2 : 집합2)       // 집합2에 소속된 정점들 각각에 대해서
			소속집합.put(정점2, 집합1);  // 소속 집합을 집합1로 변경한다
		집합1.addAll(집합2);             // 집합2의 모든 원소들을 집합1에 넣는다
	}                                    // 집합2 객체는 garbage collection 된다.

	public static void kruskaAlgorithm() {
		for (String 정점 : 정점목록) { // 정점 1개로 구성된 집합을 생성한다.
			HashSet<String> 집합 = new HashSet<>(); // 집합 객체 생성
			집합.add(정점);                         // 집합에 정점을 1개 넣는다
			소속집합.put(정점, 집합);               // 그 정점의 소속 집합을 map에 등록한다
		}
		Arrays.sort(간선목록);                      // 가중치 오름차순 정렬
		int index = 0;
		while (최소신장트리.size() < 정점목록.length - 1) { // n-1 개의 간선이 선택될 때까지
			Edge 최소간선 = 간선목록[index++];              // 가중치 최소 간선 선택
			HashSet<String> 집합1 = 소속집합.get(최소간선.정점1); // 두 정점의 소속 집합을 구한다
			HashSet<String> 집합2 = 소속집합.get(최소간선.정점2);
			if (집합1 == 집합2) continue; // 두 정점의 소속 집합이 같다면, 이 간선을 무시한다
			최소신장트리.add(최소간선);   // 선택된 간선을 최소 신장 트리에 추가한다
			합집합(집합1, 집합2);         // 집합2를 집합1에 더한다.
		}
	}

	public static void main(String[] args) {
		kruskaAlgorithm();
		for (Edge edge : 최소신장트리)
			System.out.printf("%s %s %d\n", edge.정점1, edge.정점2, edge.가중치);
	}
}