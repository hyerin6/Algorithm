// 2. 구현
package course6.september;

public class Algorithm2 {

	public static int solution(String str) {
		int result = 0;
		Algorithm2 obj = new Algorithm2();
		for (String s : str.split(" "))
			System.out.println(obj.compress(s));

		return result;
	}

	// 같은 문자가 반복되면 횟수 표시하여 문자열 압축
	String compress(String s) {
		String t = "";
		for (String u : s.split("(?<=(.))(?!\\1)"))
			t = t + u.charAt(0) + u.length();
		return t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("aabbaccc");
		// 일단 a2b2a1c3로 출력은 가능ㅠ

	}

}
