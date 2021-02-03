package lcs;

// subString 을 사용하면 계속 문자열이 새로 만들어지기 때문에 
// 문자열을 자르지 않고 start를 후진 시키기 
public class IndexInt1 {

	static int LCS(String s1, int start1, String s2, int start2, Integer[][] a) {
		if (start1 >= s1.length() || start2 >= s2.length()) return 0;
		Integer value = a[start1][start2];
		if (value != null) return value;
		if (s1.charAt(start1) == s2.charAt(start2)) {
			int r = 1 + LCS(s1, start1 + 1, s2, start2 + 1, a);
			a[start1][start2] = r;
			return r;
		}
		int lcs1 = LCS(s1, start1, s2, start2 + 1, a);
		int lcs2 = LCS(s1, start1 + 1, s2, start2, a);
		int r = Math.max(lcs1, lcs2);
		a[start1][start2] = r;
		return r;
	}

	static int LCS(String s1, String s2) {
		return LCS(s1, 0, s2, 0, new Integer[s1.length()][s2.length()]);
	}

	public static void main(String[] args) {
		String s1 = "abggcdefg";
		String s2 = "bbfcfdg";
		System.out.println(LCS(s1, s2));
	}
}
