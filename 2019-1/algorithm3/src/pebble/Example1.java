package pebble;

public class Example1 {

	static int[][] a = {
			{  6,  7, 12, -5, 5,  3, 11, 3 },
			{ -8, 10, 14,  9, 7, 13,  8, 5 },
			{ 11, 12,  7,  4, 8, -2,  9, 4 }};

	static boolean 인접가능패턴(int 패턴1, int 패턴2) {
		if (패턴1 == 패턴2) return false; // 동일한 패턴은 인접할 수 없다.
		int[][] patterns = { {1, 4}, {3, 4}, {4, 1}, {4, 3} }; // 인접할 수 없는 패턴
		for (int i = 0; i < patterns.length; ++i)
			if (패턴1 == patterns[i][0] && 패턴2 == patterns[i][1])
				return false;
		return true;
	}

	static int 열점수(int 열, int 패턴)  {
		switch (패턴) {
		case 1: return a[0][열]; // 패턴1
		case 2: return a[1][열]; // 패턴2
		case 3: return a[2][열]; // 패턴3
		case 4: return a[0][열] + a[2][열]; // 패턴4
		}
		return 0;
	}

	// 파라미터로 주어진 열에서 끝 열까지 점수 합계
	static int 점수합계(int 열, int 이전열_패턴) {
		if (열 >= a[0].length) return 0;   // 종료조건
		int 최고점수 = Integer.MIN_VALUE;
		for (int 패턴 = 1; 패턴 <= 4; ++패턴)
			if (열 == 0 || 인접가능패턴(이전열_패턴, 패턴)) { 
				int 점수 = 열점수(열, 패턴) + 점수합계(열 + 1, 패턴);
				if (점수 > 최고점수) 최고점수 = 점수;
			}
		return 최고점수;
	}

	public static void main(String[] args) throws Exception {
		System.out.printf("점수=%d\n", 점수합계(0, 0));
	}
}
