package programmers.lv1;

public class 서울에서_김서방_찾기 {

	static class Solution {
		public String solution(String[] seoul) {
			String answer = "";

			String reg = "Kim";

			for(int i = 0; i < seoul.length; ++i) {
				if(seoul[i].matches(reg)) {
					answer = "김서방은 " + i + "에 있다";
					break;
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] seoul = {"Jane", "Kim"};
		System.out.println(new Solution().solution(seoul));

	}

}
