package fastcampus.codingpackage.part4.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 모든 학생이 파티 장소 X까지 갔다가 다시 집으로 돌아오는 최단 시간을 계산한다
    - 각 정점 i에 대해 (i → X) + (X → i) 최단 거리의 합 중 최대값을 구한다

  - 다익스트라 사용 방향
    - 다익스트라는 하나의 시작점에서 모든 정점까지의 최단 거리를 구하는 알고리즘이다
    - X → i 는 X를 시작점으로 한 번의 다익스트라로 계산 가능하다
    - i → X 는 모든 i를 시작점으로 해야 하므로 그대로 하면 N번의 다익스트라가 필요하다

  - 간선 방향을 뒤집는 이유 (backward 그래프)
    - i → X 경로는 간선을 모두 뒤집으면 X → i 경로로 바뀐다
    - 따라서 원래 그래프의 모든 간선을 반대로 뒤집은 그래프에서
      X를 시작점으로 다익스트라를 수행하면 i → X 최단 거리를 한 번에 구할 수 있다
    - 이 방법을 사용하면 다익스트라는 총 2번만 수행하면 된다

  - 동일한 학생이 보장되는 이유
    - 간선을 뒤집더라도 정점(학생 번호)은 그대로 유지된다
    - forwardCost[i] 는 X → i 최단 거리
    - backwardCost[i] 는 간선을 뒤집은 그래프에서의 X → i 최단 거리로,
      원래 그래프 기준 i → X 최단 거리를 의미한다
    - 두 값 모두 동일한 정점 i에 대한 거리이므로 더해도 의미가 섞이지 않는다

  - 그래프 구성
    - forward 그래프: 원래 방향 그래프 (X → i 계산)
    - backward 그래프: 간선을 반대로 뒤집은 그래프 (i → X 계산)

  - 정답 계산
    - 각 정점 i에 대해 forwardCost[i] + backwardCost[i] 값 중 최대값이 정답이다

  - 시간 복잡도
    - 다익스트라 2회 수행
    - O(M log N)
*/
class Ex1238 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt();

        List<Edge>[] forward = new ArrayList[n + 1];
        List<Edge>[] backward = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            forward[i] = new ArrayList<>();
            backward[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt(), d = sc.nextInt(), c = sc.nextInt();
            forward[s].add(new Edge(d, c));
            backward[d].add(new Edge(s, c));
        }

        int[] forwardCost = dijkstra(forward, x);
        int[] backwardCost = dijkstra(backward, x);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, forwardCost[i] + backwardCost[i]);
        }
        System.out.println(ans);
    }

    static int[] dijkstra(List<Edge>[] graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] cost = new int[graph.length];
        final int INF = 1000000000;

        for (int i = 1; i < cost.length; i++) {
            cost[i] = INF;
        }
        cost[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (cost[now.dist] < now.cost) continue;
            for (Edge next : graph[now.dist]) {
                if (cost[next.dist] > cost[now.dist] + next.cost) {
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                }
            }
        }
        return cost;
    }

    static class Edge {
        int dist, cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }

}
