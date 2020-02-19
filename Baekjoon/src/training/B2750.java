package training;

import java.util.Scanner;

public class B2750 {

	static int[] solution(int[] a) {
		for(int i = 0; i < a.length; ++i) {
			for(int j = i+1; j < a.length; ++j) {
				if(a[i] > a[j]) swap(a, i, j);
			}
		}

		return a;
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		//System.out.print("N을 입력하세요. ");
		int num = scan.nextInt();

		int[] a = new int[num];
		//System.out.println(num + "개의 숫자를 입력하세요.");
		for(int i = 0; i < num; ++i) {
			a[i] = scan.nextInt();
		}

		solution(a);
		for(int i : a) {
			System.out.println(i);
		}
	}

}
