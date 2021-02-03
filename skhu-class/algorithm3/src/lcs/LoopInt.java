package lcs;

public class LoopInt {
	
	static int LCS(String s1, String s2) {
		int[][] a = new int[s1.length() + 1][s2.length() + 1]; // 0 값이 채워짐.
		for (int i1 = s1.length() - 1; i1 >= 0; --i1)
			for (int i2 = s2.length() - 1; i2 >= 0; --i2)
				if (s1.charAt(i1) == s2.charAt(i2))
					a[i1][i2] = 1 + a[i1 + 1][i2 + 1];
				else
					a[i1][i2] = Math.max(a[i1][i2 + 1], a[i1 + 1][i2]);
		return a[0][0];
	}

	public static void main(String[] args) {
		String s1 = "abggcdefg";
		String s2 = "bbfcfdg";
		System.out.println(LCS(s1, s2));
	}
}