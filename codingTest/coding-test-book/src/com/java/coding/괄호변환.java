package com.java.coding;

public class 괄호변환 {

	private static boolean check(String p) {
		int open = 0;
		if (p.charAt(0) == ')') {
			return false;
		}
		for (int i = 0; i < p.length(); ++i) {
			if (p.charAt(i) == '(') {
				open++;
			} else {
				open--;
				// 카운팅 과정에서 open이 음수가 되면 '('의 개수보다 ')'의 개수가 많아지는 순간이므로
				// 올바른 괄호 문자열이 아니다.
				if (open < 0) {
					return false;
				}
			}
		}
		return open == 0;
	}

	private static String reverse(String str) {
		StringBuilder s = new StringBuilder();
		// 첫 번째, 마지막 문자를 제외하고 반복
		for (int i = 1; i < str.length() - 1; ++i) {
			if (str.charAt(i) == '(') { // ( -> )
				s.append(")");
			} else { // ) -> (
				s.append("(");
			}
		}
		return s.toString();
	}

	/*
	u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 한다.
	v는 빈 문자열이 될 수 있다.
	 */
	private static String split(String s) {
		if (s.length() == 0) {
			return s;
		}

		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();

		int open = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				open++;
			} else {
				open--;
			}
			if (open == 0) { // 처음 open이 0이 된 경우가 가장 작은 단위의 "균형잡힌 괄호 문자열"
				u.append(s.substring(0, i + 1));
				v.append(s.substring(i + 1));
				if (check(u.toString())) { // u가 올바른 문자열인 경우 
					// v에 대해 재귀호출 후, u에 이어 붙인다. 이 과정 후 break에 걸려 u를 반환하므로 변환 과정에 성립
					u.append(split(v.toString()));
				} else { // u가 올바른 문자열이 아닌 경우 
					StringBuilder str = new StringBuilder();
					str.append("(");
					str.append(split(v.toString()));
					str.append(")");
					str.append(reverse(u.toString()));
					return str.toString();
				}
				break;
			}
		}
		// u가 올바른 문자인 경우에만 반환
		return u.toString();
	}

	public static String solution(String p) {
		String answer = p;

		if (check(p)) {
			return answer;
		}

		answer = split(p);
		return answer;
	}

	public static void main(String[] args) {
		String answer = solution("(()))(");
		System.out.println(answer);
	}

}
