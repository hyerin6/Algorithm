
public class Exam7 {

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

	static void HH(int[] a) {
		for (int i = a.length - 1; i > 1; --i) 
			for (int j = 0; j < i; ++j) 
				if (a[j] > a[j + 1]) 
					swap(a, j, j + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] h = {4, 5, 3, 2};
		HH(h); print(h); // (8) 출력?

		// 답 : 3 2 4 5 
	}

}
