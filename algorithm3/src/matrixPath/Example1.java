package matrixPath;

public class Example1 {

	static int[][] a = { 
			{ 6,  7, 12,  5 },
			{ 5,  3, 11, 18 },
			{ 7, 17,  3,  3 },
			{ 8, 10, 14,  9 } 
	};

	// a[r][c]에서 a[0][0]으로 가는 경로 중 최소값
	static int 점수(int r, int c) {
		System.out.printf("점수(%d, %d) ", r, c);
		int 이전단계점수 = 0;
		if(r == 0 && c == 0) 이전단계점수 = 0; // 윗 칸도 없고, 왼쪽 칸도 없는 경우 - 그 칸의 값
		else if(r == 0) 이전단계점수 = 점수(r, c-1); // 왼쪽 칸만 존재 - (r == 0)이면, 위로 갈 수 없다.
		else if(c == 0) 이전단계점수 = 점수(r-1, c); // 윗 칸만 존재 
		else 이전단계점수 = Math.min(점수(r, c - 1), 점수(r - 1, c)); // 둘다 존재 - 더 작은 값 찾기
		return 이전단계점수 + a[r][c]; // a[r][c] 는 현재단계점수 
	}

	// a[0][0]에서 a[r][c]으로 가는 경로 중 최소값 
	static int 점수2(int r, int c) {
		System.out.printf("점수2(%d, %d) ", r, c);
		int 다음단계점수 = 0;
		int len = a.length - 1;
		if(r == len && c == len) 다음단계점수 = 0;
		else if(r == len) 다음단계점수 = 점수2(r, c+1); // 아래 칸만 존재 
		else if(c == len) 다음단계점수 = 점수2(r+1, c); // 오른쪽 칸만 존재 
		else 다음단계점수 = Math.min(점수2(r, c+1), 점수2(r+1, c)); // 더 작은 값 찾기 
		return 다음단계점수 + a[r][c]; // a[r][c] 는 현재단계점수 
	}

	public static void main(String[] args) {
		System.out.println("\n" + 점수(3,3));
		System.out.println("\n" + 점수2(0, 0));
		System.out.println("\n" + 점수(2, 2));
	}
}
