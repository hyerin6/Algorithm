package algorithm1;

public class Example6 {

	static void print(int[] a, int index) {
		if (index >= a.length) return; // 종료 조건 
		System.out.printf("%d ", a[index]);
		print(a, index + 1); // 재귀 호출 
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		print(a, 0);
	}
}
