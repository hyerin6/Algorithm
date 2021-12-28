package lesson2;

public class OddOccurrencesInArray {
	static int solution(int[] A) {
		int result = 0;
		for (int i = 0; i < A.length; ++i) {
			result ^= A[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9, 3, 9, 3, 9, 7, 9};
		System.out.println(solution(A));
	}

}
