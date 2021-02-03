package training;
import java.util.Scanner;

public class B10250 {

	static void ACM(int h, int w, int n) {
		int 열 = (n-1) / h + 1; 
		int 행 = n % h; 
		if (행 == 0) 행 = h;
		System.out.printf("%d%02d\n", 행, 열);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int loop = scan.nextInt();

		for(int i = 0; i < loop; ++i) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			int n = scan.nextInt();
			ACM(h, w, n);
		}

	}

}
