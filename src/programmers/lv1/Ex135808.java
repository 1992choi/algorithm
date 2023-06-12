package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 과일 장수 - https://school.programmers.co.kr/learn/courses/30/lessons/135808
public class Ex135808 {

    public static void main(String[] args) {
        System.out.println(solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1})); // 8
        System.out.println(solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2})); // 33
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        int rightPoint = score.length - 1;
        int leftPoint = rightPoint - m + 1;

        while (leftPoint >= 0) {
            answer += score[leftPoint] * m;
            rightPoint -= m;
            leftPoint -= m;
        }

        return answer;
    }

}