package matrixchain;

// 중복 호출 제거 
public class Example3 {

	static class Matrix {
		int row, col;

		public Matrix(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int[][] 최소값저장; // 파라미터(최소값저장[start][end])를 key로 결과 값을 value로 저장

	// 수행시간 복잡도 O(n^2) - 이차원 행렬이기 때문에 O(n^2)이다. 
	// 즉, 최소값 저장 배열을 채우는 것 (반만 채우는 것이라도 n^2에 비례하는 것)
	static int 곱셈횟수최소값(Matrix[] a, int start, int end) throws Exception {
		if (최소값저장 == null) 최소값저장 = new int[a.length][a.length];
		if (최소값저장[start][end] != 0) return 최소값저장[start][end];
		if (start == end) return 0;
		System.out.printf("(%d, %d) ", start, end);
		int 최소값 = Integer.MAX_VALUE;
		for (int middle = start; middle < end; ++middle) {
			int 횟수 = 곱셈횟수최소값(a, start, middle);
			횟수 += 곱셈횟수최소값(a, middle + 1, end);
			횟수 += a[start].row * a[middle].col * a[end].col;
			if (횟수 < 최소값) 최소값 = 횟수;
		}
		return 최소값저장[start][end] = 최소값;
	}

	public static void main(String[] args) throws Exception {
		Matrix[] a = new Matrix[] { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50),
				new Matrix(50, 3), new Matrix(3, 8), new Matrix(8, 30) };
		System.out.println(곱셈횟수최소값(a, 0, a.length-1));
	}
}
