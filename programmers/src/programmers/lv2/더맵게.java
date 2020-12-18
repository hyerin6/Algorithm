package programmers.lv2;

import java.util.PriorityQueue;

public class 더맵게 {

	static class Solution {
		public int solution(int[] scoville, int K) {
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			for (int i = 0; i < scoville.length; i++) {
				queue.add(scoville[i]);
			}

			int cnt = 0;
			while (!isAll(queue, K)) {
				if(queue.size()==1) {
					cnt = -1;
					break;
				}
				int one = queue.poll();
				int two = queue.poll();

				int spicy = calcu(one, two);
				queue.add(spicy);
				cnt++;
			}
			return cnt;
		}
	}

	private static int calcu(int a, int b) {
		return a + (b * 2);
	}

	private static boolean isAll(PriorityQueue sc, int k) {
		int cnt = (int)sc.peek();
		if(cnt >= k) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(new Solution().solution(scoville, K));

	}

}
