package matrixPath;

public class Example1 {

	static int[][] a = { 
			{ 6,  7, 12,  5 },
			{ 5,  3, 11, 18 },
			{ 7, 17,  3,  3 },
			{ 8, 10, 14,  9 } 
	};

	static int 점수(int r, int c) {
		int 이전단계점수 = 0;
		if(r == 0 && c == 0) 이전단계점수 = 0; // 윗 칸도 없고, 왼쪽 칸도 없는 경우: 그 칸의 값
		else if(r == 0) 이전단계점수 = 점수(r, c-1); // 왼쪽 칸만 존재 / r == 0 이면, 더이상 위로 갈 수 없다.
		else if(c == 0) 이전단계점수 = 점수(r-1, c); // 윗 칸만 존재 
		else 이전단계점수 = Math.min(점수(r, c - 1), 점수(r - 1, c)); // 둘다 존재 - 더 작은 값 찾기
		return 이전단계점수 + a[r][c];
	}

	public static void main(String[] args) {
		System.out.println(점수(3,3));
	}
}
