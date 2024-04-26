package inflearn.lecture01.ex08;

import java.util.Scanner;

public class Ex08_13_02 {

    static int n;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int y, int x) {
        if (arr[y][x] == 1) {
            // 진입점 체크
            arr[y][x] = 0;

            // 북
            if (y > 0 && arr[y - 1][x] == 1) {
                dfs(y - 1, x);
            }

            // 북동
            if (y > 0 && x < n - 1 && arr[y - 1][x + 1] == 1) {
                dfs(y - 1, x + 1);
            }

            // 동
            if (x < n - 1 && arr[y][x + 1] == 1) {
                dfs(y, x + 1);
            }

            // 남동
            if (y < n - 1 && x < n - 1 && arr[y + 1][x + 1] == 1) {
                dfs(y + 1, x + 1);
            }

            // 남
            if (y < n - 1 && arr[y + 1][x] == 1) {
                dfs(y + 1, x);
            }

            // 남서
            if (y < n - 1 && x > 0 && arr[y + 1][x - 1] == 1) {
                dfs(y + 1, x - 1);
            }

            // 서
            if (x > 0 && arr[y][x - 1] == 1) {
                dfs(y, x - 1);
            }

            // 북서
            if (y > 0 && x > 0 && arr[y - 1][x - 1] == 1) {
                dfs(y - 1, x - 1);
            }
        }
    }

}