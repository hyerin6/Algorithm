package net.skhu.array;

public class Example1 {

	static void print(int[] a) {
		for(int i : a)
			System.out.printf("%d ", i);
	}

	static void insert(int[] a, int index, int value) {
		/* 반복문으로 구현 
		for(int i = index-1; i > index; --i) 
			a[i] = a[i-1];

		a[index] = value;
		*/

		// 재귀호출 
		if(index >= a.length) return; // 재귀호출 종료 조건 구현
		insert(a, index+1, a[index]);
		a[index] = value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10]; 

		for (int i = 0; i < a.length; ++i) 
			a[i] = i;

		insert(a, 5, -99); 
		print(a);
	}

}
