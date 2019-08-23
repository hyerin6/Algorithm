package sort.heap;
import java.util.Arrays;

// 최소 힙 정렬 구현
// 부모 노드의 값이 자식 노드의 값 보다 작은 힙을 최소힙이라고 한다.
public class Example1 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void buildHeap(int[] a) { // 주어진 배열을 힙으로 만들기
		int end = a.length-1;
		for(int i = (end-1)/2; i >= 0; --i) 
			heapify(a, i, end);
	}

	static void heapify(int[] a, int k, int end) { // 주어진 인덱스 자리 조정
		int leftChild = 2*k+1, rightChild = 2*k+2;
		int smaller;

		if(end >= rightChild) 
			smaller = (a[leftChild] < a[rightChild]) ? leftChild : rightChild;
		else if(end >= leftChild)
			smaller = leftChild;
		else return;

		if(a[smaller] < a[k]) {
			swap(a, smaller, k);
			heapify(a, smaller, end);
		}
	}

	static void heapSort(int[] a) { // 정렬
		buildHeap(a); // 일단 배열을 힙으로 만들자 
		for (int end = a.length - 1; end > 0; --end) { // root를 마지막 노드와 비교하며 정렬
			swap(a, 0, end);
			heapify(a, 0, end - 1); // root와 end를 swap해서 end-1을 마지막으로.. 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 3, 8, 2, 10, 4, 6, 7, 1, 9, 5 };
		heapSort(a);
		System.out.println(Arrays.toString(a));

	}

}
