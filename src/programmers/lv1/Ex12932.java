package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 자연수 뒤집어 배열로 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class Ex12932 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345))); // [5,4,3,2,1]
    }

    public static int[] solution(long n) {
        return Arrays.stream(new StringBuffer(String.valueOf(n))
                .reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
    }

}
