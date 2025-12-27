package fastcampus.codingpackage.part4.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 시작점 1에서 도착점 n까지 이동하되 반드시 v1과 v2를 모두 거쳐야 한다
    - v1, v2의 방문 순서는 두 가지 경우만 존재
      - 1 → v1 → v2 → n
      - 1 → v2 → v1 → n
    - 두 경로 모두 다익스트라로 계산한 뒤 더 작은 값을 정답으로 선택

  - 접근 방식
    - 다익스트라를 여러 번 호출하여 구간별 최단 거리 계산
    - 각 구간이 하나라도 도달 불가능하면 해당 경로는 무효 처리

  - 왜 이 방식이 가능한가
    - 그래프는 양방향이고 가중치는 모두 양수
    - 특정 정점을 반드시 지나야 하는 최단 경로 문제는 구간 분할이 가능

  - 주의 사항
    - 구간 중 하나라도 INF 이상이면 전체 경로는 불가능
    - 두 경우 모두 불가능하면 -1 출력

  - 시간 복잡도
    - 다익스트라 3회 × 2가지 경우
    - O(E log V)
*/
class Ex1504 {

    static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            graph[s].add(new Edge(d, c));
            graph[d].add(new Edge(s, c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int answer1 =
                dijkstra(graph, 1, v1)
                        + dijkstra(graph, v1, v2)
                        + dijkstra(graph, v2, n);

        int answer2 =
                dijkstra(graph, 1, v2)
                        + dijkstra(graph, v2, v1)
                        + dijkstra(graph, v1, n);

        int answer = Math.min(answer1, answer2);

        if (answer >= INF) System.out.println(-1);
        else System.out.println(answer);
    }

    static int dijkstra(List<Edge>[] graph, int start, int end) {
        int[] cost = new int[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

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

        return cost[end];
    }

    static class Edge {
        int dist;
        int cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }

}
