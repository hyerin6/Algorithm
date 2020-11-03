package programmers.lv1;

public class 핸드폰_번호_가리기 {

	static class Solution {
		public static String solution1(String phone_number) {
			char[] ch = phone_number.toCharArray();
			for(int i = 0; i < ch.length - 4; i ++){
				ch[i] = '*';
			}
			return String.valueOf(ch);
		}

		// 정규식 
		public static String solution2(String phone_number) {
			return phone_number.replaceAll(".(?=.{4})", "*");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.solution1("01033334444"));
		System.out.println(Solution.solution1("027778888"));
		System.out.println();
		System.out.println(Solution.solution2("01033334444"));
		System.out.println(Solution.solution2("027778888"));
	}

}
