package programmers.lv1;

public class 최소직사각형 {

    public static int solution(int[][] sizes) {
        int answer = 0;

        int max_width = Integer.MIN_VALUE; // 가로
        int max_high = Integer.MIN_VALUE; // 세로

        for (int[] size : sizes) {
            int min = Math.min(size[0], size[1]);
            int max = Math.max(size[0], size[1]);
            max_width = Math.max(max, max_width);
            max_high = Math.max(min, max_high);
        }

        answer = max_width * max_high;

        return answer;
    }

    public static void main(String[] args) {
        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int answer = solution(sizes);
        System.out.println(answer);
    }


}
