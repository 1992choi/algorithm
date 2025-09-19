package fastcampus.codingpackage.part1.ch04;

import java.util.Scanner;

public class Ex3085 {

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

/*
    풀이
    - 전체흐름
      - 가능한 모든 쌍의 사탕을 서로 교환 > 가장 긴 연속 부분의 행/열 찾기 > 교환한 사탕 원복
    - 교환 팁
      - 상하좌우의 사탕과 다른 사탕일 경우, 모두 교환이 가능하지만 굳이 모든 케이스를 확인할 필요는 없다.
        - 그 이유는 만약 왼쪽 사탕과 변경한다고 했을 때, 왼쪽 사탕의 대상이 자기 자신이었을 수도 있기 때문 (= AB 가 있을 때 A가 기준이고, B로 교환은 B가 기준이어서 왼쪽인 A랑 바꾸는 것과 동일한 결과를 반환함)
        - 그렇기 때문에 네 방향을 모두 확인할 필요없고, 증가하는 두 방향만 확인하면 된다.

    public static int calcScore(char[][] map) {
        int N = map.length;
        int maxScore = 0;
        // 가장 긴 연속 column 길이 찾기
        for (int r = 0; r < N; r++) {
            int scr = 1;
            for (int c = 1; c < N; c++) {
                if (map[r][c] == map[r][c - 1]) scr++;
                else {
                    maxScore = Math.max(maxScore, scr);
                    scr = 1;
                }
            }
            maxScore = Math.max(maxScore, scr);
        }
        // 가장 긴 연속 row 길이 찾기
        for (int c = 0; c < N; c++) {
            int scr = 1;
            for (int r = 1; r < N; r++) {
                if (map[r][c] == map[r - 1][c]) scr++;
                else {
                    maxScore = Math.max(maxScore, scr);
                    scr = 1;
                }
            }
            maxScore = Math.max(maxScore, scr);
        }
        return maxScore;
    }

    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++){
                // swap right
                if (j + 1 < N) {
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, calcScore(map));
                    swapCandy(map, i, j, i, j + 1);
                }
                // swap below
                if (i + 1 < N) {
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, calcScore(map));
                    swapCandy(map, i, j, i + 1, j);
                }
            }
        System.out.println(ans);
    }
 */