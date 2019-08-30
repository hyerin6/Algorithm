package course;
import java.util.Scanner;

// 분수 찾기 
public class B1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int l = 1;
		int sum = 1;

		while (true) {
			if (sum >= n) {
				break;
			}
			l++;
			sum += l;
		}

		int child = 0;
		int parent = 0;

		// 해당 대각선 홀,짝 판별
		if (l % 2 == 0) {
			int start = sum;
			int sub = start-n;
			child = l - sub;
			parent = 1 + sub;
		}

		if (l % 2 == 1) {
			int end = sum;
			int sub = end-n;
			child = 1 + sub;
			parent = l - sub;
		}

		System.out.println(child+"/"+parent);
	}

}