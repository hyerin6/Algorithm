package sort.selection;
import java.util.Arrays;
/*
 * 선택 정렬 구현 - 최대값을 찾아 정렬하기 
 * for (int i = a.length-1; i >= 1; --i) {
    배열 a의 0부터 i까지 최대값을 찾는다.
    최대값과 i위치의 값을 서로 바꾼다.
    }
 */

public class Example6 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int findMax(int[] a, int end) {
		int max = 0;
		for(int i = 1; i <= end; ++i) // a의 0부터 i까지 최대값을 찾는다.
			if(a[i] > a[max])
				max = i;
		return max;
	}

	static void selectionSort(int[] a) {
		for (int i = a.length-1; i >= 1; --i) {
			int max = findMax(a, i);
			swap(a, i, max);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 17, 14, 11, 19, 13, 15, 18, 12, 16, 20 };

		int i = findMax(a, a.length-1);
		System.out.println("배열에서의 최대값: " + a[i]);

		selectionSort(a);
		System.out.println(Arrays.toString(a));

	}

}
