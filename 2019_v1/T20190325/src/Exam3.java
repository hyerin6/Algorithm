
public class Exam3 {
	
	static int CC(int n) {
		if (n < 1) return 1;
		System.out.printf("%d ", n);
		return n + CC(n - 1);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CC(3)); // (3) 출력?
		
		// 답 : 3 2 1 7 
	}

}
