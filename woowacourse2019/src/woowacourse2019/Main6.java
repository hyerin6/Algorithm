package woowacourse2019;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Main6 {

	static class State {
		String time;
		String state;

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



			//				Date d1 = f.parse(preLogSplit[2]);
			//				Date d2 = f.parse(logSplit[2]);
			//				long diff = d2.getTime() - d1.getTime();
			//
			//				if(diff/1000 >= 60 && logSplit[1].equals("request")) {
			//					sb.append(preLogSplit[0] + " ");



			answer = sb.toString().split(" ");
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
