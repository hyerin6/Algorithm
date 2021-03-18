package com.swexpertacademy.algorithm.d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D2072 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; ++i) {
				int num = Integer.parseInt(st.nextToken());
				if (num % 2 != 0) {
					sum += num;
				}
			}
			bw.write("#" + test_case + " " + sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

