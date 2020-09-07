
public class 키패드누르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		System.out.println(Solution.solution(numbers1, "right"));

		int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		System.out.println(Solution.solution(numbers2, "left"));

		int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		System.out.println(Solution.solution(numbers3, "right"));
	}

	static class Solution {

		static int[][] hands = {
				{' ', '1', '2', '3'},
				{' ', '4', '5', '6'},
				{' ', '7', '8', '9'},
				{' ', '*', '0', '#'}
		};

		public static String solution(int[] numbers, String hand) {
			StringBuilder sb = new StringBuilder();
			int L, R, dl, dr;
			dr = dl = 0;
			L = 10;
			R = 12;
			for (int i : numbers) {
				if (i == 1 || i == 4 || i == 7) {
					sb.append("L");
					L = i;
					continue;
				} else if (i == 3 || i == 6 || i == 9) {
					sb.append("R");
					R = i;
					continue;
				}
				if (i == 0) {
					i = 11;
				}

				// 2, 5, 8인 경우 거리를 계산해본다. 
				dl = getDistance(L, i);
				dr = getDistance(R, i);
				if (dl < dr) {
					L = i;
					sb.append("L");
				} else if (dr < dl) {
					R = i;
					sb.append("R");
				} else {
					if (hand.equals("left")) {
						L = i;
						sb.append("L");
					} else {
						R = i;
						sb.append("R");
					}
				}
			}
			return sb.toString();
		}

		static int getDistance(int source, int dest) {
			int r = dest / 3;
			int c = dest % 3;
			if (c == 0) {
				c = 3;
			}
			int nr = source / 3;
			int nc = source % 3;
			if (nc == 0) {
				nr--;
				nc = 3;
			}

			return Math.abs(r - nr) + Math.abs(c - nc);
		}
	}

}


