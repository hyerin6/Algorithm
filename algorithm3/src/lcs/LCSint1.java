package lcs;

public class LCSint1 {

	// 최선의 경우 - 문자열이 동일한 경우 / 최악의 경우 - 두 문자열에 공통 문자가 전혀 없는 경우 
	// 최선의 경우 수행 시간은 O(N) / 최악의 경우 수행 시간은 O(2^N)
	static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) return 0;
		if(s1.charAt(0) == s2.charAt(0)) 
			return 1 + LCS(s1.substring(1), s2.substring(1));
		int lcs1 = LCS(s1, s2.substring(1));
		int lcs2 = LCS(s1.substring(1), s2);
		return Math.max(lcs1, lcs2);
	}

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "adbc"; 
		System.out.println(LCS(s1, s2));
	} 
}