package prime;

/* 에라토스테네스의 체 구현
 * 
 * 1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
 * 2. 목록의 선두인 2는 소수이다.
 * 3. 2의 배수를 모두 지운다.
 * 4. 목록에 남아있는 수 중에서, 2 다음 수인 3은 소수이다.
 * 5. 목록에서 3의 배수를 모두 지운다.
 * 6. 목록에 남아있는 수 중에서, 3 다음 수인 5는 소수이다.
 * 7. 목록에서 5의 배수를 모두 지운다.
 * 8. 목록에 남아있는 수 중에서, 5 다음 수인 7은 소수이다.
 * 9. 목록에서 7의 배수를 모두 지운다.
 * 10. 위의 과정을 반복하면 목록에 소수만 남는다.
 * 
 * 120 보다 작은 소수 목록을 구하고 싶다면?
 * √120<11 이므로, 11보다 작은 수의 배수들만 지워도 충분하다.
 * 즉 120 이하의 수들 중에서 2, 3, 5, 7의 배수를 지우고 남은 수는 모두 소수이다.
 */

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getPrimeNumbers(100));

	}

}
