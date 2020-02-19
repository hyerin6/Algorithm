package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 퀵정렬도 사용해봤지만, 시간제한이 2초라서 시간초과된다..
 * 
 * Scanner을 사용하지 않고 
 * BufferedReader를 사용해서 입력받으니까 문제가 해결되었다. 
 * BufferedReader는 한줄을 통째로 입력받는 방법으로 Scanner 보다 빠르다. 
 */
public class B2751 {

	static void mergeSort(int[] a, int start, int end) {
		if (start == end) return;        
		int middle = (start + end) / 2;
		mergeSort(a, start, middle);
		mergeSort(a, middle + 1, end);
		merge(a, start, middle, end);
	}

	static void merge(int[] a, int start, int middle, int end) {
		int len = end - start + 1;
		int[] temp = new int[len];
		int i = 0;
		int index1 = start;
		int index2 = middle + 1;

		while(index1 <= middle && index2 <= end) {
			if (a[index1] < a[index2])              
				temp[i++] = a[index1++];            
			else
				temp[i++] = a[index2++];
		}

		while (index1 <= middle)             
			temp[i++] = a[index1++];
		while (index2 <= end)               
			temp[i++] = a[index2++];
		for (i = 0; i < temp.length; ++i) {  
			a[start + i] = temp[i];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long start = System.currentTimeMillis();
		int n = Integer.parseInt(br.readLine());

		int[]a = new int[n];
		for(int i = 0; i < n; ++i) {
			a[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(a, 0, a.length-1);
		for(int i : a) {
			System.out.println(i);
		}

		long end = System.currentTimeMillis();
		System.out.println("실행시간: " + (end - start) / 1000.0);
	}
}
