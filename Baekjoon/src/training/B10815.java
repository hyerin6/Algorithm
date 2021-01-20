package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10815 {

	private static int[] solution(int[] sangGeunArr, int[] compareArr) {
		int[] answer = new int[compareArr.length];
		for(int i = 0; i < compareArr.length; ++i) {
			answer[i] = binarySearch(sangGeunArr, compareArr[i]) ? 1 : 0;
		}
		return answer;
	}

	private static boolean binarySearch(int[] sangGeunArr, int num) {
		int left = 0;
		int right = sangGeunArr.length-1;
		int mid = 0;

		while(left <= right) {
			mid =(left+right)/2;
			if(sangGeunArr[mid] > num){
				right = mid-1;
			} else if(sangGeunArr[mid] < num) {
				left = mid+1;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int[] sangGeunArr = new int[N];
		for(int i = 0; i < N; ++i) {
			sangGeunArr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(sangGeunArr);

		int M = Integer.parseInt(reader.readLine());
		tokenizer = new StringTokenizer(reader.readLine());

		int[] compareArr = new int[M];
		for(int i = 0; i < M; ++i) {
			compareArr[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int[] answer = solution(sangGeunArr, compareArr);
		for(int n : answer) {
			System.out.print(n + " ");
		}
	}

}
