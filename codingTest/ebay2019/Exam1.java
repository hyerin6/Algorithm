package programmers.exam2019;

/*
 * 배열 s에는 각 그룹의 구성원의 수가 들어있다.
 * 같은 그룹끼리 택시를 타야하지만 한 택시에 여러 그룹이 함께 탈 수 있다.
 * 택시에는 최대 4명까지 탑승 가능
 */
public class Exam1 {
	static int solution(int[] s) {
		int[] 그룹수 = new int[5];

		for (int 그룹크기 : s)
			++그룹수[그룹크기];
		
		/* 아래 코드는 위 반복문과 같은 코드이다.
		for(int i = 0; i < s.length; ++i) 
				++그룹수[s[i]];
		 */

		int 그룹3과1 = Math.min(그룹수[3], 그룹수[1]);
		int 택시수 = 그룹수[4];
		택시수 += 그룹3과1;
		그룹수[1] -= 그룹3과1;
		그룹수[3] -= 그룹3과1; // 그룹3 + 그룹1 합승 완료
		택시수 += 그룹수[3]; // 그룹3 탐승 완료
		택시수 += (그룹수[2] / 2); // 그룹2 + 그룹2 합승 완료
		그룹수[2] = 그룹수[2] % 2; // 남은 그룹2 수는 1 or 0
		if (그룹수[2] == 1) {
			++택시수;
			그룹수[1] = Math.max(그룹수[1] - 2, 0); // 남은 그룹2 + 그룹1 탐승 완료
		}
		택시수 += (그룹수[1] + 3) / 4; // (그룹수[1] / 4) 올림. 그룹1 탑승 완료
		return 택시수;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1, 2, 4, 3, 3})); // 4
		System.out.println(solution(new int[] {2, 3, 4, 4, 2, 1, 3, 1})); // 5
	}

}
