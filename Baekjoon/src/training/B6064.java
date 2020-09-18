package training;

/*
 * 풀이: x를 맞추고 y를 따라가도록 구현 
 * x는 M만큼, y는 N만큼 증가 
 * (year - Y) % N == 0 일 때, <x:y> 찾기 성공 
 */

import java.io.*; 
import java.util.*; 

public class B6064 {

	static int gcd(int a, int b) {
		return b!=0 ? gcd(b, a%b) : a;
	}

	public static void main(String[] args) throws IOException { 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());

		for (int t = 0; t < T; ++t) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int M = Integer.parseInt(tokenizer.nextToken()); 
			int N = Integer.parseInt(tokenizer.nextToken()); 
			int X = Integer.parseInt(tokenizer.nextToken());
			int Y = Integer.parseInt(tokenizer.nextToken());

			int sol = -1;
			int MAX = N / gcd(M, N);
			for (int x = 0; x <= MAX; ++x) { 
				int year = x * M + X; 
				if ((year - Y) % N == 0) {
					sol = year;
					break; 
				}
			}

			System.out.println(sol);

		}

	}

}
