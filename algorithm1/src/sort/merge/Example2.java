package sort.merge;
import java.util.Arrays;

// 아래 소스 코드의 실행 결과를 예상해보자.
public class Example2 {

	// a 배열에서 앞부분(start ~ middle)과 뒷부분(middle+1 ~ end)을 병합한다.
	static void merge(int[] a, int start, int middle, int end) {
		int length = end - start + 1;   // 병합할 부분의 길이를 구한다.
		int[] temp = new int[length];   // 병합 결과를 저정할 임시 배열을 생성한다.
		int i = 0;                      // 임시 배열에 대한 인덱스 변수
		int index1 = start;             // 앞부분(start ~ middle)에 대한 인덱스 변수
		int index2 = middle + 1;        // 뒷부분(middle+1 ~ end)에 대한 인덱스 변수

		while (index1 <= middle && index2 <= end) { // 병합할 값이 앞부분과 뒷부분에 둘 다 남아 있다면
			if (a[index1] < a[index2])              // 앞부분과 뒷부분의 선두의 값을 비교하여
				temp[i++] = a[index1++];            // 더 작은 값이 임시 배열에 먼저 들어간다
			else
				temp[i++] = a[index2++];
		}
		while (index1 <= middle)            // 앞부분 배열에 남아있는 값을 임시 배열에 넣는다.
			temp[i++] = a[index1++];
		while (index2 <= end)               // 뒤부분 배열에 남아있는 값을 임시 배열에 넣는다.
			temp[i++] = a[index2++];
		for (i = 0; i < temp.length; ++i)   // 임시 배열의 내용을 a 배열의 start 위치에 복사한다.
			a[start + i] = temp[i];
	}

	public static void main(String[] args) {
		int[] a1 = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		merge(a1, 5, (5 + 9)/ 2, 9);
		System.out.println(Arrays.toString(a1));

		int[] a2 = { 10, 11, 12, 13, 14, 17, 18, 19, 15, 16};
		merge(a2, 5, (5 + 9)/ 2, 9);
		System.out.println(Arrays.toString(a2));

		int[] a3 = { 10, 12, 14, 11, 13, 15, 16, 17, 18, 19};
		merge(a3, 0, (0 + 4)/ 2, 4);
		System.out.println(Arrays.toString(a3));

		/* 출력 결과 
		 * [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
		 * [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
		 * [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
		 */
	}
}
