package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    - 풀이

    1. 이 문제는 BFS로 최단 거리를 구하는 문제이지만,
       "벽을 한 번만 부술 수 있다"는 추가 조건이 있음.

    2. 따라서 visited 배열을 3차원으로 구성한다.
       visited[r][c][0] : 벽을 부수지 않고 (r,c)에 도착한 최단 거리
       visited[r][c][1] : 벽을 부순 후 (r,c)에 도착한 최단 거리

    3. 한 칸 이동 시 경우는 두 가지:
       - (1) 이동할 칸이 빈칸(0) → 지금까지의 부순 상태 그대로 이동
       - (2) 이동할 칸이 벽(1)
             → 이미 벽을 부쉈다면 이동 불가
             → 아직 부수지 않았다면 벽을 부수고 이동하며 상태를 1로 변경

    4. BFS 도중 (n,m)에 처음 도착하는 순간의 값이 최단 거리이므로 바로 출력.

    5. 모든 탐색이 끝날 때까지 도착하지 못하면 -1 출력.
*/
class Ex2206 {

    static int n, m;
    static int[][] board;
    static int[][][] visited; // [r][c][벽 부쉈는지 여부]

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1][2];

        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            for (int j = 1; j <= m; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0));
        visited[1][1][0] = 1; // 벽을 안 부순 상태로 시작

        while (!q.isEmpty()) {
            Point now = q.poll();

            // 도착 지점에 도달하면 바로 출력 (최단 거리 보장)
            if (now.r == n && now.c == m) {
                System.out.println(visited[now.r][now.c][now.isBroken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr <= 0 || nr > n || nc <= 0 || nc > m) continue;

                // 방문하지 않은 상태일 때만 이동 가능
                if (visited[nr][nc][now.isBroken] == 0) {

                    // 이동할 곳이 빈칸일 경우
                    if (board[nr][nc] == 0) {
                        visited[nr][nc][now.isBroken] =
                                visited[now.r][now.c][now.isBroken] + 1;
                        q.add(new Point(nr, nc, now.isBroken));
                    }
                    // 이동할 곳이 벽이고, 아직 벽을 부수지 않은 경우만 가능
                    else if (board[nr][nc] == 1 && now.isBroken == 0) {
                        visited[nr][nc][1] = visited[now.r][now.c][0] + 1;
                        q.add(new Point(nr, nc, 1)); // 벽을 부순 상태로 이동
                    }
                }
            }
        }

        System.out.println(-1); // 끝까지 못 가면 실패
    }

    static class Point {
        int r, c;
        int isBroken; // 0 = 안 부숨, 1 = 부숨

        public Point(int r, int c, int b) {
            this.r = r;
            this.c = c;
            this.isBroken = b;
        }
    }

}
