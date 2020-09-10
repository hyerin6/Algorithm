public class 다트게임 {

	static class Solution {
		public int solution(String dartResult) {
			int answer = 0;
			final String SINGLE = "S";
			final String DOUBLE = "D";
			final String TRIPLE = "T";
			final String STAR = "*";
			final String ACHA = "#";

			int[] score = new int[3];
			double[] bonus = new double[3];
			String[] option = new String[3];

			// 1. score, bonus, option을 dartResult를 통해 초기화 (1S|2D|*3T|)
			String scoreTemp = "";
			for (int i = 0, j = 0; i < dartResult.length(); i++) {
				String s = dartResult.substring(i, i+1);
				if (s.equals(SINGLE) || s.equals(DOUBLE) || s.equals(TRIPLE)) {
					if (s.equals(SINGLE)) {
						bonus[j] = 1;
					} else if (s.equals(DOUBLE)) {
						bonus[j] = 2;
					} else if (s.equals(TRIPLE)) {
						bonus[j] = 3;
					}
					score[j] = Integer.parseInt(scoreTemp);
					option[j] = "";
					j++;
					scoreTemp = "";
				} else if (s.equals(STAR) || s.equals(ACHA)) {
					option[j-1] = s;
				} else {
					scoreTemp += s;
				}
			}

			// 2. 점수 계산
			int[] answers = new int[3];
			for (int i = 0; i < 3; i++) {
				answers[i] += Math.pow(score[i], bonus[i]);
				if (option[i].equals(STAR)) {
					if (i > 0) {
						answers[i-1] *= 2;
					}
					answers[i] *= 2;
				} else if (option[i].equals(ACHA)) {
					answers[i] *= (-1);
				}
			}
			answer = answers[0] + answers[1] + answers[2];
			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();

		String[] arr = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
		for(String str : arr) {
			System.out.println(s.solution(str));
		}
	}

}
