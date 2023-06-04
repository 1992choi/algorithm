package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;

// 프로그래머스 Lv1. 문자열 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12917
public class Ex12917 {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg")); // gfedcbZ
    }

    public static String solution(String s) {
        String[] strings = s.split("");
        Arrays.sort(strings, Comparator.reverseOrder());

        return String.join("", strings);
    }

}
