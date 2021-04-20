package programmers.lv1;

public class 폰켓몬 {

	static boolean[] check = new boolean[200001];

	public static int solution(int[] nums) {
		int answer = 0;
		int size = nums.length / 2;

		for (int i = 0; i < nums.length; i++) {
			if (!check[nums[i]]) {
				check[nums[i]] = true;
				answer++;
				if (answer == size) {
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 2}));
	}
}
