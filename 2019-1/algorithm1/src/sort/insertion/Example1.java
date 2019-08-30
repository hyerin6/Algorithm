package sort.insertion;
import java.util.Arrays;

// 요약만 보고 구현해보기 ! 
public class Example1 {

	static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; ++i) {
			int value = a[i];             // 삽입할 값 보관
			int j;
			for (j = i - 1; j >= 0; --j) {  // 뒤로 이동
				if (a[j] > value)
					a[j + 1] = a[j];
				else break;
			}
			a[j + 1] = value;             // 값 삽입
		}
	}

	public static void main(String[] args) {
		int[] a = { 17, 14, 11, 19, 13, 15 };

		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
}
