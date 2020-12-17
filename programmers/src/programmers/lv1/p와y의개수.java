package programmers.lv1;

public class p와y의개수 {

	private static boolean solution(String word) {
		int cnt = 0;
		word = word.toUpperCase();

		for(String s : word.split("")) {
			if("Y".equals(s)) cnt++;
			else if("P".equals(s)) cnt--;
		}

		return cnt == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("pPoooyY")); // true
		System.out.println(solution("Pyy")); // false
		System.out.println(solution("")); // true
	}

}
