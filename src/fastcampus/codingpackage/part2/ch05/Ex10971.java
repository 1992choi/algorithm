package fastcampus.codingpackage.part2.ch05;

import java.util.Scanner;

/*
  풀이
  - 모든 도시를 정확히 한 번씩 방문하고 다시 시작점으로 돌아오는 경로를 완전탐색한다.
  - visited 배열로 방문 여부를 관리하며, 재귀적으로 다음 도시를 선택해 경로를 확장한다.
  - 도시 수 N(최대 10)이 작기 때문에 순열 기반 백트래킹으로 모든 경우를 탐색해도 계산이 가능하다.
  - 마지막에 시작점으로 돌아오는 간선이 존재할 때만 유효한 경로로 처리한다.
*/
class Ex10971 {

    static int n;
    static int[][] w;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = new int[n][n];
        visited = new boolean[n];

        // 비용 행렬 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        // 도시 0에서 시작하는 경우만 탐색 (모든 도시를 한 번씩 방문)
        travel(0, 0, 0, 0);

        System.out.println(answer);
    }

    static void travel(int start, int node, int sum, int cnt) {
        // 모든 도시를 방문한 후, 다시 시작점으로 돌아온 경우
        if (cnt == n && start == node) {
            answer = Math.min(answer, sum);
            return;
        }

        // 다음 도시로 이동
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않았고 간선이 존재하는 경우
            if (!visited[i] && w[node][i] != 0) {
                visited[i] = true;
                travel(start, i, sum + w[node][i], cnt + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
