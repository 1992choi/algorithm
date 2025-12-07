package fastcampus.codingpackage.part3.ch01;

import java.util.Scanner;

/*
    풀이

    - 바이러스 전염 문제로, 1번 컴퓨터와 연결된 모든 컴퓨터의 수를 구하는 문제
    - 그래프를 인접행렬로 구성 후, DFS를 통해 1번 컴퓨터에서 연결된 노드를 모두 탐색
    - DFS는 방문할 때마다 cnt를 증가시키고, 인접한 노드 중 방문하지 않은 노드를 재귀적으로 탐색
    - cnt에는 1번 컴퓨터 자신도 포함되므로, 실제 감염된 컴퓨터 수는 cnt - 1
*/
class Ex2606 {

    static int v, e;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        graph = new int[v + 1][v + 1];
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

        dfs(1);
        System.out.println(cnt - 1);
    }

    public static void dfs(int node) {
        visited[node] = true;
        cnt++;
        for (int i = 1; i <= v; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}