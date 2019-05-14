package pebble;

// 반복문으로 구현 
public class Example4 {
	static int[][] a = {
			{  6,  7, 12, -5, 5,  3, 11, 3 },
			{ -8, 10, 14,  9, 7, 13,  8, 5 },
			{ 11, 12,  7,  4, 8, -2,  9, 4 }};

	static int[][] 점수목록 = new int[8][5];

	static boolean 인접가능패턴(int 패턴1, int 패턴2) {
		if (패턴1 == 패턴2) return false; // 동일한 패턴은 인접할 수 없다.
		int[][] patterns = { {1, 4}, {3, 4}, {4, 1}, {4, 3} }; // 인접할 수 없는 패턴
		for (int i = 0; i < patterns.length; ++i)
			if (패턴1 == patterns[i][0] && 패턴2 == patterns[i][1])
				return false;
		return true;
	}

	static int 열점수(int c, int p) throws Exception {
		switch (p) {
		case 1: return a[0][c]; // 패턴1
		case 2: return a[1][c]; // 패턴2
		case 3: return a[2][c]; // 패턴3
		case 4: return a[0][c] + a[2][c]; // 패턴4
		}
		throw new Exception("invalid p:" + p);
	}

	static void 점수계산() throws Exception {
		for (int 열 = 0; 열 < a[0].length; ++열) {
			for (int 패턴 = 1; 패턴 <= 4; ++패턴) {
				if (열 == 0)
					점수목록[열][패턴] = 열점수(열, 패턴);
				else {
					int 최고점수 = Integer.MIN_VALUE;
					for (int 이전열_패턴 = 1; 이전열_패턴 <= 4; ++이전열_패턴)
						if (인접가능패턴(패턴, 이전열_패턴)) {
							int 점수 = 점수목록[열 - 1][이전열_패턴] + 열점수(열, 패턴);
							if (점수 > 최고점수) 최고점수 = 점수;
						}
					점수목록[열][패턴] = 최고점수;
				}
			}
		}
	}

	static int 마지막열_최고점수() {
		int 마지막열 = a[0].length-1, 최고점수 = Integer.MIN_VALUE;
		for (int 패턴 = 1; 패턴 <= 4; ++패턴)
			if (점수목록[마지막열][패턴] > 최고점수)
				최고점수 = 점수목록[마지막열][패턴];
		return 최고점수;
	}

	public static void main(String[] args) throws Exception {
		점수계산();
		int 점수 = 마지막열_최고점수();
		System.out.printf("점수=%d\n", 점수);
	}
}
