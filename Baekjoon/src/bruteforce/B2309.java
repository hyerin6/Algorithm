package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] hight = new int[9];

		for (int i = 0; i < hight.length; ++i) {
			hight[i] = Integer.parseInt(br.readLine());
		}

	}

}
