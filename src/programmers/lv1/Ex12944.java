package programmers.lv1;

import java.util.Arrays;

/*
    프로그래머스 Lv1. 평균 구하기
    - https://school.programmers.co.kr/learn/courses/30/lessons/12944
 */
public class Ex12944 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4})); // 2.5
        System.out.println(solution(new int[]{5, 5})); // 5
    }

    public static double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

}
