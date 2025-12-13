package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    - 풀이

    1. 기본 구조는 BOJ 2206(벽 1개 부수기)와 동일하지만,
       이번 문제는 "벽을 최대 k개까지 부술 수 있다"는 점만 다름.

    2. 따라서 visited 배열을 [r][c][부순 벽 개수] 형태로 구성한다.
       visited[r][c][x] : 벽을 x개 부수고 (r,c)에 도착한 최단 거리

    3. BFS 탐색 시 이동 조건은 다음과 같다.
       - 이동할 곳이 빈칸(0) → 현재 부순 개수 그대로 이동
       - 이동할 곳이 벽(1)
           → 부순 개수(now.isBroken)가 k보다 작아야 부술 수 있음
           → 벽을 부쉈다면 visited[nr][nc][now.isBroken + 1]에 기록

    4. visited를 통해 같은 좌표라도 "부순 개수"가 다를 경우를 구분하며
       독립적인 BFS 상태로 저장해야 한다.

    5. 도착 지점에 가장 먼저 도달한 결과가 최단거리므로 즉시 출력.
       끝까지 도달하지 못하면 -1 출력.
*/
class Ex14442 {

    static int n, m, k;
    static int[][] board;
    static int[][][] visited; // [행][열][부순 벽 개수]

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        board = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            for (int j = 1; j <= m; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0));
        visited[1][1][0] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            // 도착하면 최단거리이므로 즉시 종료
            if (now.r == n && now.c == m) {
                System.out.println(visited[now.r][now.c][now.isBroken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr <= 0 || nr > n || nc <= 0 || nc > m) continue;

                // 아직 이 상태(부순 개수)로 방문하지 않은 경우만 진행
                if (visited[nr][nc][now.isBroken] == 0) {
                    // 빈칸 → 그대로 이동
                    if (board[nr][nc] == 0) {
                        visited[nr][nc][now.isBroken] = visited[now.r][now.c][now.isBroken] + 1;
                        q.add(new Point(nr, nc, now.isBroken));
                    }

                    // 벽 → 아직 부술 수 있을 때만
                    else if (board[nr][nc] == 1 && now.isBroken < k && visited[nr][nc][now.isBroken + 1] == 0) {
                        visited[nr][nc][now.isBroken + 1] = visited[now.r][now.c][now.isBroken] + 1;
                        q.add(new Point(nr, nc, now.isBroken + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Point {
        int r, c;
        int isBroken; // 지금까지 부순 벽 개수

        public Point(int r, int c, int b) {
            this.r = r;
            this.c = c;
            this.isBroken = b;
        }
    }

}
