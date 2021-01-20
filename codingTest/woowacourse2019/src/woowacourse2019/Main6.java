package woowacourse2019;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

public class Main6 {

	static class State {
		private String time;
		private String state;

		public State(String time, String state) {
			this.time = time;
			this.state = state;
		}

		public String getTime() { return this.time; }
		public String getState() { return this.state; }
		public void setTime(String time) { this.time = time; }
		public void setState(String state) { this.state = state; }
	}

	static class Solution {
		public static String[] solution(int totalTicket, String[] logs) throws ParseException {
			String[] answer = new String[0];

			StringBuilder sb = new StringBuilder();
			SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");

			Queue<String> logBucket = new LinkedList<>();
			for(String s : logs) logBucket.add(s);

			Map<String, State> map = new HashMap<>();

			// 0: user, 1: state, 2: time  
			String[] preLog = logBucket.poll().split(" ");

			String[] curLog = logBucket.poll().split(" ");
			Date pre = f.parse(preLog[2]);
			Date cur = f.parse(curLog[2]);
			long diff = ((cur.getTime()-pre.getTime())/1000);

			return answer;
		}
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		String[] logs = {
				"woni request 09:12:29", 
				"brown request 09:23:11",
				"brown leave 09:23:44",
				"jason request 09:33:51",
				"jun request 09:33:56",
				"cu request 09:34:02"
		};

		String[] answer = Solution.solution(2000, logs);
		System.out.println(Arrays.toString(answer));

	}

}
