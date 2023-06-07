package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. K번째수 - https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class Ex42748 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))); // [5, 6, 3]
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmpArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmpArray);
            answer[i] = tmpArray[commands[i][2] - 1];
        }

        return answer;
    }

}
