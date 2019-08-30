package algorithm1;

public class Example1 {

	static int factorial(int n) {
		if(n <= 1) return 1;
		return n * factorial(n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 3; i <= 10; ++i)
			System.out.printf("%d %d\n", i, factorial(i));
	}

}
