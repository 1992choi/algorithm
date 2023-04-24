package inflearn.lecture01;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex09_08_Answer {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();

            // 무방향이므로 양쪽 관계를 다 정의해야한다.
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int ev = tmp.vex;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for (Edge ob : graph.get(ev)) { // 연결된 간선 탐색
                    if (ch[ob.vex] == 0) { // 채택되지 않은 간선은 큐에 추가
                        pQ.offer(new Edge(ob.vex, ob.cost));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        public int vex;
        public int cost;

        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }

}
