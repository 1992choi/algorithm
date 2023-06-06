package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 문자열 내 마음대로 정렬하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class Ex12915 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1))); // ["car", "bed", "sun"]
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 1))); // ["abcd", "abce", "cdx"]
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (x1, x2) -> x1.charAt(n) == x2.charAt(n) ? x1.compareTo(x2) : x1.charAt(n) - x2.charAt(n));
        return strings;
    }

}
