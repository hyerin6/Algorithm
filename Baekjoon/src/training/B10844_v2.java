package training;

public class B10844_v2 {

	// (앞자리의 수, 남은 길이)
	static int stairsNumber(int preNum, int len) { 
		if(len <= 0) return 1;
		int result = 0;
		if(preNum-1 >= 0) result = (result+stairsNumber(preNum-1, len-1))%1000000000;
		if(preNum+1 <= 9) result = (result+stairsNumber(preNum+1, len-1))%1000000000;
		return result;
	}

	static int solution(int N) {
		int result = 0;

		for(int i = 1; i < 10; ++i) {
			result += stairsNumber(i, N);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(0));
		System.out.println(solution(1));
		System.out.println(solution(2));
	}

}
