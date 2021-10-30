package programmers.practice;

public class 숫자1이될때까지 {
	public static void main(String[] args) {
		int n = 25;
		int k = 5;
		int cnt = 0;

		while (n != 1) {
			if (n % k == 0) {
				n /= k;
			} else {
				n -= 1;
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}
