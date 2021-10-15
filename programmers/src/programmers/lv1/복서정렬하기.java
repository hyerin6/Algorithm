package programmers.lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Player {
    int num; // 번호
    int weight; // 몸무게
    Double score; // 승률
    int numWinOverWeight; // 나보다 무거운 선수에게 이긴 횟수

    public Player(int num, int weight, Double score, int numWinOverWeight) {
        this.num = num;
        this.weight = weight;
        this.score = score;
        this.numWinOverWeight = numWinOverWeight;
    }
}

public class 복서정렬하기 {
    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        int[][] boxer = new int[weights.length][4];

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {
            Player player = new Player(i + 1, weights[i], 0.0, 0);
            int cnt = 0;
            int win = 0;
            int winbigman = 0;
            for (int j = 0; j < weights.length; j++) {
                char ch = head2head[i].charAt(j);
                if (ch != 'N') cnt++;
                if (ch == 'W') {
                    win++;
                    if (weights[i] < weights[j]) {
                        winbigman++;
                    }
                }
            }
            player.score = cnt != 0 ? (double) win / cnt * 100 : 0.0;
            player.numWinOverWeight = winbigman;
            players.add(player);
        }

        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (!o1.score.equals(o2.score))
                    return o2.score.compareTo(o1.score);
                if (o1.numWinOverWeight != o2.numWinOverWeight)
                    return o2.numWinOverWeight - o1.numWinOverWeight;
                if (o1.weight != o2.weight) return o2.weight - o1.weight;
                return o1.num - o2.num;
            }
        });

        for (int i = 0; i < boxer.length; i++) {
            answer[i] = players.get(i).num;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int[] result1 = solution(new int[]{50, 82, 75, 120}, new String[]{"NLWL", "WNLL", "LWNW", "WWLN"});
        int[] result2 = solution(new int[]{145, 92, 86}, new String[]{"NLW", "WNL", "LWN"});
        int[] result3 = solution(new int[]{60, 70, 60}, new String[]{"NNN", "NNN", "NNN"});

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }
}

