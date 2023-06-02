package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 하샤드 수 - https://school.programmers.co.kr/learn/courses/30/lessons/12947
public class Ex12947 {

    public static void main(String[] args) {
        System.out.println(solution(10)); // true
        System.out.println(solution(12)); // true
        System.out.println(solution(11)); // false
        System.out.println(solution(13)); // false
    }

    public static boolean solution(int x) {
        return x % (Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum()) == 0;
    }

}
