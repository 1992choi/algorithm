package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. 최솟값 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12941
public class Ex12941 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4})); // 29
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4})); // 10
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1]; // A의 작은 수와 B의 큰 수를 곱하는 경우가 최솟값을 만들 수 있는 조건.
        }

        return answer;
    }

}
