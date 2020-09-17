package sort.counting;

import java.util.Arrays; 

public class CountingSort5 { 

	// a 배열에는 0..maxValue 사이의 값만 들어있어야 한다. 
	public static void countingSort(int[] a, int maxValue) { 
		int[] count = new int[maxValue+1]; 

		// maxValue+1 개의 count가 필요함. 
		for (int i = 0; i < a.length; ++i) 
			++count[a[i]]; 

		// a[i] 값 count 증가 
		// 위에서 계산한 count를 사용하여 값들을 a 배열에 저장함. 즉 정렬함. 
		int index = 0; 

		for (int i = 0; i < count.length; ++i) 
			for (int j = 0; j < count[i]; ++j) 
				a[index++] = i; 
	} 

	public static void main(String[] args) {
		int[] a = new int[] {6, 3, 12, 7, 10, 4, 11, 2, 9, 0, 5, 13, 1, 8 }; 
		countingSort(a, 16); 
		System.out.println(Arrays.toString(a)); 
	} 

}
