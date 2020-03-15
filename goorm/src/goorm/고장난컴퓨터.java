package goorm;

import java.io.*;
import java.util.*;

public class 고장난컴퓨터 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(t.nextToken());
		int C = Integer.parseInt(t.nextToken());

		t = new StringTokenizer(br.readLine());

		if(C == 0) {
			System.out.println(0);
			return;
		}

		if(N == 1 && C > 0) {
			System.out.println(1);
			return;
		}

		// 몇 초에 키보드 입력하는지 입력받기 
		int[] arr = new int[N];
		for(int i = 0; i < N; ++i) 
			arr[i] = Integer.parseInt(t.nextToken());

		int result = 0; 
		int count = 1;
		for(int i = 1; i < N; ++i) {
			if(arr[i]-arr[i-1] > C) { // 입력하지 않은 경우가 C초가 넘으면 
				result = 0;
				count = 1;
			} else {
				count++;
				result = count;
			}
		}

		System.out.println(result);

	}

}
