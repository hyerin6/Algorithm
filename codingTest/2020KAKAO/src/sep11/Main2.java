package sep11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {

	static class Solution {
		Map<String, Integer> orderCnt = new HashMap<>();
		Map<String, Integer> courseCnt = new HashMap<>();

		public String[] sort(String[] orders) {
			List<String> orderList = Arrays.asList(orders);
			Comparator<String> c = new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return Integer.compare(s1.length(), s2.length());
				}
			};
			Collections.sort(orderList, c);

			for(String order : orderList) {
				char[] chArr = order.toCharArray();
				Arrays.sort(chArr);
				order = String.valueOf(chArr);
			}

			String[] result = new String[orderList.size()];
			int cnt = 0;
			for(String s : orderList) {
				result[cnt] = s;
				cnt++;
			}
			return result;
		}

		public void orderCnt(String[] orders) {
			for(int i = 0; i < orders.length; ++i) {
				orderCnt.put(orders[i], 1);
			}


			for(int i = 0; i < orders.length; ++i) {
				for(Map.Entry<String, Integer> e : orderCnt.entrySet()) {
					int cnt = orders[i].length();
					for(String s : orders[i].split("")) {
						if(e.getKey().contains(s)) cnt--;
					}
					if(cnt == 0) {
						if(courseCnt.containsKey(orders[i])) {
							courseCnt.put(orders[i], courseCnt.get(orders[i]) + 1);
						} else {
							courseCnt.put(orders[i], 1);
						}
					}
				}
			}
		}

		public List<String> lenCheck(int[] course) {
			List<String> answer = new ArrayList<>();

			for(int i = 0; i < course.length; ++i) {
				for(Map.Entry<String, Integer> e : courseCnt.entrySet()) {
					if(e.getValue() > 1 && e.getKey().length() == course[i]) {
						answer.add(e.getKey());
					}
				}
			}
			return answer;
		}

		public String[] makeCourse(int[] course) {
			List<String> answer = lenCheck(course);
			String[] result = new String[answer.size()];
			for(String s : answer) result[answer.indexOf(s)] = s;
			Arrays.sort(result);
			return result;
		}

		public String[] solution(String[] orders, int[] course) {
			String[] answer = {};
			orders = sort(orders);
			orderCnt(orders);
			answer = makeCourse(course);
			return answer;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course1 = {2, 3, 4};
		System.out.println(Arrays.toString(new Solution().solution(orders1, course1)));

		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course2 = {2,3,5};
		System.out.println(Arrays.toString(new Solution().solution(orders2, course2)));

		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course3 = {2,3,4};
		System.out.println(Arrays.toString(new Solution().solution(orders3, course3)));

	}

}
