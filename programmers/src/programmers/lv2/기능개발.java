package programmers.lv2;

import java.util.*;

public class 기능개발 {

	static class Solution {

		public static int[] solution(int[] progresses, int[] speeds) {
			Queue<Integer> q = new LinkedList<>();

			for(int i = 0; i < progresses.length; ++i) {
				int p = progresses[i];
				int day = 0;

				while(p < 100) {
					p += speeds[i];
					day++;
				}

				q.add(day);
			}

			int pre = q.poll();
			int count = 1;
			List<Integer> result = new ArrayList<>();

			while(!q.isEmpty()) {
				int cur = q.poll();

				if(pre >= cur) {
					count++;
				} else {
					result.add(count);
					count = 1;
					pre = cur;
				}
			}
			result.add(count);

			int[] answer = new int[result.size()];
			for(int i = 0; i < result.size(); ++i) {
				answer[i] = result.get(i);
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = {93, 30, 55};
		int[] s1 = {1, 30, 5};
		System.out.println(Arrays.toString(Solution.solution(p1, s1)));

		int[] p2 = {95, 90, 99, 99, 80, 99};
		int[] s2 = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(Solution.solution(p2, s2)));

		int[] p3 = {99, 1, 99, 1};
		int[] s3 = {1, 1, 1, 1};
		System.out.println(Arrays.toString(Solution.solution(p3, s3)));
	}

}
