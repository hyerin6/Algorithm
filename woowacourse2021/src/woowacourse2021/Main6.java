package woowacourse2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main6 {

	static class Score {
		private String num;
		private String score;

		public Score(String num, String score) {
			this.num = num;
			this.score = score;
		}

		public void setNum(String num) { this.num = num; }
		public void setScore(String score) { this.score = score; }
		public String getNum() { return this.num; }
		public String getScore() { return this.score; }

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Score){
				Score score = (Score)obj;
				return score.getNum().equals(this.num) 
						&& score.getScore().equals(this.score);
			}

			return false;
		}
	}


	static class CheatPartner {
		private String student1;
		private String student2;

		public CheatPartner(String student1, String student2) {
			this.student1 = student1;
			this.student2 = student2;
		}

		public String getStudent1() { return this.student1; }
		public String getStudent2() { return this.student2; }

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof CheatPartner){
				CheatPartner cheatPartner = (CheatPartner)obj;
				return cheatPartner.getStudent1().equals(this.student1) 
						&& cheatPartner.getStudent2().equals(this.student2);
			}

			return false;
		}
	}

	static class Solution {
		public static String[] solution(String[] logs) {
			String[] answer = {};

			List<String> result = new ArrayList<>();

			Map<Score, String> logMap = makeLogMap(logs);

			logMap = RemoveFiveUnderScore(logMap);

			Map<CheatPartner, Integer> count = new HashMap<>();

			Iterator<Score> it = logMap.keySet().iterator();
			Score preKey = it.next();
			String preValue = logMap.get(preKey);
			while (it.hasNext()) {
				Score curKey = it.next();
				String curValue = logMap.get(curKey);

				if(curKey.equals(preKey)) {
					CheatPartner c = new CheatPartner(preValue, curValue);

					if(count.containsKey(c)) {
						count.put(c, count.get(c)+1);
					} else {
						count.put(c, 0);
					}

					if(count.get(c) >= 5) {
						result.add(c.student1);
						result.add(c.student2);
					}
				}
			}

			System.out.println(result.toString());
			return answer;
		}

		private static Map<Score, String> makeLogMap(String[] logs) {
			Map<Score, String> logMap = new HashMap<>();

			// 0 : 수험번호, 1 : 문제번호, 2 : 받은 점수
			for(int i = 0; i < logs.length; ++i) {
				String[] log = logs[i].split(" ");
				logMap.put(new Score(log[1], log[2]), log[0]);
			}

			return logMap;
		}

		private static Map<Score, String> RemoveFiveUnderScore(Map<Score, String> logMap) {
			Map<String, Integer> count = new HashMap<>();
			for(Map.Entry<Score, String> entry : logMap.entrySet()) {
				String id = entry.getValue();
				if(count.containsKey(id)) {
					count.put(id, count.get(id)+1);
				} else {
					count.put(id, 1);
				}
			}

			Iterator<Map.Entry<Score, String>> iteratorE = logMap.entrySet().iterator();
			while (iteratorE.hasNext()) {
				Map.Entry<Score, String> entry = (Map.Entry<Score, String>) iteratorE.next();
				Score key = entry.getKey();
				String value = entry.getValue();
				if(count.containsKey(entry.getValue()) && count.get(entry.getValue()) < 5) {
					iteratorE.remove();
				}
			}
			return logMap;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", 
				"0002 3 95", "0001 7 80", "0001 8 80", 
				"0001 10 90", "0002 10 90", "0002 7 80", 
				"0002 8 80", "0002 5 100", "0003 99 90"};
		Solution.solution(logs);



	}

}
