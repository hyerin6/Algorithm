package programmers.정렬;

import java.util.Arrays;

public class K번째수 {

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for(int i = 0; i < commands.length; ++i){
			int start = commands[i][0]-1; // start index
			int end = commands[i][1]; // end index + 1
			int k = commands[i][2]-1; // k index 

			int[] temp = array.clone();
			for(int j = start; j < end-1; ++j) { // selection sort 
				int minIndex = findMin(temp, j, end);
				swap(temp, j, minIndex);
			}
			answer[i] = temp[start+k]; 
		}
		return answer;
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int findMin(int[] a, int start, int end) {
		int minValue = a[start];
		int minIndex = start;
		for (int i = start; i < end; ++i) {
			if (a[i] < minValue) {
				minValue = a[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(array, commands)));


	}

}
