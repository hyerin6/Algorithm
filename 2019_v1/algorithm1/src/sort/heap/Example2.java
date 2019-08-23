package sort.heap;
import java.util.Arrays;

// 최대 힙 정렬 구현
public class Example2 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void buildHeap(int[] a) {
		int end = a.length - 1;
		for (int i = (end-1)/2; i >= 0; --i) 
			heapify(a, i, end);
	}

	static void heapify(int[] a, int k, int end) {
		int leftChild = 2*k+1, rightChild = 2*k+2;
		int larger;

		if (rightChild <= end)
			larger = (a[leftChild] > a[rightChild]) ? leftChild : rightChild;
		else if (leftChild <= end) 
			larger = leftChild;
		else return;

		if (a[larger] > a[k]) {
			swap(a, larger, k);
			heapify(a, larger, end);
		}
	}

	static void heapSort(int[] a) {
		buildHeap(a);
		for (int end = a.length - 1; end >= 1; --end) {
			swap(a, 0, end);
			heapify(a, 0, end - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 3, 8, 2, 10, 4, 6, 7, 1, 9, 5 };
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

}
