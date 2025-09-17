package fastcampus.codingpackage.part1.ch04;

import java.util.Scanner;

public class Ex3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int max = 1;

        // 가로 인접 교환 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(board, i, j, i, j + 1);
                max = Math.max(max, getMaxCount(board, n));
                swap(board, i, j, i, j + 1);
            }
        }

        // 세로 인접 교환 검사
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(board, i, j, i + 1, j);
                max = Math.max(max, getMaxCount(board, n));
                swap(board, i, j, i + 1, j);
            }
        }

        System.out.println(max);
        sc.close();
    }

    private static void swap(char[][] b, int r1, int c1, int r2, int c2) {
        char tmp = b[r1][c1];
        b[r1][c1] = b[r2][c2];
        b[r2][c2] = tmp;
    }

    public static int getMaxCount(char[][] board, int n) {
        int maxCount = 1;

        // 행 검사
        for (int i = 0; i < n; i++) {
            int sameCount = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    sameCount++;
                } else {
                    maxCount = Math.max(maxCount, sameCount);
                    sameCount = 1;
                }
            }
            maxCount = Math.max(maxCount, sameCount);
        }

        // 열 검사
        for (int j = 0; j < n; j++) {
            int sameCount = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    sameCount++;
                } else {
                    maxCount = Math.max(maxCount, sameCount);
                    sameCount = 1;
                }
            }
            maxCount = Math.max(maxCount, sameCount);
        }

        return maxCount;
    }
    
}
