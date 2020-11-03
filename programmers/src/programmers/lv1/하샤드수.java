package programmers.lv1;

public class 하샤드수 {

	static class Solution {
		public static boolean solution1(int x) {
			int sum = 0;
			char[] charArr = String.valueOf(x).toCharArray();

			for(char c : charArr) {
				sum += (int) c - 48; 
			}

			return x % sum == 0 ? true : false;     
		}

		public static boolean solution2(int x) {
			int mod = x;
			int calc = 0;

			do {
				calc += mod%10;
				mod = mod/10;
			} while(mod%10 > 0);

			return x%calc == 0 ? true : false; 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Solution.solution1(10));
		System.out.println(Solution.solution1(12));
		System.out.println(Solution.solution1(11));
		System.out.println(Solution.solution1(13));
		System.out.println();
		System.out.println(Solution.solution2(10));
		System.out.println(Solution.solution2(12));
		System.out.println(Solution.solution2(11));
		System.out.println(Solution.solution2(13));
	}

}
