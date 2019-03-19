package algoQuiz.sort;

import java.util.Arrays;
import java.util.Random;

public class Example3 {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// 3) 홀수 짝수 분리
	// 입력 : 정수 배열 int[]
	// 출력 : 짝수들이 배열의 앞부분에, 홀수들은 배열의 뒷부분에 위치해야 함.
	private static void moveEvenNumbersToFron(int[] a) {
		int start = 0;
		int end = a.length-1;
		do{
			while(a[start] % 2 == 0 && start < end)
				start++;
			while(a[end] % 2 == 1 && start < end)
				end--;
			swap(a, start, end);
		} while(start < end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int[] a = new int[20];
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(20);

		moveEvenNumbersToFron(a);
		System.out.println(Arrays.toString(a));

	}

}
