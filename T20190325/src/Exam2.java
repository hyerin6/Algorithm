
public class Exam2 {

	static int BB(int n) {
		System.out.printf("%d ", n);
		if (n <= 1) return 1;
		return n + BB(n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BB(3)); // (2) 출력?

		// 답 : 3 2 1 6
	}

}
