package course;

import java.util.Scanner;

// 순열 사이클 
public class B10451 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int loop = scan.nextInt();

		for(int l = 0; l < loop; ++l) {
			int len = scan.nextInt();
			int[] arr = new int[len];

			for (int i = 0; i < arr.length; ++i) 
				arr[i] = scan.nextInt() - 1;

			int length = arr.length;
			int 사이클수 = 0;
			int[] v = new int[length]; // 방문했었는지 표시

			for(int i = 0; i < length; ++i) {
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

}
