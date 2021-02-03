package silver4;

import java.util.Arrays;
import java.util.Scanner;

public class B1920 {
	private static int search(int[] A, int start, int end, int input) {
		int mid = (start + end) / 2;
		if (mid >= end)
			return 0;
		if (A[mid] == input)
			return 1;

		if (A[mid] < input)
			return search(A, mid + 1, end, input);
		else
			return search(A, start, mid, input);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		int[] A = new int[input];
		for (int i = 0; i < input; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);

		int input2 = sc.nextInt();
		int[] M = new int[input2];
		for (int i = 0; i < input2; i++) {
			M[i] = sc.nextInt();
		}

		for (int i = 0; i < M.length; ++i) {
			System.out.println(search(A, 0, A.length, M[i]));
		}
	}

}
