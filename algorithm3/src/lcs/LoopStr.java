package lcs;

public class LoopStr {
	
	static String LCS(String s1, String s2) {
		String[][] a = new String[s1.length() + 1][s2.length() + 1];
		for (int i1 = s1.length(); i1 >= 0; --i1)
			for (int i2 = s2.length(); i2 >= 0; --i2)
				// String 배열은 null이 채워지기 때문에 아래의 코드가 필요하다. 
				if (i1 == s1.length() || i2 == s2.length())
					a[i1][i2] = "";
				else if (s1.charAt(i1) == s2.charAt(i2))
					a[i1][i2] = s1.charAt(i1) + a[i1+1][i2+1];
				else
					a[i1][i2] = a[i1][i2+1].length() > a[i1+1][i2].length() ?
							a[i1][i2+1] : a[i1+1][i2];
							return a[0][0];
	}

	public static void main(String[] args) {
		String s1 = "abggcdefg";
		String s2 = "bbfcfdg";
		System.out.println(LCS(s1, s2));
	}
}