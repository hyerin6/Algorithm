package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15658 {
	static int N;
	static int[] arr;
	static int[] operator;
	static int minValue = 1000000000;
	static int maxValue = -1000000000;

	public static void find(int index, int sum) {
		if (index == N) {
			minValue = Math.min(sum, minValue);
			maxValue = Math.max(sum, maxValue);
			return;
		}

		int base = arr[index];
		for (int i = 0; i < 4; ++i) {
			if (operator[i] <= 0) {
				continue;
			}
			int tempSum = sum;
			switch (i) {
				case 0:
					tempSum += base;
					break;
				case 1:
					tempSum -= base;
					break;
				case 2:
					tempSum *= base;
					break;
				case 3:
					tempSum /= base;
					break;
			}
			operator[i]--;
			find(index + 1, tempSum);
			operator[i]++;
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		operator = new int[4];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; ++i) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		find(1, arr[0]);

		bw.write(maxValue + "\n");
		bw.write(minValue + "\n");
		bw.close();
		br.close();

	}
}
