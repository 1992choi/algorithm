package doit;

import java.util.Arrays;

public class Ex002 {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{40, 80, 60})); // 75.0
        System.out.println(solution(3, new int[]{10, 20, 30})); // 66.666667
        System.out.println(solution(4, new int[]{1, 100, 100, 100})); // 75.25
        System.out.println(solution(5, new int[]{1, 2, 4, 8, 16})); // 38.75
        System.out.println(solution(2, new int[]{3, 10})); // 65.0
    }

    public static double solution(int count, int[] score) {
        int max = Arrays.stream(score).max().getAsInt();
        double sum = 0;

        for (int i = 0; i < count; i++) {
            sum += (double)score[i] / max * 100;
        }

        return sum / count;
    }

}
