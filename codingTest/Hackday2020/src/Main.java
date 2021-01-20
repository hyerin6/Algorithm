import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static String solution(int n, int[][] delivery) {
		String answer = "";

		Map<Integer, String> map = new HashMap<>();

		for(int i = 0; i < delivery.length; ++i) {
			if(delivery[i][2] == 1) {
				map.put(delivery[i][0], "O");
				map.put(delivery[i][1], "O");
			}
		}
		
		for(int i = 0; i < delivery.length; ++i) {
			if(delivery[i][2] == 0 && "O".equals(map.get(delivery[i][0]))) 
				map.put(delivery[i][1], "X");
			if(delivery[i][2] == 0 && "O".equals(map.get(delivery[i][1]))) 
				map.put(delivery[i][0], "X");
		}

		for(int i = 1; i <= n; ++i) 
			if(map.containsKey(i))
				answer += map.get(i);
			else 
				answer += "?";

		return answer;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1, 3, 1}, {3, 5, 0}, {5,4,0}, {2,5,0}};
		int[][] arr2 = {{5, 6, 0}, {1, 3, 1}, {1, 5, 0}, {7, 6, 0}, {3, 7, 1}, {2, 5, 0}};
		System.out.println(solution(6, arr));
		System.out.println(solution(7, arr2));
	}

}
