package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

	private static final String VALUE = "prefix";

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		Map<String, String> map = new HashMap<>();
		for(String phone : phone_book) {
			map.put(phone, VALUE);
		}

		for(String phone : phone_book) {
			for (int i = 0; i < phone.length(); ++i) {
				if(map.containsKey(phone.substring(0, i))) {
					answer = false;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] a = {"119", "97674223", "1195524421"};
		String[] b = {"123", "456", "789"};
		String[] c = {"12", "123", "1235", "567", "88"};

		System.out.println(solution(a));
		System.out.println(solution(b));
		System.out.println(solution(c));
	}
}
