package level4;
import java.util.Scanner;
/*
 * 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 
 * 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
 */
public class B9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();

		if(num >= 0 && num <= 100) {
			if(num >= 90) System.out.println("A");
			else if(num >= 80) System.out.println("B");
			else if(num >= 70) System.out.println("C");
			else if(num >= 60) System.out.println("D");
			else System.out.println("F");
		}

	}

}
