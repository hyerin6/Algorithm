package programmers.lv2;

public class 가장_큰_정사각형_찾기 {

	public static int solution(int[][] board) {
		int answer = findMaxSquare(board.length, board[0].length, board);
		return answer;
	}

	private static int findMaxSquare(int N, int M, int[][] board) {
		int max = 0;

		if (N < 2 || M < 2) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (board[i][j] == 1) {
						max = 1;
					}
				}
			}
		} else {
			for (int i = 1; i < N; ++i) {
				for (int j = 1; j < M; ++j) {
					if (board[i][j] == 1) {
						board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
						if (board[i][j] > max) {
							max = board[i][j];
						}
					}
				}
			}
		}

		return max * max;
	}

	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
		int[][] arr2 = {{1, 0}, {0, 0}};

		int result = solution(arr);
		int result2 = solution(arr2);

		System.out.println(result);
		System.out.println(result2);
	}
}