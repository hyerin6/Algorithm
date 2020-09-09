import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class 실패율 {

	static class Solution {

		class Stage implements Comparable<Stage> {
			public int id;
			public double failure;

			public Stage(int id_, double failure_) {
				id = id_;
				failure = failure_;
			}

			@Override
			public int compareTo(Stage o) {
				if (failure < o.failure ) {
					return -1;
				}
				if (failure > o.failure ) {
					return 1;
				}
				return 0;
			}
		}

		public int[] solution(int N, int[] lastStages) {
			int nPlayers = lastStages.length;
			int[] nStagePlayers = new int[N + 2];
			for (int stage : lastStages) {
				nStagePlayers[stage] += 1;
			}

			int remainingPlayers = nPlayers;
			List<Stage> stages = new ArrayList<>();
			for (int id = 1 ; id <= N; id++) {
				double failure = (double) nStagePlayers[id] / remainingPlayers;
				remainingPlayers -= nStagePlayers[id];

				Stage s = new Stage(id, failure);
				stages.add(s);
			}
			Collections.sort(stages, Collections.reverseOrder());

			int[] answer = new int[N];
			for (int i = 0; i < N; i++) {
				answer[i] = stages.get(i).id;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] arr1 = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(Arrays.toString(s.solution(5, arr1)));
		
	}

}
