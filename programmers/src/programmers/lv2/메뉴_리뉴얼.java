package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴_리뉴얼 {

	private static List<String> combination;

	public static String[] solution(String[] orders, int[] course) {
		String[] answer;
		combination = new ArrayList<>();

		for (int i = 0; i < orders.length; ++i) { // 한 주문당 모든 조합 구하기
			char[] orders_char = orders[i].toCharArray();
			Arrays.sort(orders_char); // orders[i] 오름차순 정렬
			// comb(...) 에서 index+1 부터 문자열을 더하기 때문에 범위를 (orders_char.length - 1)로 한다.
			for (int index = 0; index < orders_char.length - 1; ++index) {  // 차례대로 한글자씩 선택 후
				for (int j = 0; j < course.length; ++j) {   // course 에 있는 모든 경우
					comb(orders_char, index, course[j], String.valueOf(orders_char[index]));
				}
			}
		}

		Map<String, Integer> map = new HashMap<>();
		for (String key : combination) {
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		List<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

		List<String> ansList = new ArrayList<>();
		for (int i = 0; i < course.length; ++i) {
			int max_value = 0;
			for (String key : keySetList) {
				if (map.get(key) >= 2 && key.length() == course[i]) {
					if (map.get(key) >= max_value) {
						ansList.add(key);
						max_value = map.get(key);
					}
				}
			}
		}

		Collections.sort(ansList);
		answer = new String[ansList.size()];
		ansList.toArray(answer);
		return answer;
	}

	public static void comb(char[] arr, int idx, int course, String str) {
		if (str.length() == course) {
			combination.add(str);
		}

		for (int i = idx + 1; i < arr.length; ++i) {
			comb(arr, i, course, str + arr[i]);
		}
	}

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};
		String[] answer = solution(orders, course);
		System.out.println(Arrays.toString(answer));
	}
}
