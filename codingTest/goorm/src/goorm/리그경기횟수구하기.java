package goorm;

import java.io.*;

public class 리그경기횟수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int result = 0;
		for(int i = 1; i < n; ++i)
			result += i;

		System.out.println(result);

	}

}
