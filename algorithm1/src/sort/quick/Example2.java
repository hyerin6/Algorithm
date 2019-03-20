package sort.quick;

import java.util.Arrays;
import java.util.Random;

public class Example2 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition(int[] a, int start, int end) {
		int i = start - 1;
		int value = a[end];

		for(int j = start; j < end; ++j) {
			if(a[j] < value) 
				swap(a, ++i, j);
		}
		swap(a, i + 1, end);
		return i + 1;
	}

	static void quickSort(int[] a, int start, int end) {
		if(start >= end) return;
		int middle = partition(a, start, end); // 배열 나누기
		quickSort(a, start, middle-1);         // 1구역 정렬
		quickSort(a, middle+1, end);           // 2구역 정렬
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(20);

		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

}
