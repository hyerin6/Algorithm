package programmers.lv2;

public class 최댓값과_최솟값 {

	public static String solution(String s) {
		String[] tmp = s.split(" ");
		int min, max, n;
		min = max = Integer.parseInt(tmp[0]);
		for (int i = 1; i < tmp.length; i++) {
			n = Integer.parseInt(tmp[i]);
			if (min > n)
				min = n;
			if (max < n)
				max = n;
		}

		return min + " " + max;
	}

	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));
	}
}
