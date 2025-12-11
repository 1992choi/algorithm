package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - 여러 개의 익은 토마토(1)를 BFS의 시작점으로 동시에 넣어서 진행하는 것이 핵심.
    - visited[][]에는 익기까지 걸린 날짜를 기록하며, 처음 익은 토마토를 1일로 두기 때문에 마지막에 -1을 해줌.
    - BFS로 전파된 위치가 board == 0(익지 않은 토마토)일 때만 visited 갱신.
    - BFS 종료 후 visited == 0 && board == 0 인 곳이 남아 있다면 절대 익지 못한 토마토 → -1 출력.
*/
class Ex7576 {

    static int n, m;
    static int[][] board;
    static int[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        visited = new int[n][m];

        Queue<Point> q = new LinkedList<>();

        // 여러 개의 시작점(익은 토마토)을 BFS 초기값으로 설정 (핵심 아이디어)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    q.add(new Point(i, j));
                    visited[i][j] = 1;   // 처음 익은 토마토를 1로 두므로 출력 시 -1
                }
            }
        }

        // BFS 확산 (익힐 수 있는 토마토만 전파)
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                // 방문 X + 익지 않은 토마토만 익힘
                if (visited[nr][nc] == 0 && board[nr][nc] == 0) {
                    visited[nr][nc] = visited[now.r][now.c] + 1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        int max = 0;
        boolean complete = true;

        // 익지 못한 토마토가 있는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, visited[i][j]);
                if (visited[i][j] == 0 && board[i][j] == 0) {
                    complete = false;
                    break;
                }
            }
        }

        if (complete) System.out.println(max - 1);
        else System.out.println(-1);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
