package matrixPath;

// 동적 프로그래밍 기법 적용
// Example2.java 와 점수 메소드 호출 횟수는 같다.
public class Example2a {

	static int[][] a = { 
			{ 6,  7, 12,  5 },
			{ 5,  3, 11, 18 },
			{ 7, 17,  3,  3 },
			{ 8, 10, 14,  9 } 
	};

	static final int ROW_COUNT = 4, COL_COUNT = 4;

	static int 점수(int row, int col) {
		System.out.printf("점수(%d, %d) \n", row, col);
		if (row == ROW_COUNT-1 && col == COL_COUNT-1) return a[ROW_COUNT-1][COL_COUNT-1];
		int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
		if (row < ROW_COUNT-1) r1 = 점수(row + 1, col);
		if (col < COL_COUNT-1) r2 = 점수(row, col + 1);
		return Math.min(r1, r2) + a[row][col];
	}

	public static void main(String[] args) {
		System.out.println(점수(0, 0));
	}
}
