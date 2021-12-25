package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {

	static char[] prior = {'+', '-', '*'};
	static boolean[] visit = new boolean[3];
	static List<Long> nums = new ArrayList<>();
	static List<Character> ops = new ArrayList<>();
	static long answer;

	public static Long calc(Long num1, Long num2, char op) {
		long num = 0;
		switch (op) {
			case '+': {
				return num1 + num2;
			}
			case '-': {
				return num1 - num2;
			}
			case '*': {
				return num1 * num2;
			}
		}
		return num;
	}

	public long solution(String expression) {
		answer = 0;
		String num = "";

		// 숫자는 num에 연산자는 ops에 저장한다.
		for (int i = 0; i < expression.length(); ++i) {
			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				num += expression.charAt(i);
			} else {
				nums.add(Long.parseLong(num));
				num = "";
				ops.add(expression.charAt(i));
			}
		}
		nums.add(Long.parseLong(num));

		dfs(0, new char[3]);
		return answer;
	}

	public static void dfs(int count, char[] choice) {
		if (count == 3) { // 우선순위가 정해지면 연산을 시작한다.
			ArrayList<Long> cNums = new ArrayList<>(nums);
			ArrayList<Character> cOps = new ArrayList<>(ops);

			for (int i = 0; i < choice.length; ++i) {
				for (int j = 0; j < cOps.size(); ++j) {
					if (choice[i] == cOps.get(j)) {
						// 숫자 2개와 연산자 1개를 calc()에 전달, 계산한다.
						Long res = calc(cNums.remove(j), cNums.remove(j), choice[i]);
						cNums.add(j, res); // 결과를 다시 숫자 리스트에 저장하고
						cOps.remove(j); // 사용한 연산자는 삭제한다.
						j--; // 전체적으로 숫자 하나와 연산자 하나를 사용했으므로 j--를 해준다.
					}
				}
			}
			answer = Math.max(answer, Math.abs(cNums.get(0)));
			return;
		}

		// perm
		for (int i = 0; i < 3; ++i) {
			if (!visit[i]) {
				visit[i] = true;
				choice[count] = prior[i];
				dfs(count + 1, choice);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		수식최대화 s = new 수식최대화();
		s.solution("100-200*300-500+20");
		System.out.println(answer);
	}
}
