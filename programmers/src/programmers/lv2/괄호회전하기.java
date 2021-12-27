package programmers.lv2;

import java.util.Stack;

public class 괄호회전하기 {

	public static boolean check(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			switch (ch) {
				case '{':
				case '[':
				case '(':
					stack.push(ch);
					break;
				case '}':
					if (stack.isEmpty() || stack.peek() != '{') {
						return false;
					}
					stack.pop();
					break;
				case ']':
					if (stack.isEmpty() || stack.peek() != '[') {
						return false;
					}
					stack.pop();
					break;
				case ')':
					if (stack.empty() || stack.peek() != '(') {
						return false;
					}
					stack.pop();
					break;
			}
		}
		return stack.isEmpty();
	}

	public static int solution(String s) {
		int answer = 0;
		StringBuilder sb;

		for (int i = 0; i < s.length(); ++i) {
			sb = new StringBuilder();
			sb.append(s.substring(i));
			sb.append(s.substring(0, i));
			if (check(sb.toString())) {
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int answer = solution("[](){}");
		System.out.println(answer);
	}

}
