package level4;
import java.util.Scanner;
/*
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 
 * N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 
 * 점수는 0보다 크거나 같고, 
 * 100보다 작거나 같은 정수이다.
 * 
 * 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 */
public class B4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int c = scan.nextInt();
		int sum = 0;
		int count = 0;
		int score = 0;
		double avg = 0;
		int scores[] = new int[1000];

		for(int i = 0; i < c; ++i){
			int n = scan.nextInt();
			count = 0; sum =0; avg = 0;
			for(int j = 0; j < n; ++j) {
				scores[j] = scan.nextInt();
				sum += scores[j];
			}
			avg = (double) sum / n;

			for (int j = 0; j < n; ++j) {
				if (scores[j] > avg) {
					count++;
				}
			}
			System.out.printf("%.3f", 100.0 * count / n);
			System.out.println("%");
		}

	}

}
