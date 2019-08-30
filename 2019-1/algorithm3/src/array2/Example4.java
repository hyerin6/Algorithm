package array2;

import java.util.Arrays;

public class Example4 {

	public static void main(String[] args) {
		int[][] a1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] a2 = {{1, 2, 3}, {4, 5, 6}};

		System.out.println(a1 == a2);
		System.out.println(a1.equals(a2));
		System.out.println(Arrays.equals(a1, a2));
		// 다차원 배열의 equality 비교는 Arrays.deepEquals 메소드를 사용해야 한다.
		System.out.println(Arrays.deepEquals(a1, a2));
	}
}
