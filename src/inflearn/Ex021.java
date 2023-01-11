package inflearn;

import java.util.Scanner;

public class Ex021 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] arr = new int[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(count, arr));
        System.out.println(solution2(count, arr));
    }

    public static int solution(int count, int[][] arr) {
        int maxSum = 0;

        int sum;

        // 가로 합 판단
        for (int i = 0; i < count; i++) {
            sum = 0;
            for (int j = 0; j < count; j++) {
                sum += arr[i][j];
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        // 세로 합 판단
        for (int i = 0; i < count; i++) {
            sum = 0;
            for (int j = 0; j < count; j++) {
                sum += arr[j][i];
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        // 대각선 판단 1
        sum = 0;
        for (int i = 0; i < count; i++) {
            sum += arr[i][i];
        }
        if (sum > maxSum) {
            maxSum = sum;
        }

        // 대각선 판단2
        sum = 0;
        for (int i = 0; i < count; i++) {
            sum += arr[count - i - 1][i];
        }
        if (sum > maxSum) {
            maxSum = sum;
        }

        return maxSum;
    }

    public static int solution2(int count, int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        int sum1 = 0; // 행의 합
        int sum2 = 0; // 열의 합

        // 가로, 세로 판단
        for (int i = 0; i < count; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < count; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            maxSum = Math.max(maxSum, sum1);
            maxSum = Math.max(maxSum, sum2);
        }

        // 대각선 판단
        sum1 = 0; // 행의 합
        sum2 = 0; // 열의 합
        for (int i = 0; i < count; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][count - i - 1];
        }
        maxSum = Math.max(maxSum, sum1);
        maxSum = Math.max(maxSum, sum2);

        return maxSum;
    }

}