package net.skhu.recursive;

public class Example2 {

	/**
	 * 1부터 n까지 합계를 계산하는 sum 함수를 구현
	 * 
	 * @param n
	 * @return
	 */
	static int sum(int n) {
		if(n <= 1) return 1;
		return n + sum(n - 1);

	}

	public static void main(String[] args) {
		for (int i = 3; i <= 10; ++i)
			System.out.printf("%d %d\n", i, sum(i));
	}

}
