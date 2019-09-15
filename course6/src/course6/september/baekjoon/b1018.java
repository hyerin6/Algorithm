package course6.september.baekjoon;

import java.util.Scanner;

// 백준 1018번 체스판 다시 칠하기 
public class b1018 {

	static String[] Wresult = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};
	static String[] Bresult = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};


	public static int W(char[][] A, int row, int col) {
		int result = 0;


		return result;
	}

	public static int B(char[][] A, int row, int col) {
		int result = 0;


		return result;
	}

	public static int min(int a, int b, int c) {
		return (a<b ? (a<c ? a:c) : (b<c ? b:c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt(); 


		String[] NM = new String [N];
		for(int i = 0; i < N ; i ++) {
			NM[i] = scan.nextLine();                    
		}

		// 최대값
		int result = 2500;



	}

}
