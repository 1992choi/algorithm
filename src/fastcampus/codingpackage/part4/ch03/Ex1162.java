package fastcampus.codingpackage.part4.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 도로를 최대 K번까지 포장하여 비용을 0으로 만들 수 있는 최단 경로 문제
    - 단순 최단 경로가 아니라, "포장을 몇 번 사용했는지" 상태까지 함께 관리해야 한다
    - 다익스트라 알고리즘을 상태 확장 형태로 적용한다

  - 그래프 모델링
    - 양방향 그래프
    - Edge는 (도착 정점, 도로 비용)으로 구성

  - 상태 정의
    - (정점 번호, 포장 사용 횟수)
    - 같은 정점이라도 포장 사용 횟수가 다르면 서로 다른 상태로 취급

  - DP 정의
    - cost[i][j] : i번 정점에 j번 포장을 사용하여 도착했을 때의 최소 비용

  - 초기값
    - 시작 정점 1에서 포장 사용 0번 상태의 비용은 0
    - 나머지는 INF로 초기화

  - 다익스트라 처리
    - 우선순위 큐에는 (정점, 누적 비용, 포장 사용 횟수)를 저장
    - 일반 이동: 포장을 사용하지 않고 비용을 더해 이동
    - 포장 이동: 포장을 1회 사용하여 비용 없이 이동

  - 정답
    - 도착 정점 n에 대해 포장 사용 횟수 0 ~ K 중 최소 비용 선택

  - 시간 복잡도
    - O((N + M) log (N * K))
*/
class Ex1162 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final long INF = Long.MAX_VALUE / 2;

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Edge>[] graph = new List[n + 1];
        long[][] cost = new long[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j <= k; j++) {
                cost[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            graph[s].add(new Edge(d, c, 0));
            graph[d].add(new Edge(s, c, 0));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o1.cost, o2.cost);
        });

        pq.offer(new Edge(1, 0, 0));
        cost[1][0] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (cost[now.dist][now.cnt] < now.cost) continue;

            for (Edge next : graph[now.dist]) {

                // 포장을 사용하지 않고 이동하는 경우
                if (cost[next.dist][now.cnt] > cost[now.dist][now.cnt] + next.cost) {
                    cost[next.dist][now.cnt] = cost[now.dist][now.cnt] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist][now.cnt], now.cnt));
                }

                // 포장을 사용하여 비용 없이 이동하는 경우
                if (now.cnt + 1 <= k && cost[next.dist][now.cnt + 1] > cost[now.dist][now.cnt]) {
                    cost[next.dist][now.cnt + 1] = cost[now.dist][now.cnt];
                    pq.offer(new Edge(next.dist, cost[next.dist][now.cnt + 1], now.cnt + 1));
                }
            }
        }

        long ans = INF;
        for (int i = 0; i <= k; i++) {
            ans = Math.min(ans, cost[n][i]);
        }

        System.out.println(ans);
    }

    static class Edge {
        int dist;
        long cost;
        int cnt;

        public Edge(int dist, long cost, int cnt) {
            this.dist = dist;
            this.cost = cost;
            this.cnt = cnt;
        }
    }

}
