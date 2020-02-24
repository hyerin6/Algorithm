package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B10814 {

	public static void solution(String[][] arr) {

		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
			}

		});


		for(int i = 0; i < arr.length; ++i) 
			System.out.println(arr[i][0] + " " + arr[i][1]);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		String[][] arr = new String[N][2];
		String[] str = new String[2];

		// 0 : 나이 , 1 : 이름
		// 애초에 가입 순으로 입력하기 때문에 가입 순서는 신경쓰지 않아도 된다. 
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			arr[i][0] = str[0];
			arr[i][1] = str[1];
		}

		solution(arr);

	}

}
