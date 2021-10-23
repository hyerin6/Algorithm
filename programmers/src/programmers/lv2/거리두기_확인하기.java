package programmers.lv2;

import java.util.Arrays;

public class 거리두기_확인하기 {
	static class Solution {
		static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

		public int[] solution(String[][] places) {
			int[] answer = new int[places.length];

			return answer;
		}
	}

	public static void main(String[] args) {
		String[][] places = {
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};

		Solution solution = new Solution();
		int[] result = solution.solution(places);
		System.out.println(Arrays.toString(result));
	}
}
