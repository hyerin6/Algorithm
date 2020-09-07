public class 괄호변환 {
	private static boolean rightBracket(String p) {
		int cnt = 0;
		for(int i = 0; i < p.length(); ++i) {
			if(cnt < 0) return false;
			if(p.charAt(i) == '(') cnt++;
			if(p.charAt(i) == ')') cnt--;
		}
		return true;
	}

	private static String balancedBracket(String w) {
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i = 0; i < w.length(); ++i) {
			char c = w.charAt(i);
			if(c == '(') cnt ++;
			if(c == ')') cnt --;
			sb.append(c);
			if(i >= 1 && cnt == 0) return sb.toString();
		}
		return sb.toString();
	}

	private static String convertBracket(String p) {
		if ("".equals(p)) return "";

		String u = balancedBracket(p);
		String v = p.substring(u.length());

		StringBuilder sb = new StringBuilder();
		if(rightBracket(u)) {
			sb.append(u);
			sb.append(convertBracket(v));
			return sb.toString();
		}

		sb.append("("); // 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
		sb.append(convertBracket(v)); // 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
		sb.append(")"); // ')'를 다시 붙입니다. 
		sb.append(removeAndReverse(u)); // u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
		return sb.toString(); // 생성된 문자열을 반환합니다.
	}

	private static String removeAndReverse(String u) {
		StringBuilder sb = new StringBuilder();
		String center = u.substring(1, u.length()-1);
		for(int i = 0; i < center.length(); ++i) {
			if(center.charAt(i) == '(') sb.append(')');
			if(center.charAt(i) == ')') sb.append('(');
		}
		return sb.toString();
	}

	public static String solution(String p) {
		if(rightBracket(p)) return p;
		return convertBracket(p);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("(()())()")); // "(()())()"
		System.out.println(solution("")); // ""
		System.out.println(solution(")(")); // "()"
		System.out.println(solution("()))((()")); // "()(())()"
	}
}
