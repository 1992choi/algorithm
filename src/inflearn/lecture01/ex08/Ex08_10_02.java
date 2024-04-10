package inflearn.lecture01.ex08;

import java.util.Scanner;

public class Ex08_10_02 {

    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        map = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = in.nextInt();
            }
        }

        // 탐색
        map[0][0] = 1;
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        if (x == 6 && y == 6) {
            answer++;
        } else {
            // 동
            if (x < 6 && map[x + 1][y] == 0) {
                map[x + 1][y] = 1;
                dfs(x + 1, y);
                map[x + 1][y] = 0;
            }

            // 서
            if (x > 0 && map[x - 1][y] == 0) {
                map[x - 1][y] = 1;
                dfs(x - 1, y);
                map[x - 1][y] = 0;
            }

            // 남
            if (y < 6 && map[x][y + 1] == 0) {
                map[x][y + 1] = 1;
                dfs(x, y + 1);
                map[x][y + 1] = 0;
            }

            // 북
            if (y > 0 && map[x][y - 1] == 0) {
                map[x][y - 1] = 1;
                dfs(x, y - 1);
                map[x][y - 1] = 0;
            }
        }
    }

}