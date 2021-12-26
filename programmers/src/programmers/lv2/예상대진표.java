package programmers.lv2;

public class 예상대진표 {
	static class Solution {
		public int solution(int n, int a, int b) {
			int answer = 0;
			while (a != b) {
				answer++;
				a = (a + 1) / 2;
				b = (b + 1) / 2;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int answer = s.solution(8, 4, 7);
		System.out.println(answer);
	}
}
