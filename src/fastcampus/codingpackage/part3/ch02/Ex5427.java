package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - 불(Fire) 확산 시간을 먼저 BFS로 계산하는 이유
      → 사람 이동 판단의 기준이 되기 때문이다.
      → 사람이 어떤 칸에 't초'에 도착할 때, 불이 그 칸에 이미 t초 이하로 도착했다면 이동할 수 없다.
      → 따라서 "불이 각 칸에 언제 도달하는지"가 먼저 계산되어 있어야 사람이 이동할 때 정확한 비교가 가능하다.

    - 사람 이동 시 조건 비교 방식
      → 사람이 현재 시점(nowTime = visited[now] )에서 다음 칸(next)에 이동하려 할 때
         fire[next] 와 비교하여 다음 2가지 경우만 이동 가능:
         1) fire[next] == 0        : 아직 불이 안 번짐
         2) fire[next] > nowTime+1 : 불이 더 늦게 도착함 → 사람이 먼저 도착 가능

      즉, "사람이 도착하는 시간 < 불이 도착하는 시간" 을 만족해야만 이동할 수 있다.

    - 방문 배열 visited[][]는 사람이 '몇 초에 도착했는지'를 기록한다.
      fire[][]는 '불이 몇 초에 도착했는지'를 기록한다.
      두 배열의 시간 비교를 통해 안전 여부를 판단한다.
*/

class Ex5427 {

    static int[][] visited;
    static int[][] fire;
    static int n, m;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            visited = new int[m][n];
            fire = new int[m][n];
            Queue<Point> q = new LinkedList<>();
            Queue<Point> fireQ = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                String line = sc.next();
                for (int j = 0; j < n; j++) {
                    char c = line.charAt(j);
                    if (c == '#') {
                        fire[i][j] = visited[i][j] = -1;
                    } else if (c == '@') {
                        q.add(new Point(i, j));
                        visited[i][j] = 1;
                    } else if (c == '*') {
                        fireQ.add(new Point(i, j));
                        fire[i][j] = 1;
                    }
                }
            }

            // 불 확산 시간을 먼저 BFS로 기록한다
            while (!fireQ.isEmpty()) {
                Point now = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    if (isOutOfRange(nr, nc)) continue;
                    if (fire[nr][nc] == 0) {
                        fire[nr][nc] = fire[now.r][now.c] + 1;
                        fireQ.add(new Point(nr, nc));
                    }
                }
            }

            boolean isEscaped = false;
            while (!q.isEmpty()) {
                Point now = q.poll();

                if (isExit(now.r, now.c)) {
                    System.out.println(visited[now.r][now.c]);
                    isEscaped = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (isOutOfRange(nr, nc)) continue;
                    if (visited[nr][nc] != 0) continue;

                    // 사람 도착 시간보다 불 도착이 더 늦어야 하거나, 아직 불이 없을 때만 이동 허용
                    if (fire[nr][nc] == 0 || fire[nr][nc] > visited[now.r][now.c] + 1) {
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                        q.add(new Point(nr, nc));
                    }
                }
            }

            if (!isEscaped) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static boolean isOutOfRange(int r, int c) {
        return r < 0 || r >= m || c < 0 || c >= n;
    }

    static boolean isExit(int r, int c) {
        return r == 0 || r == m - 1 || c == 0 || c == n - 1;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
