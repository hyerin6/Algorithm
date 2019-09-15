package course6.september.baekjoon;

import java.util.Scanner;

// 백준 1018번 체스판 다시 칠하기 
public class b1018 {

	static String[] Wresult = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};
	static String[] Bresult = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};


	public static int W(String[] A, int i, int j) {
		int result = 0;

		for(int a = i; a < i+8; a++) {
			for(int b = j; b < j+8 ; b++) {
				if(A[a].charAt(b) == Bresult[a-i].charAt(b-j)) {
					result++;
				}
			}
		}
		return result;
	}

	public static int B(String[] A,  int i, int j) {
		int result = 0;

		for(int a = i; a < i+8; a++) {
			for(int b = j; b < j+8 ; b++ ) {
				if(A[a].charAt(b) == Wresult[a-i].charAt(b-j)) {
					result++;
				}
			}
		}
		return result;
	}

	public static int min(int a, int b, int c) {
		return (a<b ? (a<c ? a:c) : (b<c ? b:c));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt(); String s = scan.nextLine();


		String[] NM = new String [N];
		for(int i = 0; i < N ; i ++) {
			NM[i] = scan.nextLine();                    
		}

		// 최대값
		int result = 2500;

		for(int i = 0 ; i+7 < N ; ++i) {
			for(int j = 0 ; j+7 < M; ++j) {
				result = min(result, W(NM,i,j), B(NM,i,j));
			}

		}
		System.out.println(result);

	}

}
