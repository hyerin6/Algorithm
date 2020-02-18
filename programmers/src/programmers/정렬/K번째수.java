package programmers.정렬;

import java.util.Arrays;

public class K번째수 {

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for(int i = 0; i < commands.length; ++i){
			int start = commands[i][0]-1; // start index
			int end = commands[i][1]; // end index + 1
			int k = commands[i][2]-1; // k index 

			int temp[] = Arrays.copyOfRange(array, start, end);
			Arrays.sort(temp); // 어떤 정렬을 써야 좋을까 ?
			answer[i] = temp[k]; 
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(array, commands)));


	}

}
