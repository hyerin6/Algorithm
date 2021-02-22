package programmers.lv2;

import java.util.Stack;

public class 짝지어_제거하기 {

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		
		return stack.isEmpty() ? 1 : 0;
	}

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}
}
