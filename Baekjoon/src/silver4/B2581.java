package silver4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B2581 {

	static List<Integer> getPrimeNumbers(int end) {
		boolean[] prime = new boolean[end + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i * i <= end; ++i) {
			if (prime[i]) {
				for (int j = i * 2; j <= end; j += i) {
					prime[j] = false;
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 2; i <= end; ++i) {
			if (prime[i])
				result.add(i);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int start = scan.nextInt();
		int end = scan.nextInt();

		List<Integer> primeNumbers = getPrimeNumbers(end);
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i : primeNumbers) {
			if (start > i)
				continue;
			sum += i;
			if (min > i)
				min = i;

		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
