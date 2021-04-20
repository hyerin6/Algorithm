package programmers.lv1;

public class 신규_아이디_찾기 {

	public static String solution(String new_id) {
		String answer = new_id.toLowerCase()
			.replaceAll("[^a-z0-9._-]", "")
			.replaceAll("[.]{2,}", ".")
			.replaceAll("^[.]|[.]$", "");

		answer = answer.length() == 0 ? "a" : answer;
		answer = answer.length() >= 16 ? answer.substring(0, 15).replaceAll("[.]$", "") : answer;

		String last = answer.substring(answer.length() - 1);
		while (answer.length() < 3) {
			answer += last;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm."));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
	}
}
