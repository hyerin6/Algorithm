package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 순위검색 {

	static Map<String, List<Integer>> map = new HashMap<>();

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (int i = 0; i < info.length; i++) {
			dfs(0, "", info[i].split(" "));
		}

		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			List<Integer> list = map.get(key);
			Collections.sort(list);
		}
		
		for (int i = 0; i < query.length; i++) {
			String[] keyValue = query[i].replaceAll(" and ", "").split(" ");
			String key = keyValue[0];
			String value = keyValue[1];

			if (!map.containsKey(key)) {
				answer[i] = 0;
				continue;
			}

			answer[i] = binarySearch(map.get(key), Integer.parseInt(value));
		}

		return answer;
	}

	public static void dfs(int depth, String key, String[] info) {
		if (depth == 4) {
			if (map.containsKey(key)) {
				map.get(key).add(Integer.parseInt(info[4]));
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(Integer.parseInt(info[4]));
				map.put(key, list);
			}
			return;
		}

		dfs(depth + 1, key + "-", info); // "-"도 저장해준다.
		dfs(depth + 1, key + info[depth], info);
	}

	public static int binarySearch(List<Integer> list, int target) {
		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return list.size() - start;
	}

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
			"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
			"python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
			"cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
			"- and - and - and - 150"};
		int[] answer = solution(info, query);
		System.out.println(Arrays.toString(answer));
	}
}
