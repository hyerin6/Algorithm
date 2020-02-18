package net.skhu.array.v1;

public class Example1a {

	static void print(int[] a) {
		for (int i : a)
			System.out.printf("%d ", i);
	}

	static void insert(int[] a, int index, int value) {
		if (index >= a.length) return;  // 재귀호출 종료 조건 구현
		insert(a, index + 1, a[index]); // 다음 단계 작업 재귀호출
		a[index] = value;               // 현재 단계 작업 구현
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = i;

		insert(a, 5, -99);

		print(a);
	}
}
