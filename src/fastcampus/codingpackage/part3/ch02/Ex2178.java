package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - 방문 시 visited[nr][nc] = visited[now] + 1 로 거리 누적 후 큐에 추가한다.
      - visited를 단순히 방문여부로 쓰는 것이 아니라 거리에 대한 누적합을 쓰는 것이 포인트 (그렇지 않으면 별도 변수가 필요)
*/
class Ex2178 {
    static int n, m;
    static int[][] maze;
    static int[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            for (int j = 1; j <= m; j++) {
                maze[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        visited[1][1] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nc <= 0 || nc > m || nr <= 0 || nr > n) continue;
                if (visited[nr][nc] == 0 && maze[nr][nc] == 1) {
                    visited[nr][nc] = visited[now.r][now.c] + 1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        System.out.println(visited[n][m]);
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}

