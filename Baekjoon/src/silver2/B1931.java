package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1931

class Meeting {
	int start, end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int length() {
		return end - start + 1;
	}

	public boolean overlap(Meeting meeting) {
		if (this.end <= meeting.start)
			return false;
		if (this.start >= meeting.end)
			return false;
		return true;
	}
}

public class B1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Meeting[] A = new Meeting[N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tokenizer.nextToken());
			int end = Integer.parseInt(tokenizer.nextToken());
			A[i] = new Meeting(start, end);
		}

		/* 정렬 기준
		   1. 끝나는 시간
		   2. 회의 시간
		 */
		Arrays.sort(A, (m1, m2) -> {
			int r = m1.end - m2.end;
			if (r != 0) {
				return r;
			}
			return m1.length() - m2.length();
		});

		int count = 0;
		Meeting pre = null;
		for (Meeting m : A) {
			if (pre == null || pre.overlap(m) == false) {
				++count;
				pre = m;
			}
		}

		System.out.println(count);
	}
}
