package training;

import java.util.*;

public class B10844_v1 {
	static int[][]d;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		d = new int[n+1][11];

		d[1][0] = 0; //0으로 시작하는 경우는 없다

		for(int j=1;j<=9;j++)
			d[1][j] = 1;

		for(int i = 2; i <= n; ++i) {
			for(int j = 0; j <= 9; ++j) {
				if(j == 0) // 0인 경우에는 1만 가능 
					d[i][j] = d[i-1][j+1]%1000000000;
				else if(j == 9) // 9인 경우에는 8만 가능 
					d[i][j] = d[i-1][j-1]%1000000000;
				else
					d[i][j] = (d[i-1][j-1]+d[i-1][j+1])%1000000000;

				System.out.println("test d["+i+"]["+j+"] = "+d[i][j]);
			}
		}

		long sum = 0;

		for(int j = 0; j <= 9; ++j) 
			sum += d[n][j];

		System.out.println(sum%1000000000);
	}

}
