package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 정수 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12933
public class Ex12933 {

    public static void main(String[] args) {
        System.out.println(solution(118372)); // 873211
    }

    public static long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(ch);
        }

        return Long.parseLong(sb.reverse().toString());
    }

}
