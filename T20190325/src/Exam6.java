
public class Exam6 {

	static int GG(int[] a, int value, int start, int end) {
		if (start > end) return -1;
		int middle = (start + end) / 2;
		System.out.printf("%d ", middle);
		if (a[middle] < value) start = middle + 1;
		else if (a[middle] > value) end = middle - 1;
		else return middle;
		return GG(a, value, start, end);
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; ++i)
			System.out.printf("%d ", a[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = {1, 2, 3, 4, 5};
		GG(g, 2, 0, 4); // (7) 출력?
		
		// 답 : 2 0 1
	}

}
