package programmers.lv2;

import java.util.*;

public class 다리를_지나는_트럭 {

	static class Solution {
		// parameter - 다리 길이, 다리가 견디는 무게, 트럭별 무게 
		public static int solution(int bridge_length, int weight, int[] truck_weights) {
			int sec = 0; // 시간(초)
			int truckWeight = 0; // 다리 위에 있는 트럭들의 무게 
			Queue<Integer> passingTruck = new LinkedList<>(); // 다리를 지나가는 중인 트럭


			for(int w : truck_weights) {
				while(true) {
					if(passingTruck.isEmpty()) { // 다리 위에 트럭이 하나도 없는 경우 
						passingTruck.add(w);
						truckWeight += w;
						sec++;
						break;
					} else if(passingTruck.size() == bridge_length) { // 큐와 다리의 길이가 같은 경우 
						// (1) 큐가 가득차 있다는, 즉 다리위에 트럭이 더이상 진입할 수 없다.   
						// (2) 가장 먼저 진입한 트럭이 다리의 끝에 도착했다. 
						truckWeight -= passingTruck.poll();
					} else { // 다리 위에 트럭이 있지만 큐가 가득차지 않은 상태 
						// 다리가 다음 트럭의 무게를 견딜 수 있는지 없는지 검사하고 각각 다르게 처리해야 한다. 
						if(truckWeight+w > weight) {
							sec++;
							passingTruck.add(0); // 큐에 0을 넣어서 이미 올라가 있는 트럭만 지나갈 수 있게 한다.  
						} else {
							passingTruck.add(w);
							truckWeight += w;
							sec++;
							break;
						}
					}
				}
			}

			// 모든 트럭들이 다리에 진입하고 지나가야 하기 때문에 다리의 길이만큼 sec에 더해준다. 
			return sec+bridge_length;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int bridge_length1 = 2;
		int weight1 = 10;
		int[] truck_weights1 = {7, 4, 5, 6};
		int result1 = Solution.solution(bridge_length1, weight1, truck_weights1);
		System.out.println("result = " + result1);

		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = {10};
		int result2 = Solution.solution(bridge_length2, weight2, truck_weights2);
		System.out.println("result2 = " + result2);

	}

}
