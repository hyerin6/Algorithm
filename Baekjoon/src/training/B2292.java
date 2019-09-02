package training;
import java.util.Scanner;

// 벌집
public class B2292 {
	static int depth(int n) {
		int sum = 1;
		if(n == 1) return 1;
		for(int i = 1; i < 1000000000; ++i) {
			sum += i * 6;
			if (sum >= n) return i + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println(depth(n));
	}

}
