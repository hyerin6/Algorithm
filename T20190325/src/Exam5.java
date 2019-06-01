
public class Exam5 {

	static void FF(int[][] a, int r, int c) {
		System.out.println();
		System.out.printf("%d %d", r, c);
		if (r >= a.length) return;
		if (c >= a[r].length) return;
		System.out.println();
		System.out.printf("%d ", a[r][c]);
		FF(a, r, c + 1);
		FF(a, r + 1, c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] f = {{1, 2}, {3, 4}};
		FF(f, 0, 0); System.out.println(); // (6) 출력?

		// 선택 가능한 n개, 선택 순서 중요하지 않고 제한이 없는 것
		// 답 : 1 2 4 3 4 
		// 수행시간 : o(2^n)

	}

}
