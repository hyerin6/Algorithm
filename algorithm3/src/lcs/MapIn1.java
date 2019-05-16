package lcs;
import java.util.HashMap;
import java.util.Map;

/* Map 객체 활용 동적 프로그래밍 
 * 동적 프로그래밍 기법을 적용하여 중복 호출을 제거한 LCS 메소드의 수행 시간은,
 * 두 문자열의 길이를 각각 N, M 이라고 할 때, O(NM) 이다. 
 * */

public class MapIn1 {

	// 파라미터가 String이기 때문에 Map을 사용하자. 
	static int LCS(String s1, String s2, Map<String,Integer> map) {
		if (s1.length() == 0 || s2.length() == 0) return 0;
		Integer value = map.get(s1 + s2);
		if (value != null) return value;
		System.out.printf("%s %s\n", s1, s2);

		if (s1.charAt(0) == s2.charAt(0)) {
			int r = 1 + LCS(s1.substring(1), s2.substring(1), map);
			map.put(s1 + s2, r);
			return r;
		}
		int lcs1 = LCS(s1, s2.substring(1), map);
		int lcs2 = LCS(s1.substring(1), s2, map);
		int r = Math.max(lcs1, lcs2);
		map.put(s1 + s2, r);
		return r;
	}

	static int LCS(String s1, String s2) {
		return LCS(s1, s2, new HashMap<String,Integer>());
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "123";
		System.out.println(LCS(s1, s2));
	}
}
