
public class Exam1 {

	static void AA(int n) {
		if (n <= 0) return;
		System.out.printf("%d ", n);
		AA(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA(5); System.out.println(); // (1) 출력?

		// 답 : 5 3 1 

	}

}
