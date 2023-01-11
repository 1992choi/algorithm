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

}