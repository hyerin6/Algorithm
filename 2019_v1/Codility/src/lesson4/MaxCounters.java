package lesson4;
import java.util.Arrays;

public class MaxCounters {

	public static int[] solution(int N, int[] A) {
		int[] counter = new int[N];
		int max = 0, min = 0;

		for(int a : A) {
			int i = a - 1;
			if(i < counter.length) {
				if(counter[i] < min) 
					counter[i] = min;
				++counter[i];
				if(counter[i] > max)
					max = counter[i];
			}
			else min = max;
		}

		for(int i = 0; i < counter.length; ++i)
			if(counter[i] < min) 
				counter[i] = min;

		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		int[] result = solution(5, A); 
		System.out.println(Arrays.toString(result));

	}

}
