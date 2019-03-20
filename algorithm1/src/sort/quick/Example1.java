package sort.quick;

import java.util.Arrays;
import java.util.Random;

public class Example1 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition(int[] a, int start, int end) {
		int value = a[end]; // 기준값 (배열의 맨 끝 값)
		int i = start - 1;
		for(int j = 0; 	j < end; ++j) {

			/* 코드 설명
			 * i 위치는 1구역의 끝이다.
			 * 따라서 i+1 위치는 2구역의 시작이고, a[i+1] 값은 2구역 값이다.
			 * if (a[j] <= value) 이면, a[j] 값은 1구역으로 이동해야 한다.
			 * a[i+1], a[j] 두 원소의 값을 서로 교환하면,
			 * a[i+1] 값은 1구역 값이고
			 * a[j] 값은 2구역 값이된다.
			 * a[i+1] 값도 1구역에 포함되어야 하므로, ++i 해야 한다.
			 */

			if(a[j] < value) // a[j]값이 1구역에 속하면 swap 
				swap(a, ++i, j);
		}
		swap(a, i + 1, end); // 기준값 a[end] 원소와 2구역의 시작 원소 교환
		return i+1; // 기준값의 위치 리턴
	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(20);

		System.out.println(Arrays.toString(a));
		int middle = partition(a, 0, a.length - 1);
		System.out.print(Arrays.toString(Arrays.copyOfRange(a, 0, middle)) + " ");
		System.out.println(Arrays.toString(Arrays.copyOfRange(a, middle, a.length)));
	}

}
