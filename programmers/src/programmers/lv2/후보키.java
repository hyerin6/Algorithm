package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키 {
	static int col;
	static int row;
	static int[] comb;
	static String[][] relationStr;
	static int answer;
	static List<String> uniqueKeys = new ArrayList<>();

	private static boolean isAlreadyMinKey() {
		if (uniqueKeys.isEmpty()) {
			return false;
		}

		List<Integer> keyDfsList = new ArrayList<>();
		for (int num : comb) {
			keyDfsList.add(num);
		}

		for (String ukl : uniqueKeys) {
			List<Integer> uniqueKey = new ArrayList<>();
			String[] array = ukl.split("");
			for (String str : array) {
				int num = Integer.parseInt(str);
				uniqueKey.add(num);
			}
			if (keyDfsList.containsAll(uniqueKey)) {
				return true;
			}
		}

		return false;
	}

	private static void check() {
		Set<String> keyString = new HashSet<>();
		StringBuilder sb;

		for (String[] arr : relationStr) {
			sb = new StringBuilder();
			for (int num : comb) {
				sb.append(arr[num]);
			}
			keyString.add(sb.toString());
		}

		if (keyString.size() == row) {
			answer += 1;
			sb = new StringBuilder();
			for (int num : comb) {
				sb.append(num);
			}
			uniqueKeys.add(sb.toString());
		}
	}

	private static void comb(boolean[] visit, int start, int end) {
		if (end == 0) {
			int index = 0;
			for (int i = 0; i < visit.length; ++i) {
				if (visit[i]) {
					comb[index] = i;
					index++;
				}
			}
			if (!isAlreadyMinKey()) {
				check();
			}
		} else {
			for (int i = start; i < visit.length; ++i) {
				visit[i] = true;
				comb(visit, i + 1, end - 1);
				visit[i] = false;
			}
		}
	}

	public static int solution(String[][] relation) {
		answer = 0;
		col = relation[0].length; // 칼럼 수
		row = relation.length; // 레코드 수
		relationStr = relation;
		for (int i = 0; i < col; ++i) {
			boolean[] visit = new boolean[col];
			comb = new int[i + 1];
			comb(visit, 0, i + 1);
		}

		return answer;
	}

	public static void main(String[] args) {
		String[][] input = {
			{"100", "ryan", "music", "2"}
			, {"200", "apeach", "math", "2"},
			{"300", "tube", "computer", "3"},
			{"400", "con", "computer", "4"},
			{"500", "muzi", "music", "3"},
			{"600", "apeach", "music", "2"}};

		int answer = solution(input);
		System.out.println(answer);
	}
}
