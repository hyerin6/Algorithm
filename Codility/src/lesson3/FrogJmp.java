package lesson3;

public class FrogJmp {

	public static int solution(int X, int Y, int D) {
		return (int)Math.ceil((Y - X) / (double)D);
	}

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}

}
