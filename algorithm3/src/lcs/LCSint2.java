package lcs;

public class LCSint2 {
	
	// 이 예제는 공통된 문자가 하나도 없기 때문에 문자열의 길이에 비해 재귀호출이 많다. 
	static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) return 0;
		System.out.printf("%s %s\n", s1, s2);

		if (s1.charAt(0) == s2.charAt(0))
			return 1 + LCS(s1.substring(1), s2.substring(1));
		int lcs1 = LCS(s1, s2.substring(1));
		int lcs2 = LCS(s1.substring(1), s2);
		return Math.max(lcs1, lcs2);
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "123";
		System.out.println(LCS(s1, s2));
	}
}
