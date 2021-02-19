package programmers.lv2;

import java.util.Stack;

public class 올바른_괄호 {

	public static boolean solution(String s) {
		if (s.charAt(0) == ')') {
			return false;
		}

		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));

		for (int i = 1; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
	}
}
