package sort.radix;

import java.util.Arrays;

public class RadixSort3 {

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// src 배열의 값들을 정렬하여, dest 배열에 저장함
	// signed : 부호를 고려하여 정렬함.
	// radix sort 할 때, 마지막 counting sort는 부호를 고려해야함.
	public static void countingSort(int[] src, int[] dest, int nth, boolean signed) {
		int N = src.length;
		int[] count = new int[256];

		for (int i = 0; i < N; ++i) {
			int value = src[i];
			int digit = value >> (nth * 8) & 0xFF;
			++count[digit];
		}

		int[] index = new int[256];
		if (signed == false) {
			index[0] = 0;
			for (int i = 1; i < index.length; ++i)
				index[i] = index[i - 1] + count[i - 1];
		} else {
			// 음수 먼저
			index[128] = 0;
			for (int i = 129; i < index.length; ++i)
				index[i] = index[i - 1] + count[i - 1];
			// 그 다음 양수
			for (int i = 0; i < 128; ++i) {
				int prev = i == 0 ? 255 : i - 1;
				index[i] = index[prev] + count[prev];
			}
		}

		for (int i = 0; i < N; ++i) {
			int value = src[i];
			int digit = value >> (nth * 8) & 0xFF;
			dest[index[digit]++] = value;
		}
	}

	public static void radixSort(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < 4; ++i)
			if (i % 2 == 0)
				countingSort(a, b, i, i == 3);
			else
				countingSort(b, a, i, i == 3);
	}

	public static void main(String[] args) {
		int[] a = { -1, 6, 2, -5, 1, 0, -2, 5, 3, -7, -3, 4, 7, -6, -4 };
		radixSort(a);
		System.out.println(Arrays.toString(a));
	}
}
