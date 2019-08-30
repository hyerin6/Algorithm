package net.skhu.array;

import java.util.Random;

public class Example3 {
	// print 메소드의 시간 복잡도 : Θ(n)
	static void print(int[] a) {
		for (int i : a)
			System.out.printf("%d ", i);
	}

	// swap 메소드의 시간 복잡도 : Θ(1)
	static void swap(int[] a, int i, int j) {
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}

	// sort 메소드의 시간 복잡도 : Θ(n^2)
	static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; ++i)
			for (int j = i + 1; j < a.length; ++j)
				if (a[i] > a[j])
					swap(a, i, j);
	}

	// main 메소드의 시간 복잡도 : Θ(n^2)
	public static void main(String[] args) {
		Random random = new Random();
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(20);

		sort(a);
		print(a);

	}

}
