package net.skhu.array.v1;

public class Example2a {

	static void print(int[] a) {
		for (int i : a)
			System.out.printf("%d ", i);
	}

	static void remove(int[] a, int index) {
		if (index == a.length - 1) {
			a[index] = 0;
			return;
		}
		a[index] = a[index + 1];
		remove(a, index + 1);
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = i;

		remove(a, 5);
		print(a);
	}
}
