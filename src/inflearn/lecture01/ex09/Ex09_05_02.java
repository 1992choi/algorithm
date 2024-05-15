package inflearn.lecture01.ex09;

import java.util.*;

/**
 *  문제해법 보고 푼 문제.
 */
public class Ex09_05_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 정점의 수
        int m = in.nextInt(); // 간선의 수

        // 비용을 담을 배열
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        // 정점과 간선 정보
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(in.nextInt()).add(new Edge(in.nextInt(), in.nextInt()));
        }

        /** 계산 Start */
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 1번 정점 계산
        queue.offer(new Edge(1, 0));
        dis[1] = 0;

        while(!queue.isEmpty()) {
            Edge tmp = queue.poll(); // Cost 비용이 가장 작은 값 꺼내기
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) { // Queue에서 나온 값이 이미 계산된 값보다 클 경우, 계산할 필요가 없으므로 Skip
                continue;
            }

            for (Edge ob : graph.get(now)) { // now 정점과 연간된 정점 정보 계산(Ex. now가 1이라면, 1에서 2번 정점과 1에서 3번 정점에 대한 계산)
                if (dis[ob.vex] > nowCost + ob.cost) { // 계산된 비용이 기존에 가지고 있던 비용보다 작다면 갱신
                    dis[ob.vex] = nowCost + ob.cost;
                    queue.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
        /** 계산 End */

        // 최소비용 출력
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vex; // 정점
        int cost; // 가중치

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}