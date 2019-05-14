package fibonacci;

import java.util.Scanner;

public class B10870 {

	static int fibonacci(int n) {
		if(n == 0) return 0;
		else if(n == 1 || n == 2) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(fibonacci(n));
	}

}
