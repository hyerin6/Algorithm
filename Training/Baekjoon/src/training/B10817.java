package training;
import java.util.Scanner; 

// if - else if 만 사용해보자. 
// 세 정수 A, B, C가 주어진다. 두번째로 큰 정수를 출력하는 프로그램을 작성하시오.
public class B10817 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		if(a < b) {
			if(b < c) System.out.println(b);
			else if(a < c) System.out.println(c);
			else System.out.println(a);

		}else {
			if(b > c) System.out.println(b);
			else if(a > c) System.out.println(c);
			else System.out.println(a);

		}
	}

}
