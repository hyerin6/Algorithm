import java.util.*;
import java.util.Map.Entry;

class FollowTest {
	private List<ArrayList<Integer>> followList;

	// 파라미터로 넘어 온 정점 수 만큼 그래프 생성 
	public FollowTest(int initSize) {
		this.followList = new ArrayList<ArrayList<Integer>>(); 

		for(int i = 0; i < initSize+1; i++) {
			followList.add(new ArrayList<Integer>());
		}
	}

	// 그래프 return
	public List<ArrayList<Integer>> getGraph() {
		return this.followList;
	}

	// 그래프의 특정 노드 return
	public List<Integer> getNode(int i) {
		return this.followList.get(i);
	}

	// 그래프 추가 (단방향)
	public void put(int x, int y) {
		if(hasEdge(x, y))
			this.followList.get(x).add(y);
	}

	// 그래프 출력 (인접리스트)
	public void printGraphToAdjList() {
		for(int i = 1; i < followList.size(); i++) {
			System.out.println(i + "의 팔로우 목록 : " + this.followList.get(i));
		}
	}

	// 정점이 존재하는지 검사 
	// v1 : 팔로우 하려는 사람
	// v2 : 팔로우 하고 싶은 사람
	public boolean hasEdge(int v1, int v2) {
		if(!followList.get(v1).contains(v2))
			return true;
		return false;
	}

	public List<Integer> recommendation(int v) {
		List<Integer> recommendation = new ArrayList<>();
		Stack<Integer> qu = new Stack<>(); 
		Map<Integer, Integer> map = new HashMap<>();

		qu.addAll(this.followList.get(v)); // 추천 받고 싶은 사람의 친구 목록 넣기 

		while(!qu.isEmpty()) { // 1의 친구들의 친구 살펴보기 
			int value = qu.pop(); // 친구 하나 꺼내기 
			List<Integer> f = this.followList.get(value); // 그 친구 목록가져오기

			// 그 친구 목록 Map에 count하기
			for(int j = 0; j < f.size(); ++j) {
				int friend = f.get(j);

				// 자기 자신과 이미 팔로우 중인 친구는 추천 받지 않음 
				if(friend == v || this.followList.get(v).contains(friend))
					continue;
				if(map.get(friend) == null) {
					map.put(friend, 1);					
				} 
				else {
					map.put(friend, map.get(friend)+1);
				}
			}
		}

		for(Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= 2)
				recommendation.add(entry.getKey());
		}

		return recommendation;
	}

}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int initSize = 6;
		FollowTest adjList = new FollowTest(initSize);

		adjList.put(1, 2);
		adjList.put(1, 5);
		adjList.put(1, 6);
		adjList.put(2, 3);
		adjList.put(2, 4);
		adjList.put(2, 5);
		adjList.put(2, 6);
		adjList.put(3, 2);
		adjList.put(3, 4);
		adjList.put(3, 5);
		adjList.put(4, 5);
		adjList.put(4, 6);
		adjList.put(4, 6); 
		adjList.put(5, 1);
		adjList.put(5, 2);
		adjList.put(5, 3);
		adjList.put(5, 4);
		adjList.put(5, 6);

		adjList.printGraphToAdjList();
		System.out.println("\n==========================================\n");

		System.out.println("1의 친구 추천 결과 : " + adjList.recommendation(1).toString());
		System.out.println("2의 친구 추천 결과 : " + adjList.recommendation(2).toString());
		System.out.println("3의 친구 추천 결과 : " + adjList.recommendation(3).toString());
	}
}
