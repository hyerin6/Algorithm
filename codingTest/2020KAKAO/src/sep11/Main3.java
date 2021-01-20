package sep11;

import java.util.*;

public class Main3 {


	static class Solution {
		int cnt = 0;

		public int splitScore(String str) {
			String[] split2 = str.split(" ");
			return Integer.valueOf(split2[1]);
		}

		public String[] split(String s) {
			String[] result = new String[4];
			result = s.split(" and ");
			return result;
		}

		public int match(String[][] info, int[] infoScore , String[][] query, int[] queryScore) {
			int cnt = 0;

			//			for(int i = 0; i < info.len; ++i) {
			//				boolean isMatch = true;
			//				for(int j = 0; j < 4; ++j) {
			//					System.out.println(info[i][3] + ", " + query[i][3]);
			//					
			//				}
			//				if(isMatch) cnt++;
			//			}

			return cnt;
		}


		public int[] solution(String[] info, String[] query) {
			int[] answer = new int[query.length];

			String[][] querySplit = new String[query.length][4];
			int[] queryScore = new int[query.length];
			for(int i = 0; i < query.length; ++i) {
				querySplit[i] = query[i].split(" and ");
				queryScore[i] = Integer.parseInt(querySplit[i][3].split(" ")[1]);
			}

			String[][] infoSplit = new String[info.length][5];
			int[] infoScore = new int[info.length];
			for(int i = 0; i < info.length; ++i) {
				infoSplit[i] = info[i].split(" ");
				infoScore[i] = Integer.parseInt(infoSplit[i][4]);
			}

			match(infoSplit, infoScore , querySplit, queryScore);


			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(new Solution().solution(info, query));

	}

}
