package programmers.lv2;

public class 큰수만들기 {

	static class Solution {
		public String solution(String number, int k) {
			int idx = 0;
			char max;
			StringBuilder answer = new StringBuilder();

			if(number.charAt(0) == '0') return "0";

			// k개의 숫자를 뺏을 때 최대 숫자는 적어도 0번째부터 k번째 숫자 중에 나와야 한다.  
			for(int i = 0; i < number.length() - k; ++i) {
				max = '0';
				for(int j = idx; j <= k + i; ++j) {
					if(max < number.charAt(j)) {
						max = number.charAt(j); 
						idx = j + 1;
					}
				}			
				answer.append(max);
			}
			return answer.toString();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.solution("1924", 2));
	}

}
