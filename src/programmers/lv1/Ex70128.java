package programmers.lv1;

import java.util.stream.IntStream;

// 프로그래머스 Lv1. 내적 - https://school.programmers.co.kr/learn/courses/30/lessons/70128
public class Ex70128 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4},new int[]{-3, -1, 0, 2})); // 3
        System.out.println(solution(new int[]{-1,0,1},new int[]{1,0,-1})); // -2
    }

    public static int solution(int[] a, int[] b) {
//        int answer = 0;
//        for (int i = 0; i < a.length; i++) {
//            answer += a[i] * b[i];
//        }
//
//        return answer;

        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }

}
