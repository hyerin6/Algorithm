package programmers.practice;

// https://blog.naver.com/hyerin_0611/222318417735
public class CombinationExam {

	public static int comb(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		} else {
			// comb(n - 1, r - 1) - 특정 원소 k를 선택한 경우
			// comb(n - 1, r) - 특정 원소 k를 선택하지 않은 경우
			return comb(n - 1, r - 1) + comb(n - 1, r);
		}
	}

	static void comb1(int[] arr, boolean[] visited, int start, int r) {
		if (r == 0) {
			print(arr, visited);
			return;
		} else {
			for (int i = start; i < arr.length; i++) {
				visited[i] = true;
				comb1(arr, visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}

	static void comb2(int[] arr, boolean[] visited, int depth, int r) {
		if (r == 0) {
			print(arr, visited);
			return;
		}
		if (depth == arr.length) {
			return;
		} else {
			visited[depth] = true;
			comb2(arr, visited, depth + 1, r - 1);
			visited[depth] = false;
			comb2(arr, visited, depth + 1, r);
		}
	}

	static void print(int[] arr, boolean[] visited) {
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == true) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("조합 경우의 수 구하기" + "\n" + comb(3, 2));
		System.out.println("\n-----------------\n");

		System.out.println("조합 구하기 : 백트래킹");
		comb1(new int[] {1, 2, 3}, new boolean[3], 0, 2);
		System.out.println("\n-----------------\n");

		System.out.println("조합 구하기 : 재귀호출");
		comb2(new int[] {1, 2, 3}, new boolean[3], 0, 2);

	}
}
