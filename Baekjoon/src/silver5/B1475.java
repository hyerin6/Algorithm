package silver5;

import java.util.Scanner;

public class B1475 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		int[] count = new int[10];

		for (int i = 0; i < num.length(); ++i)
			count[num.charAt(i) - '0'] += 1;

		count[6] += count[9];

		if (count[6] % 2 == 0)
			count[6] /= 2;
		else
			count[6] = (count[6] / 2) + 1;

		int max = 0;
		for (int i = 0; i < count.length - 1; ++i)
			if (count[i] > max)
				max = count[i];

		System.out.println(max);
	}
}
