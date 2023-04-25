package inflearn.lecture02;

import java.util.Arrays;

public class Ex01_01 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}}))
        ); // ['D', 'B', 'A', 'C', 'E']

        System.out.println(
                Arrays.toString(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}}))
        ); // ['A', 'C', 'B', 'F', 'D', 'G', 'E']

        System.out.println(
                Arrays.toString(solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}}))
        ); // ['C', 'A', 'B', 'F', 'D', 'E', 'H', 'G']

        System.out.println(
                Arrays.toString(solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}}))
        ); // ['C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H']
    }

    public static char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (char)(65 + i);
        }

        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                int value = ladder[i][j];

                char tmp = answer[value - 1];
                answer[value - 1] = answer[value];
                answer[value] = tmp;
            }
        }

        return answer;
    }

}
