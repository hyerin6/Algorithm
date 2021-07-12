package programmers.lv1;

public class 숫자_문자열과_영단어 {

	static String[] numberString = {"zero", "one", "two", "three",
		"four", "five", "six", "seven", "eight", "nine"};

	public static int solution(String s) {
		for (int i = 0; i < numberString.length; ++i) {
			s = s.replaceAll(numberString[i], String.valueOf(i));
		}

		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		int result1 = solution("one4seveneight");
		System.out.println(result1);

		int result2 = solution("23four5six7");
		System.out.println(result2);

		int result3 = solution("2three45sixseven");
		System.out.println(result3);

		int result4 = solution("123");
		System.out.println(result4);
	}

}
