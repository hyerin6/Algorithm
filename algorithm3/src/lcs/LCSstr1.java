package lcs;

public class LCSstr1 {

	static String LCS(String s1, String s2) { 
		if (s1.length() == 0 || s2.length() == 0) 
			return ""; 
		if (s1.charAt(0) == s2.charAt(0)) 
			return s1.charAt(0) + LCS(s1.substring(1), s2.substring(1)); 
		String lcs1 = LCS(s1, s2.substring(1));
		String lcs2 = LCS(s1.substring(1), s2); 
		return lcs1.length() > lcs2.length() ? lcs1 : lcs2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcd"; 
		String s2 = "adbc"; 
		System.out.println(LCS(s1, s2));
	}

}
