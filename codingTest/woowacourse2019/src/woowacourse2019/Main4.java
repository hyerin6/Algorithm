package woowacourse2019;

public class Main4 {

	static class Solution {
		public static int solution(int[] pobi, int[] crong) {

			boolean valid = validation(pobi, crong); 
			if(!valid) return -1;

			int pobi_left_max = max(sum(pobi[0]), mul(pobi[0]));
			int pobi_right_max = max(sum(pobi[1]), mul(pobi[1])); 

			int crong_left_max = max(sum(crong[0]), mul(crong[0])); 
			int crong_right_max = max(sum(crong[1]), mul(crong[1]));

			int pobi_max = max(pobi_left_max, pobi_right_max); 
			int crong_max = max(crong_left_max, crong_right_max);

			if(pobi_max == crong_max) return 0;

			return pobi_max > crong_max ? 1 : 2;
		}

		// 왼쪽과 오른쪽 페이지 번호가 1 차이가 나야한다.   
		private static boolean validation(int[] pobi, int[] crong) {
			if(Math.abs(pobi[0] - pobi[1]) != 1 || 
					Math.abs(crong[0] - crong[1]) != 1) {
				return false;
			}

			return true;
		}

		private static int sum(int value) {
			int sum = 0;
			char[] values = String.valueOf(value).toCharArray();

			for(char c : values) {
				sum += c-'0';
			}

			return sum;
		}

		private static int mul(int value) {
			char[] values = String.valueOf(value).toCharArray();
			int mul = values[0]-'0';

			for(int i = 1; i < values.length; ++i) {
				mul = mul * (values[i]-'0');
			}

			return mul;
		}

		private static int max(int value1, int value2) {
			return value1 > value2 ? value1 : value2;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pobi1 = {97, 98};
		int[] crong1 = {197, 198};
		System.out.println(Solution.solution(pobi1, crong1)); // 0

		int[] pobi2 = {131, 132};
		int[] crong2 = {211, 212};
		System.out.println(Solution.solution(pobi2, crong2)); // 1

		int[] pobi3 = {99, 102};
		int[] crong3 = {211, 212};
		System.out.println(Solution.solution(pobi3, crong3)); // -1

	}

}
