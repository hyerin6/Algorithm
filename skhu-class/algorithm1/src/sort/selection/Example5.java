package sort.selection;
import java.util.Arrays;

// findMin 메소드 없이 구현해보기 
public class Example5 {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void selectionSort(int[] a) {
		for(int i = 0; i < a.length-1; ++i) {
			int min = i; // 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록한다. 
			for(int j = i+1; j < a.length; ++j) 
				if(a[j] < a[min])
					min = j;

			swap(a, i, min); // 아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소의 자리를 바꾼다.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 14, 11, 13, 15 };
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

}
