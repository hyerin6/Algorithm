package silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816 {

	public static int lowerBound(int[] sangGeunArr, int key) {    // 배열 a에서 k값이 처음으로 나타나는 인덱스
		int start = 0;
		int end = sangGeunArr.length - 1;
		int mid = 0;

		while (start < end) {
			mid = (start + end) / 2;
			if (sangGeunArr[mid] >= key) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	public static int upperBound(int[] sangGeunArr, int key) {    // 배열 a에서 k보다 큰 값이 처음으로 나타나는 인덱스
		int start = 0;
		int end = sangGeunArr.length - 1;
		int mid = 0;

		while (start < end) {
			mid = (start + end) / 2;
			if (sangGeunArr[mid] > key) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		if (sangGeunArr[end] == key) {
			end++;    // 상한값이 배열 크기를 넘어설 때
		}

		return end;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int[] sangGeunArr = new int[N];
		for (int i = 0; i < N; ++i) {
			sangGeunArr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(sangGeunArr);

		int M = Integer.parseInt(reader.readLine());
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; ++i) {
			int k = Integer.parseInt(tokenizer.nextToken());
			bw.append((upperBound(sangGeunArr, k) - lowerBound(sangGeunArr, k)) + " ");
		}

		bw.flush();
		bw.close();
	}

}
