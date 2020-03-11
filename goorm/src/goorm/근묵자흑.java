package goorm;

import java.io.*;
import java.util.*;

public class 근묵자흑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer t = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(t.nextToken());
		int K = Integer.parseInt(t.nextToken());

		//System.out.println(N +","+ K);


		int[] arr = new int[N];

		t = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; ++i){
			int n = Integer.parseInt(t.nextToken());
			arr[i] = n;
		}

		if(K == 1) {
			System.out.println(N); 
			return;
		}

		if(K == 2) {
			System.out.println(N-1);
			return;
		}

		if(N <= K) { 
			System.out.println(1);
			return;
		}

		else {
			int start = N-K;
			int n = 0;
			if(start%(K-1) != 0){
				n = 1;
			}
			System.out.println(n+1+(start/(K-1)));
			return;
		}

	}
}