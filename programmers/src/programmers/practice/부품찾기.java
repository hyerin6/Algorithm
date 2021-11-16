package programmers.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {

	public static int binarySearch(int[] store, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (store[mid] == target) {
				return mid;
			} else if (store[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] store = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			store[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] buy = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			buy[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(store);

		for (int i = 0; i < M; ++i) {
			bw.write(binarySearch(store, buy[i], 0, store.length) > 0 ? "yes " : "no ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
