
public class Exam8 {

	static void print(int[] a) {
		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);
		System.out.println();
	}

	static void II(int[] a) {
		for (int i = 1; i < a.length; ++i) {
			int value = a[i];
			int j;
			for (j = i - 1; j > 0; --j) {
				// j >= 0 이면 정렬된다.
				// 0번째까지 비교하지 않아 0번째 값과 마지막 값이 정렬되지 않았다.
				if (a[j] > value)
					a[j + 1] = a[j];
				else break;
			}
			a[j + 1] = value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {4, 5, 3, 2};
		II(i); print(i); // (9) 출력?

		// 답 : 4 2 3 5
	}

}
