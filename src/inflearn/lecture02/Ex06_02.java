package inflearn.lecture02;

import java.util.ArrayList;
import java.util.List;

public class Ex06_02 {

    static int answer;
    static int[][] relation;
    static List<Integer> list = new ArrayList<>();
    static int[] ch;

    public static int solution(int[][] fight) {
        answer = 0;
        ch = new int[7];

        // 학생 간 연관관계 셋팅
        relation = new int[7][7];
        for (int[] f : fight) {
            relation[f[0] - 1][f[1] - 1] = 1;
            relation[f[1] - 1][f[0] - 1] = 1;
        }

        // 탐색 시작
        dfs(0);

        return answer;
    }

    public static void dfs(int level) {
        if (level == 7) {
            answer++;
        } else {
            for (int i = 0; i < 7; i++) {
                if (ch[i] == 0) {
                    // 연관관계 relation의 값이 1이 아닐 때만 탐색.
                    if (list.size() != 0 && relation[list.get(list.size() - 1)][i] == 1) {
                        continue;
                    }

                    ch[i] = 1;
                    list.add(i);

                    dfs(level + 1);

                    ch[i] = 0;
                    list.remove(Integer.valueOf(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 3}, {5, 7}, {4, 2}})); // 1968
        System.out.println(solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}})); // 864
        System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}})); // 720
        System.out.println(solution(new int[][]{{1, 7}})); // 3600
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}})); // 646
    }

}