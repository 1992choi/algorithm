package programmers.lv1;

import java.util.Arrays;

/*
    프로그래머스 Lv1. x만큼 간격이 있는 n개의 숫자
    - https://school.programmers.co.kr/learn/courses/30/lessons/12954
 */
public class Ex12954 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));    // [2, 4, 6, 8, 10]
        System.out.println(Arrays.toString(solution(4, 3)));    // [4, 8, 12]
        System.out.println(Arrays.toString(solution(-4, 2)));   // [-4, -8]
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) x * i;
        }

        return answer;
    }

}
