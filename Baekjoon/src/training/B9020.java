package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B9020 {

	static List<Integer> getPrimeNumbers(int end) {
		boolean[] prime = new boolean[end+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false; 

		for(int i = 2; (i * i) <= end; ++i) {
			if (prime[i]) { 
				for(int j = i * 2; j <= end; j += i) {
					prime[j] = false;
				}
			} 
		}

		ArrayList<Integer> result = new ArrayList<>(); 
		for (int i = 2; i <= end; ++i) {
			if (prime[i]) result.add(i); 
		}
		return result;
	}

	static void solution(List<Integer> primeNumbers, int n) {
		int index = Collections.binarySearch(primeNumbers, n / 2);
		if (index < 0) index = -index - 1;

		for (int i = index; i >= 0; --i) { 
			int a = primeNumbers.get(i);
			int b = n - a; 
			if (Collections.binarySearch(primeNumbers, b) >= 0) { 
				System.out.printf("%d %d\n", Math.min(a, b), Math.max(a, b));
				return; 
			} 
		} 
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; ++i) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> primeNumbers = getPrimeNumbers(n);
			solution(primeNumbers, n);
		}

	}

}
