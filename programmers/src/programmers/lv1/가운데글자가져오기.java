package programmers.lv1;

public class 가운데글자가져오기 {

	public static String solution(String s) {
		String answer = "";
		int len = s.length();
		int num = len/2;

		if(len % 2 != 0) 
			answer = s.substring(num, num+1);
		else 
			answer = s.substring(num-1, num+1);

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));

	}

}
