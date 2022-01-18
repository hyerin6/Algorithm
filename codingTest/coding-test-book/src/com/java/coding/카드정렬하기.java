package com.java.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<Long>();

		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}

		long num = 0;
		// 우선순위 큐에 2개이상 들어있어야 비교가 가능하다.
		while (pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();

			num += temp1 + temp2;
			pq.add(temp1 + temp2); // 합한 묶음 다시 넣기
		}

		System.out.println(num);

	}
}
