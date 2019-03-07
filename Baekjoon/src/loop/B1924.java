package loop;
import java.util.Scanner;

public class B1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();

		int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] d = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		int sum = y;
		for(int i = 0; i < x-1; ++i)
			sum += m[i];

		System.out.println(d[sum % 7]);
	}

}
