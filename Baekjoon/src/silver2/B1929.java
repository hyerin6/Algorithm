package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1929 {

	static List<Integer> getPrimeNumbers(int start, int end) {
		boolean[] prime = new boolean[end + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; (i * i) <= end; ++i) {
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer t = new StringTokenizer(reader.readLine());

		int start = Integer.parseInt(t.nextToken());
		int end = Integer.parseInt(t.nextToken());

		List<Integer> primeNumbers = getPrimeNumbers(start, end);

		// primeNumbers 목록은 오름차순이기 때문에, 이진 탐색을 할 수 있다. 
		int index = Collections.binarySearch(primeNumbers, start);

		/*
		 * binarySearch 메소드가 음수를 리턴한 경우는, 찾을 값이 목록에 없는 경우이다.
		 * 이 메소드는, 찾은 경우에 그 값의 위치(index)를 리턴하고,
		 * 못찾은 경우에, 그 값이 있어야할(삽입할) 위치(index)의 -index-1 값을 리턴한다.
		 * -index-1 값에서 원래 index 값을 구하려면, -index-1 하면 된다.
		 */
		if (index < 0)
			index = -index - 1;

		for (int i = index; i < primeNumbers.size(); ++i) {
			System.out.println(primeNumbers.get(i));
		}

	}

}
