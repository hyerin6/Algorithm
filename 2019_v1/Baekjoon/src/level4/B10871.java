package level4;
import java.util.Scanner; 

public class B10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int max = scan.nextInt();

		int[] arr = new int[n];

		for(int i = 0; i < arr.length; ++i) {
			arr[i] = scan.nextInt();
			if(arr[i] < max) 
				System.out.printf("%d ", arr[i]);
		}

	}

}
