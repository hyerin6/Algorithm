package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
'( )' -> 레이저, ')'인 경우 i-1이 '('이면
레이저이므로 cnt += stack.size()

'(' -> 쇠막대기 시작점, stack.push('(')

')' -> 쇠막대기 끝점, 끝점인 경우 남은 하나의 조각이 있으므로 1을 추가
 */
public class B10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		char[] arr = input.toCharArray();
		Stack<Character> stack = new Stack<>();

		int result = 0;

		for (int i = 0; i < arr.length; ++i) {
			if ('(' == arr[i]) {
				stack.push(arr[i]);
			} else {
				if (arr[i - 1] == '(') {
					stack.pop();
					result += stack.size();
				} else {
					stack.pop();
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
