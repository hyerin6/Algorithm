package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 오픈채팅방 {
	private static final String ENTRANCE = "Enter";
	private static final String EXIT = "Leave";
	private static final String CHANGE = "Change";
	private static final String POST_ENTRANCE = "님이 들어왔습니다.";
	private static final String POST_EXIT = "님이 나갔습니다.";

	public static String[] solution(String[] record) {
		List<String> chatLog = new ArrayList<>();
		HashMap<String, String> nick = new HashMap<>();

		for (String log : record) {
			StringTokenizer st = new StringTokenizer(log);
			String command = st.nextToken();
			String userId = st.nextToken();
			String nickname = "";

			if (EXIT.equals(command)) {
				chatLog.add(userId + POST_EXIT);
			}
			if (ENTRANCE.equals(command)) {
				nickname = st.nextToken();
				nick.put(userId, nickname);
				chatLog.add(userId + POST_ENTRANCE);
			}
			if (CHANGE.equals(command)) {
				nickname = st.nextToken();
				nick.put(userId, nickname);
			}
		}

		String[] answer = new String[chatLog.size()];
		int logIdx = 0;

		for (String str : chatLog) {
			int endOfId = str.indexOf("님");
			String userId = str.substring(0, endOfId);
			answer[logIdx++] = str.replace(userId, nick.get(userId));
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] record = {
			"Enter uid1234 Muzi",
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo",
			"Change uid4567 Ryan"
		};

		String[] result = solution(record);
		System.out.println(Arrays.toString(result));
	}
}
