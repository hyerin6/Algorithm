package programmers.lv1;

public class 행렬의_덧샘 {

	static class Solution {
		public static int[][] solution(int[][] arr1, int[][] arr2) {
			int[][] answer = new int[arr1.length][arr1[0].length];

			for(int i = 0; i < arr1.length; ++i) {
				for(int j = 0; j < arr1[i].length; ++j) {
					answer[i][j] = arr1[i][j] + arr2[i][j];
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = {{1, 2}, {2, 3}};
		int[][] arr2 = {{3, 4}, {5, 6}};

		int[][] answer = Solution.solution(arr1, arr2);

		for(int i = 0; i < answer.length; ++i) {
			for(int j = 0; j < answer[i].length; ++j) {
				System.out.println(answer[i][j]);
			}
		}

	}

}
