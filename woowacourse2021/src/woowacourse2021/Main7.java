package woowacourse2021;

public class Main7 {

	static class Solution {
		public static int[][] solution(int n, boolean horizontal) {
			int[][] answer = new int[n][n];

			if(horizontal) {
				answer = rightStart(n);
			} else {
				answer = downStart(n);
			}

			return answer;
		}

		private static int[][] downStart(int n) {
			int[][] answer = new int[n][n];

			int count = 1;
			int value = 0;

			// 배열의 현재 위치 
			int currentX = 0;
			int currentY = 0;

			answer[currentX][currentY] = value++;
			count++;

			while(count <= n*n) {

				// x가 n보다 작은 동안은 x 증가, 이후에는 y 증가 
				if(currentX + 1 < n) {
					currentX++;
				} else {
					currentY++;
				}

				answer[currentX][currentY] = value++;
				count++;

				// 우상향으로 이동 
				while(currentX - 1 > -1 && currentY + 1 < n) {  
					value += 1;
					answer[--currentX][++currentY] = value++;
					count++;
				}

				// y가 n 보다 작은 동안은 y 증가, 이후에는 x증가  
				if(currentY + 1 < n) {
					currentY++;
				} else {
					currentX++;
				}

				answer[currentX][currentY] = value++;
				count++;

				// 좌하향으로 이동 
				while(currentY - 1 > -1 && currentX + 1 < n) {
					value += 1;
					answer[++currentX][--currentY] = value++;
					count++;
				}
			}

			// 결과 출력 
			for(int[] xx : answer) {
				for(int nn : xx) {
					System.out.printf("%d ", nn);
				}

				System.out.println();
			}

			return answer;
		}

		private static int[][] rightStart(int n) {
			int[][] answer = new int[n][n];

			int count = 1;
			int value = 0;

			int currentX = 0;
			int currentY = 0;

			answer[currentX][currentY] = value++;
			count++;

			while(count <= n*n) {
				if(currentY + 1 < n) {
					currentY++;
				} else {
					currentX++;
				}

				answer[currentX][currentY] = value++;
				count++;

				while(currentY - 1 > -1 && currentX + 1 < n) {
					value += 1;
					answer[++currentX][--currentY] = value++;
					count++;
				}

				if(currentX + 1 < n) {
					currentX++;
				} else {
					currentY++;
				}

				answer[currentX][currentY] = value++;
				count++;

				while(currentX - 1 > -1 && currentY + 1 < n) {  
					value += 1;
					answer[--currentX][++currentY] = value++;
					count++;
				}

			}

			return answer;
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution.solution(5, false);
		Solution.solution(4, true);
	}

}
