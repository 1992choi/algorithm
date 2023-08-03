package inflearn.lecture02.ex05;

import java.util.Arrays;

public class Ex05_04 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[]{1, 3, 2}, new int[]{2, 3, 2})); // 8
        System.out.println(solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1})); // 11
        System.out.println(solution(new int[]{1, 1, 1}, new int[]{7, 3, 2})); // 8
        System.out.println(solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7})); // 54
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6})); // 29
    }

    public static int solution(int[] plantTime, int[] growTime) {
        int answer = 0;

        // 2차원 배열에 심는 시간, 자라나는 시간으로 짝을 지어 작성
        int[][] list = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; i++) {
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }

        // 성장 시간이 짧은 항목이 뒤에 위치되도록 정렬
        Arrays.sort(list, (x1, x2) -> x2[1] - x1[1]);

        // 최단시간 구하기
        int s = 0;
        int e = 0;
        for (int[] ints : list) {
            e = s + ints[0] + ints[1];
            answer = Math.max(answer, e);
            s += ints[0];
        }

        return answer;
    }

}
