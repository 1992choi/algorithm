package programmers.lv1;

import java.util.Arrays;

/*
    프로그래머스 Lv1. 평균 구하기
    - https://school.programmers.co.kr/learn/courses/30/lessons/12944
 */
public class Ex12944 {

    public static void main(String[] args) {
        System.out.println(solution1(new int[]{1, 2, 3, 4})); // 2.5
        System.out.println(solution1(new int[]{5, 5})); // 5

        System.out.println(solution2(new int[]{1, 2, 3, 4})); // 2.5
        System.out.println(solution2(new int[]{5, 5})); // 5

        System.out.println(solution3(new int[]{1, 2, 3, 4})); // 2.5
        System.out.println(solution3(new int[]{5, 5})); // 5
    }

    public static double solution1(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static double solution2(int[] arr) {
        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }

    public static double solution3(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

}
