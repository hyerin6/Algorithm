package programmers.lv2;

public class 단체사진_찍기_v2 {
	private static int answer = 0;
	private static String[] friends = new String[8];

	public static int solution(int n, String[] data) {
		answer = 0;
		friends = new String[] {"A", "C", "F", "J", "M", "N", "R", "T"};
		boolean[] isVisited = new boolean[8];
		dfs("", isVisited, data);
		return answer;
	}

	private static void dfs(String names, boolean[] isVisited, String[] datas) {
		if (names.length() == 7) {
			if (check(names, datas)) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 8; i++) { // 조합
			if (!isVisited[i]) {
				isVisited[i] = true;
				String name = names + friends[i];
				dfs(name, isVisited, datas);
				isVisited[i] = false;
			}
		}
	}

	private static boolean check(String names, String[] datas) {
		for (String data : datas) {
			int position1 = names.indexOf(data.charAt(0)); // 프렌즈 포지션1
			int position2 = names.indexOf(data.charAt(2)); // 프렌즈 포지션2
			char op = data.charAt(3); // 수식
			int index = data.charAt(4) - '0'; // 간격
			if (op == '=') {
				if (!(Math.abs(position1 - position2) == index + 1))
					return false; // 둘 포지션 차이를 구하기 위해선 index+1 을 해야함에 주의
			} else if (op == '>') {
				if (!(Math.abs(position1 - position2) > index + 1))
					return false;
			} else if (op == '<') {
				if (!(Math.abs(position1 - position2) < index + 1))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int result = solution(2, new String[] {"N~F=0", "R~T>2"});
		System.out.println(result);
	}

}
