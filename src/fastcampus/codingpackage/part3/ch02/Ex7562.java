package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - 체스판에서 나이트(knight)가 한 점에서 다른 점까지 이동하는 최소 이동 횟수를 구하는 BFS 문제.
    - 나이트는 총 8개의 방향으로 이동할 수 있다.
    - 방문 배열 visited[][]에 "이동 횟수 + 1"을 기록하여 방문 여부와 이동 거리를 동시에 관리한다.
      → visited[start] = 1 로 시작하므로, 실제 이동 횟수는 visited[end] - 1

    - BFS는 최단 경로 탐색에 적합하며, 목표 지점(end)에 처음 도달하는 순간이 최소 이동 횟수가 된다.
    - 그러므로 now == end 체크 시 즉시 종료 가능.

    - 매 테스트 케이스마다 새로운 board, visited 배열을 초기화하고, 시작점을 큐에 추가하여 BFS를 진행한다.
*/
class Ex7562 {

    static int n;
    static int[][] board;
    static int[][] visited;

    // 나이트의 8가지 이동 방향
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt(); // 테스트 케이스 수
        for (int t = 0; t < tc; t++) {
            n = sc.nextInt();
            board = new int[n][n];
            visited = new int[n][n];

            Point start = new Point(sc.nextInt(), sc.nextInt());
            Point end = new Point(sc.nextInt(), sc.nextInt());

            Queue<Point> q = new LinkedList<>();
            q.add(start);
            visited[start.r][start.c] = 1;   // 이동 횟수 0을 의미

            while (!q.isEmpty()) {
                Point now = q.poll();

                // BFS 특성상 첫 도달이 최단 거리 → 즉시 종료 가능
                if (now.r == end.r && now.c == end.c) {
                    System.out.println(visited[end.r][end.c] - 1); // 실제 이동 횟수
                    break;
                }

                // 나이트의 8방향 이동
                for (int i = 0; i < 8; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (visited[nr][nc] == 0) {
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                        q.add(new Point(nr, nc));
                    }
                }
            }
        }
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
