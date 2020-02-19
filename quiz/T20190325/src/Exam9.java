
public class Exam9 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);
		System.out.println();
	}

	static int partition(int[] a, int start, int end) {
		int value = a[end];
		int i = start - 1;
		for (int j = start; j < end - 1; ++j)
			// j<end 이면 정렬된다. 끝까지 비교하지 않아 정렬되지 않는 것이다.
			if (a[j] < value)
				swap(a, ++i, j);

		swap(a, i + 1, end);
		return i + 1;
	}

	static void JJ(int[] a, int start, int end) {
		if (start >= end) return;
		int middle = partition(a, start, end);
		JJ(a, start, middle-1);
		JJ(a, middle+1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] j = {2, 5, 3, 4};
		JJ(j, 0, 3); print(j); // (10) 출력?

		// 답 : 2 4 5 3
	}

}
