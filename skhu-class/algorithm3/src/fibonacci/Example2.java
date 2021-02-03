package fibonacci;

// 동적 프로그래밍(1) - 재귀호출 구현 
public class Example2 {

	static int[] a = new int[100]; // 전부 0으로 초기화

	static int fibonacci(int n) {
		System.out.printf("fibonacci(%d)\n", n);
		if (a[n] != 0) return a[n]; // 이전에 호출한 기록이 있다면 저장해둔 값을 리턴
		if (n == 1 || n == 2) a[n] = 1;
		else a[n] = fibonacci(n - 1) + fibonacci(n - 2); // 호출한 적이 없으면 호출 
		return a[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = fibonacci(7);
		System.out.println(value);
	}

}
