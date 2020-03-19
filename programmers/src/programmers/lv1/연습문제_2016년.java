package programmers.lv1;

public class 연습문제_2016년 {

	static String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
	static int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static String solution(int a, int b) {
		String answer = "";

		int date = 0;
		for(int i = 0; i < a-1; ++i) {
			date += month[i];
		}

		date += (b - 1);
		answer = day[date % 7];

		//		switch(date%7) {
		//		case 0:
		//			answer = day[6];
		//			break;
		//		case 1:
		//			answer = day[0];
		//			break;
		//		case 2:
		//			answer = day[1];
		//			break;
		//		case 3:
		//			answer = day[2];
		//			break;
		//		case 4:
		//			answer = day[3];
		//			break;
		//		case 5:
		//			answer = day[4];
		//			break;
		//		case 6:
		//			answer = day[5];
		//			break;
		//		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(1, 1));
		System.out.println(solution(5, 24));
		System.out.println(solution(7, 7));

	}

}
