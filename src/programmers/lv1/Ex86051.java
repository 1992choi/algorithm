package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 없는 숫자 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class Ex86051 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0})); // 14
        System.out.println(solution(new int[]{5, 8, 4, 0, 6, 7, 9})); // 6
    }

    public static int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

}
