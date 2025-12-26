package fastcampus.codingpackage.part4.ch03;

import java.util.*;

/*
  풀이

  - 핵심 아이디어
    - 시작 도시에서 도착 도시까지의 최소 비용과 경로를 함께 구해야 한다
    - 다익스트라 알고리즘을 사용하고, 최단 경로 갱신 시 이전 노드를 기록한다

  - 그래프 표현
    - 인접 리스트 사용
    - graph[u] : u에서 출발하는 간선 목록

  - 배열 정의
    - cost[i] : 시작 도시에서 i번 도시까지의 최소 비용
    - path[i] : i번 도시로 오기 직전의 도시 번호

  - 다익스트라 처리
    - 우선순위 큐에 (도시, 현재 비용)을 넣어 최소 비용 정점부터 처리
    - 더 짧은 경로가 발견되면 cost 갱신
    - 이때 path[next]에 현재 도시를 기록하여 경로 추적 가능하게 함

  - 경로 복원
    - 도착 도시부터 시작하여 path 배열을 따라가며 역순으로 경로를 수집
    - 스택을 사용해 출력 시 올바른 순서로 변환

  - 출력
    - 최소 비용
    - 경로에 포함된 도시 개수
    - 실제 이동 경로

  - 시간 복잡도
    - O((N + M) log N)
*/
class Ex11779 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int INF = 1000000000;

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge>[] graph = new List[n + 1];
        int[] cost = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            cost[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            graph[s].add(new Edge(d, c));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Edge(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (cost[now.dist] < now.cost) continue;

            for (Edge next : graph[now.dist]) {
                if (cost[now.dist] + next.cost < cost[next.dist]) {
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                    path[next.dist] = now.dist;
                }
            }
        }

        System.out.println(cost[end]);

        Stack<Integer> stack = new Stack<>();
        int now = end;
        while (now != 0) {
            stack.push(now);
            now = path[now];
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static class Edge {
        int dist, cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }

}
