package fibonacci;

public class Example1 {

	// 중복 호출
	static int fibonacci(int n) {
		System.out.printf("fibonacci(%d)\n", n);
		if (n == 1 || n == 2) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		int value = fibonacci(7);
		System.out.println(value);
	}
}
