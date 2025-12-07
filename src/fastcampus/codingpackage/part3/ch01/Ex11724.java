package fastcampus.codingpackage.part3.ch01;

import java.util.Scanner;

/*
    풀이

    - 주어진 무방향 그래프에서 연결 요소(Connected Component)의 개수를 구하는 문제
    - 그래프를 인접행렬로 구성하고, 방문 배열을 이용해 각 노드를 탐색
    - 1번부터 n번 노드까지 순회하며, 아직 방문하지 않은 노드를 발견하면
      → 해당 노드가 새로운 연결 요소의 시작점
      → DFS 수행 후 연결 요소 개수(cnt) 증가
    - DFS는 현재 노드를 방문 처리 후 인접한 노드를 재귀적으로 탐색
    - DFS가 한 번 끝날 때마다 하나의 연결 요소가 완성됨
*/
class Ex11724 {

    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 방문하지 않은 노드는 새로운 연결 요소
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}