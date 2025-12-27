package fastcampus.codingpackage.part4.ch03;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 이동할 때 비용이 0 또는 1인 그래프에서 최소 비용을 구하는 문제
    - 벽을 부수는 횟수를 최소화하는 것이 곧 최단 경로 문제와 동일
    - 가중치가 0과 1뿐이므로 다익스트라 또는 0-1 BFS로 해결 가능

  - 그래프 모델링
    - graph[r][c] = 0이면 빈 방, 1이면 벽
    - 해당 칸으로 이동할 때의 비용은 graph 값 자체

  - DP 정의
    - cost[r][c] : (r, c) 위치까지 도달하는 데 필요한 최소 벽 파괴 횟수

  - 초기값
    - 시작점 (1, 1)의 비용은 0
    - 나머지는 INF로 초기화

  - 탐색 방식
    - 우선순위 큐를 사용한 다익스트라
    - 현재 위치에서 상하좌우로 이동
    - 다음 칸의 비용은 현재 비용 + graph[nr][nc]

  - 종료 조건
    - (n, m)에 도달했을 때의 최소 비용 출력

  - 시간 복잡도
    - O(N * M log (N * M))
*/
class Ex1261 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int INF = 1000000000;

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] graph = new int[n + 1][m + 1];
        int[][] cost = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = input[j - 1] - '0';
                cost[i][j] = INF;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        pq.offer(new Point(1, 1, 0));
        cost[1][1] = 0;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (cost[now.row][now.col] < now.cost) continue;
            if (now.row == n && now.col == m) break;

            for (int i = 0; i < 4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];

                if (nr < 1 || nr > n || nc < 1 || nc > m) continue;

                if (cost[nr][nc] > cost[now.row][now.col] + graph[nr][nc]) {
                    cost[nr][nc] = cost[now.row][now.col] + graph[nr][nc];
                    pq.offer(new Point(nr, nc, cost[nr][nc]));
                }
            }
        }

        System.out.println(cost[n][m]);
    }

    static class Point {
        int row, col, cost;

        public Point(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

}
