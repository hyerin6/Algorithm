package woowacourse2021;

import java.util.Arrays;

public class Main5 {

	static class Solution {
		public static String solution(String penter, String pexit, String pescape, String data) {
			String answer = "";
			StringBuilder sb = new StringBuilder();
			sb.append(penter);

			String[] dataSplit = dataSplitByPenter(penter.length(), data);

			for(int i = 0; i < dataSplit.length; ++i) {
				if(dataSplit[i].equals(penter) || dataSplit[i].equals(pexit) 
						|| dataSplit[i].equals(pescape)) {
					sb.append(pescape);
				}
				sb.append(dataSplit[i]);
			}
			sb.append(pexit);
			answer = sb.toString();

			return answer;
		}

		private static String[] dataSplitByPenter(int penterlen, String data) {
			String[] dataSplit = new String[data.length()/penterlen];
			int j = 0;

			for(int i = 0; i < data.length(); i=i+penterlen) {	
				dataSplit[j] = data.substring(i, i==0 ? penterlen : penterlen+i);
				++j;
			}
			
			return dataSplit;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String penter = "10", pexit = "11", pescape = "00", data = "00011011";
		String result = Solution.solution(penter, pexit, pescape, data);
		System.out.println(result.equals("100000010010001111"));

	}

}
