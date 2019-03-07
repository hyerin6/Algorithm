package loop;
import java.util.Scanner;

// 첫째 줄에는 별 1개 ... 오른쪽을 기준으로 정렬하여 출력

public class B2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if(1 <= n || n <= 100) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(j < n-i-1) System.out.print(" ");
					else System.out.print("*");
				}System.out.println();
			}
		}
	}
}
