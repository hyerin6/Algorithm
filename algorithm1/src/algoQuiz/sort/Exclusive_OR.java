package algoQuiz.sort;
import java.util.Arrays;
/*
int a[] 배열에 정수가 여러 개 들어있다.
한 개의 값을 제외한 나머지 값들은 짝수 번 들어있고,
한 개의 값만 홀수 번 들어있다.
홀수 번 들어 있는 값을 찾아라.
 */
public class Exclusive_OR {

	static int solution(int[] a) {
		int result = 0;
		Arrays.sort(a);

		for(int i = 0; i < a.length; ++i) 
			result ^= a[i];

		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 1, 5, 75, 75, 53, 53, 1, 5, 75, 75, 2, 2};

		System.out.println("홀수 번 들어있는 정수 : " + solution(a));
	}

}
