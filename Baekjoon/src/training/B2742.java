package loop;
import java.util.Scanner;

// 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력
// 첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.

public class B2742 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if(n <= 100000) {
			for(int i = n; i > 0; --i)
				System.out.println(i);
		}

	}

}
