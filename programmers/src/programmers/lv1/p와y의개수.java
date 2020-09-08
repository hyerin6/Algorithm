package programmers.lv1;

public class p와y의개수 {

	private static boolean solution(String word) {
		int cnt = 0;

		for(String s : word.split("")) {
			if("y".equals(s.toLowerCase())) cnt++;
			else if("p".equals(s.toLowerCase())) cnt--;
		}

		return cnt == 0 ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("pPoooyY")); // true
		System.out.println(solution("Pyy")); // false
		System.out.println(solution("")); // true
	}

}
