package training;
import java.util.Scanner;

/*
 *  알파펫으로만 이루어진 길이가 n인 단어를 입력받는다.
 *  한 줄에 10글자씩 출력하는 프로그램을 작성하라.
 */

public class B11721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String input = scan.next();

		for (int i = 1; i <= input.length(); ++i) {
			System.out.print(input.charAt(i-1));
			if (i % 10 == 0) {
				System.out.println();
			}
		}
	}
}