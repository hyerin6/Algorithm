package array2;

import java.util.Arrays;

public class Example1 {

	public static void main(String[] args) {
		int[] a1 = {1, 2, 3};
		int[] a2 = {1, 2, 3};

		System.out.println(a1 == a2); // identity를 비교 
		System.out.println(a1.equals(a2)); // identity를 비교 
		System.out.println(Arrays.equals(a1, a2)); // equality를 비교 
	}
}
