package hackday;

public class 주사위 {
	
	public static int 필요한_회전수(int start, int end) {
		if(end-start == 0)
			return 0;
		else 
			return (end+start == 7) ? 2 : 1;
	}
	
	public static int 필요한_회전수_합계(int[] 주사위배열, int 목표숫자) {
		int sum = 0;
		for (int 주사위 : 주사위배열)
			sum += 필요한_회전수(주사위, 목표숫자);
		return sum;
	}

	public static int solution(int[] A) {
		int 최소_회전수 = Integer.MAX_VALUE;
		for(int i = 0; i <= 6; ++i) {
			int 회전수 = 필요한_회전수_합계(A, i);
			if (회전수 < 최소_회전수) 최소_회전수 = 회전수;
		}
		return 최소_회전수;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A1 = {1,2,3};
		int[] A2 = {1,1,6}; 
		int[] A3 = {1,6,2,3};

		System.out.println(solution(A1));
		System.out.println(solution(A2)); 
		System.out.println(solution(A3));
		
	}

}
