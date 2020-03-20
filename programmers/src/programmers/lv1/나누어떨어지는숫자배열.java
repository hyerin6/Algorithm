package programmers.lv1;

import java.util.*;

public class 나누어떨어지는숫자배열 {

	public static int[] solution(int[] arr, int divisor) {

		//		List<Integer> list = new ArrayList<>();
		//		for(int i : arr) 
		//			if(i % divisor == 0) 
		//				list.add(i);
		//
		//		if(list.isEmpty()) {
		//			int[] answer = {-1};
		//			return answer;
		//		}
		//
		//		else {
		//			list.sort(null);
		//			int[] answer = new int[list.size()];
		//
		//			int size = 0;
		//			for(int i : list)
		//				answer[size++] = i;
		//			return answer;
		//		}

		int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).sorted().toArray();

		if(answer.length == 0) 
			answer = new int[]{-1};

		return answer;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {20, 10, 5, 9, 7, 10};
		int[] result = 나누어떨어지는숫자배열.solution(arr, 5);
		System.out.println(Arrays.toString(result));

		int[] arr2 = {3, 2, 6};
		int[] result2 = 나누어떨어지는숫자배열.solution(arr2, 10);
		System.out.println(Arrays.toString(result2));

	}

}
