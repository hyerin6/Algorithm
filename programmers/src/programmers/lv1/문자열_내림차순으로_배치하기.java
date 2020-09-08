package programmers.lv1;

import java.util.Arrays;

public class 문자열_내림차순으로_배치하기 {

	private static String solution(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars); 
		return new StringBuilder(new String(chars)).reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("Zbcdefg"));
	}

}
