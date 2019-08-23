package select;
import java.util.Arrays;
import java.util.Random;

public class Example2 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition(int[] a, int start, int end) {
		int value = a[end];                    
		int i = start - 1;                     
		for (int j = start; j < end; ++j) 
			if (a[j] < value)          
				swap(a, ++i, j);      
		swap(a, i + 1, end);          
		return i + 1;                  
	}

	// a 배열의 start~end 에서 nth 번째 작은 값을 리턴한다.
	static int select(int[] a, int start, int end, int nth) {
		if(start >= end) return a[start]; 	// 찾을 배열의 크기가 1 이면, 그 값 리턴
		int mid = partition(a, start, end); // 배열을 partion 한다.
		int mid_nth = mid - start + 1; 		// partition 기준값이 몇번째 작은 값인지 계산한다.
		if(nth == mid_nth) return a[mid]; 	// partition 기준값이 nth 번째 작은 값이면, 찾기 종료
		if(nth < mid_nth) 
			return select(a, start, mid-1, nth); 		// 앞 부분에서 찾는다.
		else 
			return select(a, mid+1, end, nth - mid_nth); // 뒷 부분에서 찾는다.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(20);

		System.out.println(Arrays.toString(a));
		System.out.printf("1 번째 작은 값 = %d\n", select(a, 0, a.length-1, 1));
		System.out.printf("2 번째 작은 값 = %d\n", select(a, 0, a.length-1, 2));
		System.out.printf("3 번째 작은 값 = %d\n", select(a, 0, a.length-1, 3));
		System.out.printf("4 번째 작은 값 = %d\n", select(a, 0, a.length-1, 4));

	}

}
