package programmers.lv1;

import java.util.Stack;

public class 크레인인형뽑기게임 {

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> basket = new Stack<>();

		for(Integer move : moves) {
			int moveIndex = move - 1;

			for(int i = 0; i < board.length; i++) {
				int k = board[i][moveIndex];
				if(k == 0) continue;

				if(!basket.empty() && basket.peek() == k) {
					basket.pop();
					answer++;
				} else {
					basket.push(k);
				}

				board[i][moveIndex] = 0;
				break;
			}
		}

		return answer * 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = {
				{0,0,0,0,0}, 
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2}, 
				{3,5,1,3,1}
		};

		int[] moves = {1,5,3,5,1,2,1,4};

		System.out.println("사라진 인형의 개수 : " + solution(board, moves));

	}

}
