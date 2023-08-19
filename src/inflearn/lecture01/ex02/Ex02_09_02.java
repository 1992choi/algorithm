package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_09_02 {

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
        int rightDiagonalSum = 0; // 우측대각선 합
        int leftDiagonalSum = 0; // 좌측대각선 합
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;

        for (int i = 0; i < count; i++) {
            int rowSum = 0; // 행 합
            int colSum = 0; // 열 합
            for (int j = 0; j < count; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];

                if (i == j) {
                    rightDiagonalSum += arr[i][j];
                }
                if (i == count - j - 1) {
                    leftDiagonalSum += arr[i][j];
                }
            }
            maxRow = Math.max(maxRow, rowSum);
            maxCol = Math.max(maxCol, colSum);
        }

        return Math.max(rightDiagonalSum, Math.max(leftDiagonalSum, Math.max(maxRow, maxCol)));
    }

}