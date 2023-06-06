package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 예산 - https://school.programmers.co.kr/learn/courses/30/lessons/12982
public class Ex12982 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9)); // 3
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10)); // 4
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (int price : d) {
            budget -= price;
            if (budget >= 0) {
                answer++;
            } else {
                return answer;
            }
        }

        return answer;
    }

}
