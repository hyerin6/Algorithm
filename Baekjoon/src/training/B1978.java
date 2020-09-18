package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1978 {

	static List<Integer> getPrimeNumbers(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false; 

		for(int i = 2; (i * i) <= n; ++i) {
			if (prime[i]) { 
				for(int j = i * 2; j <= n; j += i) {
					prime[j] = false;
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>(); 
		for (int i = 2; i <= n; ++i) {
			if (prime[i]) result.add(i); 
		}

		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		List<Integer> primeNumbers = getPrimeNumbers(a[N-1]);

		int cnt = 0;
		for(int i : a) {
			if(Collections.binarySearch(primeNumbers, i) >= 0) cnt++;
		}

		System.out.println(cnt);

	}

}
