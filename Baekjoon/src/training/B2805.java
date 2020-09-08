package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2805 {

	private static int solution(int[] trees, int minLengthTree) {
		int min = 0;
		int max = trees[trees.length-1];
		int mid = 0;

		while(max >= min) {
			mid = (max+min)/2;
			int cutTree = 0; 
			long sumCutTree = 0;
			for(int i = 0; i < trees.length; ++i) {
				cutTree = trees[i]-mid;
				sumCutTree += cutTree < 0 ? 0 : cutTree;
			}
			if(sumCutTree >= minLengthTree) min = mid + 1;
			else max = mid - 1; 
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputArray = br.readLine().split(" "); 

		int treeCount = Integer.parseInt(inputArray[0]); 
		int minLengthTree = Integer.parseInt(inputArray[1]); 

		String[] preTrees = br.readLine().split(" "); 
		int[] trees = new int[treeCount]; 
		for(int i = 0; i < preTrees.length; ++i){
			trees[i] = Integer.parseInt(preTrees[i]);
		}
		Arrays.sort(trees); 

		System.out.println(solution(trees, minLengthTree));   
	}    

}