
public class Exam10 {

	static int KK(int n) {
		if (n <= 1) return 1;
		return KK(n - 1) + KK(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(KK(5)); // (11) 출력?

		// 답 : 8
	}

}
