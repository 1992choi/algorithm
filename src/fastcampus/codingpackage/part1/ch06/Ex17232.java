package fastcampus.codingpackage.part1.ch06;

import java.util.Scanner;

public class Ex17232 {

    /*
        풀이
        - 각 스텝마다 근처의 생명들이 존재하는지 확인하면 시간초과. 따라서 누적합을 활용하여 문제를 해결해야한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        char[][] map = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String rowMap = sc.next();
            for (int j = 1; j <= M; j++)
                map[i][j] = rowMap.charAt(j - 1);
        }

        while (T-- > 0) {
            // 누적합 계산
            int[][] acc = getPrefixSum(map);
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(acc, i, j, K);
                    if (map[i][j] == '*') {
                        nearAlive--;
                        if (nearAlive < A || B < nearAlive)
                            map[i][j] = '.';
                    } else if (A < nearAlive && nearAlive <= B)
                        map[i][j] = '*';
                }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }

    // 매 시간마다 현재 생명에 대한 누적합 계산
    static int[][] getPrefixSum(char[][] map) {
        int N = map.length - 1;
        int M = map[0].length - 1;
        int[][] acc = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++) {
                int alive = (map[i][j] == '*' ? 1 : 0);
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + alive;
            }
        return acc;
    }

    // 누적합을 통해 조건 판단
    static int getRangeSum(int[][] acc, int r, int c, int K) {
        // 범위를 넘어갈 수도 있으니, Math.max()를 활용하여 범위를 제한한다.
        int r1 = Math.max(r - K, 1);
        int c1 = Math.max(c - K, 1);
        int r2 = Math.min(r + K, acc.length - 1);
        int c2 = Math.min(c + K, acc[0].length - 1);
        return acc[r2][c2] - acc[r1 - 1][c2] - acc[r2][c1 - 1] + acc[r1 - 1][c1 - 1];
    }

}