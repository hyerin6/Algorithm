package programmers.lv1;

public class 문자열_다루기_기본 {

	private static boolean solution(String s) {
		if(s.length() == 4 || s.length() == 6) {
			return s.matches("^[0-9]*$");
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("a234"));
		System.out.println(solution("1234"));
	}

}
