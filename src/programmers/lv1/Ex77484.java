package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 로또의 최고 순위와 최저 순위 - https://school.programmers.co.kr/learn/courses/30/lessons/77484
public class Ex77484 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}))); // [3, 5]
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}))); // [1, 6]
        System.out.println(Arrays.toString(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}))); // [1, 1]
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int eqCnt = 0; // 맞은 수
        int zeroCnt = 0; // 0 개수

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
                continue;
            }

            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    eqCnt++;
                    break;
                }
            }
        }

        return new int[]{7 - Math.max(eqCnt + zeroCnt, 1), 7 - Math.max(eqCnt, 1)};
    }

}
