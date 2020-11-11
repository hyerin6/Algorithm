package training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10989 {

	// 값의 종류가 1~10000 이므로, counting sort를 구현 
	public static void countingSort(int[] a, int max) {
		int[] count = new int[max+1];
		for (int i = 0; i < a.length; ++i)
			++count[a[i]];

		int index = 0; 
		for (int i = 0; i < count.length; ++i) 
			for (int j = 0; j < count[i]; ++j) 
				a[index++] = (short)i;
	}

	// 이 문제는 시간 제한이 있다. 
	// 빠른 입출력을 위해서, BufferedReader, BufferedWriter를 사용한다.   
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); 
		int[] a = new int[N+1];

		for(int i = 0; i < N; ++i) {
			a[i] = Integer.parseInt(br.readLine());
		}

		countingSort(a, 10000);

		for (int i = 1; i < a.length; ++i) {
			bw.write(a[i] + "\n");
		}

		br.close();
		bw.close();

	}


}
