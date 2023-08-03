package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_09_Answer {

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
    }

    public static int solution(int count, int[][] arr) {
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