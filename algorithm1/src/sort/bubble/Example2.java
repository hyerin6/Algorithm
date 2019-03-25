package sort.bubble;

import java.util.Arrays;

public class Example2 {

	// 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// bubble sort
	static void bubbleSort(int[] a) {
		for(int i = 0; i < a.length-1; ++i) {
			boolean 완료 = true;
			for(int j = i+1; j < a.length; ++j) {
				if(a[j] < a[i]) {
					swap(a, i, j);
					완료 = false;
				}

			}
			if (완료) break;
		}
	}

	public static void main(String[] args) {
		int[] a = { 17, 14, 11, 19, 13, 15, 20, 12, 16, 18 };

		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

}
