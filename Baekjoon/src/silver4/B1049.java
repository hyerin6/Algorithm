package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[input]
끊어진_기타줄 기타줄_브랜드
패키지_가격 낱개_가격

[output]
기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값
 */
public class B1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] unit = new int[M];
		int[] pack = new int[M];

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			pack[i] = Integer.parseInt(st.nextToken());
			unit[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(unit);
		Arrays.sort(pack);

		int min = Integer.MAX_VALUE;

		// 가장 싼 6개짜리 팩 구매 vs 가장 싼 낱개 구매 vs (가장싼 6개짜리 팩 + 낱개)
		min = Math.min(((N / 6) + 1) * pack[0], N * unit[0]);
		min = Math.min(min, ((N / 6)) * pack[0] + (N % 6) * unit[0]);
		System.out.println(min);
	}
}
