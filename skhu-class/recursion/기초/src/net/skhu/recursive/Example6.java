package net.skhu.recursive;

public class Example6 {

	/**
	 * 배열에서 index 위치부터 끝까지 모든 항목을 화면에 출력하는 메소드 구현
	 * 
	 * @param a
	 * @param index
	 */
	static void print(int[] a, int index) {
		if (index >= a.length) return; // 종료 조건 구현 
		System.out.printf("%d ", a[index]); // 현재 단계
		print(a, index + 1); // 다음 단계의 작업을 재귀 호출 
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		print(a, 0);
	}
}
