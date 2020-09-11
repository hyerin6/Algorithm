package programmers.lv2;

import java.util.*;

public class 프린터 {

	static class Solution {

		// location: 인쇄하고자하는 index 
		private int solution(int[] priorities, int location) {
			int answer = 1;

			Queue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
			for(int task : priorities) priority.add(task);

			System.out.println(priority.toString());

			while(!priority.isEmpty()){
				for(int i = 0; i < priorities.length; ++i){
					if(priorities[i] == priority.peek()) {
						if(i == location) return answer;
						priority.poll();
						answer++;
					}
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] p1 = {2, 1, 3, 2};
		int[] p2 = {1, 1, 9, 1, 1, 1};
		System.out.println(s.solution(p1, 2));
		System.out.println(s.solution(p2, 0));
	}

}

