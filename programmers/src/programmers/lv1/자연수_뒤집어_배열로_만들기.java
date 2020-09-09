package programmers.lv1;

public class 자연수_뒤집어_배열로_만들기 {

	private static int[] solution(long n) {
		int[] answer = new int[String.valueOf(n).length()];
		int cnt = 0;
		while(true) {
			answer[cnt] = (int)(n%10);
			cnt++;
			if(n < 10) break;
			n = n/10;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = solution(12345);
	}

}
