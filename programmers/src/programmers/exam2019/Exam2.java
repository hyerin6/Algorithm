package programmers.exam2019;

import java.util.Stack;

// 경로 push, pop은 이진트리 응용 강의자료 확인해보면 쉽게 이해할 수 있다. 
public class Exam2 {
	static void print(Stack<Character> 경로) {
		for (char c : 경로)
			System.out.print(c);
		System.out.println();
	}

	static void 탐색(int 여는괄호수, int 닫는괄호수, Stack<Character> 경로) {
		if (여는괄호수 == 0 && 닫는괄호수 == 0) {
			print(경로);
			return;
		}
		if (여는괄호수 > 0) {
			경로.push('(');
			탐색(여는괄호수 - 1, 닫는괄호수, 경로);
			경로.pop();
		}
		// 여는괄호가 먼저 출력되야 하므로 조건을 잘 추가해야 한다. 
		if (닫는괄호수 > 0 && 여는괄호수 < 닫는괄호수) {
			경로.push(')');
			탐색(여는괄호수, 닫는괄호수 - 1, 경로);
			경로.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		탐색(3, 3, new Stack<>());
	}

}
