package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 제일 작은 수 제거하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12935
public class Ex12935 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1}))); // [4,3,2]
        System.out.println(Arrays.toString(solution(new int[]{10}))); // [-1]
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(x -> x != min).toArray();
    }

}
