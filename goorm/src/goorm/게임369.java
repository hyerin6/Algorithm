package goorm;

import java.io.*;
import java.util.*;

public class 게임369 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(t.nextToken());
		int result = 0;

		if(N < 12) {
			for(int i = 2; i < N; ++i) 
				if(i%3 == 0) 
					result++;

			System.out.println(result);
			return;
		}

		else if(N > 12) {
			result = 3;
			for(int i = 13; i < N; ++i) {
				String[] arr = String.valueOf(i).split("");
				for(int j = 0; j < arr.length; ++j) 
					if(arr[j].equals("3") ||
							arr[j].equals("6") ||
							arr[j].equals("9")) 
						result++;
			}
			System.out.println(result);
			return;
		}

	}

}
