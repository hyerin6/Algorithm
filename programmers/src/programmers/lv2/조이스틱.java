package programmers.lv2;

public class 조이스틱 {

	public static int solution(String name) {
		boolean visit[] = new boolean[name.length()];
		int[] findPosArr = {0, 0};
		int sum = 0;

		while(true) {
			int idx = findPosArr[0];
			int move = findPosArr[1];
			if(idx == -1) break;

			visit[idx] = true;
			sum += changeAlphabet(idx, name);
			sum += move;
			findPosArr = findPos(visit, name, idx);
		}

		return sum;
	}

	private static int changeAlphabet(int i, String name) {
		int up = name.charAt(i) - 'A';
		int down = 'Z' - name.charAt(i) + 1;

		if(up > down) {
			return down;
		} else {
			return up;
		}
	}

	private static int[] findPos(boolean[] visit, String name, int idx) {
		int pos = 0, move = 0;
		int right = idx;
		int left = idx;

		while(true) {
			right = right + 1 < name.length() ? right + 1 : right;
			left = left - 1 < 0 ? name.length() - 1 : left - 1;
			move++;
			if(left == idx) {
				pos = -1;
				break;
			}
			if(!visit[right] && name.charAt(right) != 'A') {
				pos = right;
				break;
			}
			if(!visit[left] && name.charAt(left) != 'A') {
				pos = left;
				break;
			}
		}

		return new int[] {pos, move};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(조이스틱.solution("JEROEN")); // 56
		System.out.println(조이스틱.solution("ABABAAAAAAABA")); // 11
	}

}
