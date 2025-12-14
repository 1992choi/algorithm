package fastcampus.codingpackage.part3.ch03;

import java.util.Scanner;

/*
    풀이

    - 입력이 순열로 주어지므로 (1 ~ n의 숫자가 정확히 1번씩 등장)
      모든 노드는 진입차수 1, 진출차수 1을 가진다.
      즉, 모든 노드는 정확히 한 곳으로 향하고, 정확히 한 노드로부터 도착한다.

    - index와 value가 1:1 매핑이므로
      어떤 노드에서 출발해도 언젠가 반드시 다시 방문하게 되어
      사이클이 무조건 존재한다. (트리처럼 뻗어나갈 수 없음)

    - 따라서 "어떤 노드가 속한 연결 구조"는 반드시 하나의 유일한 사이클을 포함하며,
      사이클 판정을 위한 별도 구조(예: 간선 수 비교, 진입차수 체크 등)를 구현할 필요가 없다.
      DFS 한 번만으로 방문 경로 상에서 재방문이 일어나는 시점이 곧 사이클의 시작이다.

    - depth[]는 다음을 위해 사용된다:
        1) DFS 방문 순서 기록
        2) 방문 중인 경로인지 판별 (depth가 0보다 크고 탐색 중)
        3) 재방문 발생 시, 사이클 길이를 계산하기 위한 기준값 제공

    - DFS 종료 후 depth[node] = 100001로 설정하는 이유:
        - depth는 방문 순서가 1 ~ n 범위를 가진다.
        - 문제 조건에서 n ≤ 100000 이므로 depth는 절대 100001이 될 수 없다.
        - 따라서 100001은 "DFS가 완전히 끝난 노드를 다시 탐색하지 않도록 하는 마킹 값"으로 적절하다.
        - 이 값 덕분에:
            * 이미 DFS로 사이클 판정까지 끝난 노드를 다시 방문하지 않음
            * 불필요한 중복 DFS 방지 → 시간 단축
            * depth의 의미(양수=방문순서)를 해치지 않아 로직이 깔끔해짐

    - dfs(node)의 리턴값은 사이클의 길이이며,
      main에서는 n - (모든 사이클 길이의 합)을 출력하여
      팀을 구성하지 못한(사이클에 속하지 않은) 학생 수를 구한다.
*/
class Ex9466 {

    static int[] nextNode;
    static int[] depth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            nextNode = new int[n + 1];
            depth = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                nextNode[i] = sc.nextInt();
                depth[i] = 0;
            }

            int totalCycleCount = 0;

            for (int i = 1; i <= n; i++) {
                if (depth[i] == 0) {
                    depth[i] = 1;
                    totalCycleCount += dfs(i);
                }
            }

            System.out.println(n - totalCycleCount);
        }
    }

    public static int dfs(int nodeNum) {
        int next = nextNode[nodeNum];
        int cycleCount = 0;

        if (depth[next] == 0) {
            depth[next] = depth[nodeNum] + 1;
            cycleCount = dfs(next);
        } else {
            cycleCount = depth[nodeNum] - depth[next] + 1;
        }

        depth[nodeNum] = 100001;

        return cycleCount < 0 ? 0 : cycleCount;
    }

}
