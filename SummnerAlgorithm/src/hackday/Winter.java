package hackday;

public class Winter {
	
	public static int getMaxValue(int[] a, int start, int end) {
		return 1;
	}
	 
	public static int solution(int[] a) {
		int j = a.length-1;
		while (a[j] > a[0])
			--j;
		
		int winterMax = getMaxValue(a, 0, j);
		while(winterMax >= a[j])
			++j;
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = { 5, -2, 3, 8, 6 }; 
		int[] a2 = { -5, -5, -5, -42, 6, 12 }; 
		int[] a3 = { 5, -2, 3, 6, -2, 8 };
		int[] a4 = { -3, 6, -5, 3, 2, 7};
		
		System.out.println(solution(a1));
		System.out.println(solution(a2));
		System.out.println(solution(a3));
		System.out.println(solution(a4));

	}

}
