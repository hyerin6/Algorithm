package programmers.lv2;

import java.math.BigInteger;

public class 멀쩡한_사각형 {

	static class Solution {
		public long solution(int w, int h) {
			int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
			return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(8, 12));
		System.out.println(new Solution().solution(3, 4));

	}

}
