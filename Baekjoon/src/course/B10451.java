package course;

import java.util.Scanner;

// 순열 사이클 
public class B10451 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	
		int len = scan.nextInt();
		int[] arr = new int[len];

		int 사이클수 = 0;
		int[] v = new int[len]; // 방문했었는지 표시

		for(int i = 0; i < len; ++i) 
			arr[i] = scan.nextInt() - 1; // index는 0부터니까 값에 -1을 해준다.

		for(int i = 0; i < len; ++i) {
			if(v[i] == 1) continue;
			v[i] = 1;
			int j = arr[i];
			while(true) {
				if(v[j] == 1) break;
				v[j] = 1;
				j = arr[j];
			}
			++사이클수;
		}
		System.out.println(사이클수);
	}

}
