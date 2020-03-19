package programmers.lv1;

import java.util.*;

public class 같은숫자는싫어 {

	public static int[] solution(int []arr) {
		Stack<Integer> stack = new Stack<>();

		stack.push(arr[0]);
		for(int i = 1; i < arr.length; ++i) {
			if(stack.peek()!=arr[i])
				stack.push(arr[i]);
			else 
				continue;
		}

		int[] answer = new int[stack.size()];
		for(int i = 0; i < stack.size(); ++i)
			answer[i] = stack.get(i);

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,4,4,3,3};
		System.out.println(Arrays.toString(solution(arr)));

	}

}
