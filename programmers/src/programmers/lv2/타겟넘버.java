package programmers.lv2;

public class 타겟넘버 {

	static class Solution {
		int answer = 0;

		public void dfs(int[] numbers, int index, int target, int sum) {
			if(index >= numbers.length) {
				if(sum == target) answer++;
				return;
			}

			dfs(numbers, index+1, target, sum+numbers[index]);
			dfs(numbers, index+1, target, sum-numbers[index]);
		}

		public int solution(int[] numbers, int target) {
			dfs(numbers, 0, target, 0);
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] numbers = {1, 1, 1, 1, 1};
		System.out.println(s.solution(numbers, 3));

	}

}
