package lcs;

public class ArrInt1 {

	// 문자열의 길이를 key 로 사용하자. - 길이만 알면 문자가 뭔지 알 수 있기 때문이다. 
	// 파라미터 key가 Integer이기 때문에 배열 사용 가능 
	static int LCS(String s1, String s2, Integer[][] a) {
		if (s1.length() == 0 || s2.length() == 0) return 0;
		Integer value = a[s1.length() - 1][s2.length() - 1]; // 적어도 length가 1이라는 가정
		if (value != null) return value;

		if (s1.charAt(0) == s2.charAt(0)) {
			int r = 1 + LCS(s1.substring(1), s2.substring(1), a);
			a[s1.length() - 1][s2.length() - 1] = r;
			return r;
		}
		int lcs1 = LCS(s1, s2.substring(1), a);
		int lcs2 = LCS(s1.substring(1), s2, a);
		int r = Math.max(lcs1, lcs2);
		a[s1.length() - 1][s2.length() - 1] = r;
		return r;
	}

	static int LCS(String s1, String s2) {
		return LCS(s1, s2, new Integer[s1.length()][s2.length()]);
	}

	public static void main(String[] args) {
		String s1 = "abggcdefg";
		String s2 = "bbfcfdg";
		System.out.println(LCS(s1, s2));
	}
}
