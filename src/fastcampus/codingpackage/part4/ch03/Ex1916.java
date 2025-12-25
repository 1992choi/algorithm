package fastcampus.codingpackage.part4.ch03;

import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 한 도시에서 다른 도시까지 가는 최소 비용을 구해야 하므로 다익스트라 알고리즘을 사용
    - 방문하지 않은 정점 중 현재까지의 비용이 가장 작은 정점을 선택해 비용을 갱신해 나간다

  - 그래프 표현
    - graph[s][d] : s에서 d로 가는 비용
    - 여러 간선이 있을 수 있으므로 가장 작은 비용만 저장

  - 배열 정의
    - cost[i] : 시작 도시에서 i번 도시까지의 현재까지 알려진 최소 비용
    - visited[i] : i번 도시가 최단 거리 확정되었는지 여부

  - 초기값
    - 시작 도시의 cost는 0
    - 나머지는 INF로 초기화

  - 처리 방식
    - 매 단계마다 방문하지 않은 도시 중 cost가 가장 작은 도시 선택
    - 해당 도시를 기준으로 다른 도시들의 cost를 갱신
    - 더 이상 선택할 도시가 없으면 종료

  - 정답
    - 도착 도시의 cost 값이 최소 비용

  - 시간 복잡도
    - O(N^2)
    - 정점 수가 크지 않으므로 배열 기반 다익스트라로 해결 가능
*/
class Ex1916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int INF = 1000000000;

        int n = sc.nextInt();
        int e = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            cost[i] = INF;
            for (int j = 0; j <= n; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            if (graph[s][d] > c) graph[s][d] = c;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        cost[start] = 0;

        for (int i = 1; i <= n; i++) {
            int min = INF;
            int minIndex = -1;

            for (int j = 1; j <= n; j++) {
                if (!visited[j] && cost[j] < min) {
                    min = cost[j];
                    minIndex = j;
                }
            }

            if (minIndex == -1) break;

            visited[minIndex] = true;

            for (int j = 1; j <= n; j++) {
                if (cost[j] > cost[minIndex] + graph[minIndex][j]) {
                    cost[j] = cost[minIndex] + graph[minIndex][j];
                }
            }
        }

        System.out.println(cost[end]);
    }

}
