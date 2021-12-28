package lesson2;

import java.util.Arrays;

public class CyclicRotation {

	static int[] solution(int[] A, int K) {
		// 배열 A의 길이가 0이면 반복문 실행하지 않음
		while (K > 0 && A.length != 0) {
			int index = A.length - 1;
			int temp = A[A.length - 1];

			for (int i = A.length - 2; i >= 0; --i) {
				A[index] = A[i];
				--index;
			}
			A[0] = temp;
			K--;
		}
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 8, 9, 7, 6};
		solution(A, 3);
		// [9, 7, 6, 3, 8]
		System.out.println(Arrays.toString(A));

		int[] B = {0, 0, 0};
		solution(B, 1);
		// [0, 0, 0]
		System.out.println(Arrays.toString(B));

		int[] C = {1, 2, 3, 4};
		solution(C, 4);
		// [1, 2, 3, 4]
		System.out.println(Arrays.toString(C));

	}

}
