package programmers.lv2;

public class JadenCase_문자열_만들기 {

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String[] sp = s.toLowerCase().split("");
		boolean flag = true;

		for (String str : sp) {
			sb.append(flag ? str.toUpperCase() : str);
			flag = " ".equals(str) ? true : false;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("for         the last week"));

	}
}
