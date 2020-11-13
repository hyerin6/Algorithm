package programmers.lv2;

import java.util.Arrays;

public class 삼각달팽이 {

	public static int[] solution(int n) {
		int[] answer = new int[(n*(n+1))/2];
		int[][] matrix = new int[n][n];

		int x = -1, y = 0;
		int num = 1;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) { // 반복되는 숫자는 1씩 감소하기 때문에 j는 i부터 시작한다. 
				if (i % 3 == 0) {
					x++;
				} else if (i % 3 == 1) {
					y++;
				} else if (i % 3 == 2) {
					x--;
					y--;
				}
				matrix[x][y] = num++;
			}
		}

		int k = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) 
					break;
				answer[k++] = matrix[i][j];
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] result = solution(4);
		System.out.println(Arrays.toString(result));
	}

}
