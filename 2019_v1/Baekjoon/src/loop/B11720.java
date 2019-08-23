package loop;
import java.util.Scanner;

// N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하라. 
// 첫째 줄에 숫자의 개수를 입력받고, 둘째 줄에 숫자 N개를 공백없이 받아라. 
// 처음 입력받은 숫자의 개수 만큼만 합하여 출력한다.

public class B11720 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String s =scan.next();

		int result = 0;
		for(int i = 0; i < n; ++i)
			result += Integer.parseInt(s.substring(i, i+1));

		System.out.println(result);
	}

}
