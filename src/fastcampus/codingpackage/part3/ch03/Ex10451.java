package fastcampus.codingpackage.part3.ch03;

import java.util.Scanner;

/*
    풀이

    - 입력이 '순열(permutation)'로 주어짐
      → 1~n까지 숫자가 정확히 한 번씩 등장하며, index와 value가 1:1로 매핑됨
      → nextNode[i]는 i가 가리키는 '단 하나의 노드'이며,
        동시에 모든 노드는 정확히 '한 노드로부터만' 진입됨

    - 이 구조로 인해 다음의 성질이 항상 성립함:
      1) 모든 노드의 진입차수 = 1, 진출차수 = 1
         → 그래프상에서 고립된 노드는 절대 존재할 수 없음

      2) 임의의 노드에서 nextNode를 따라가면 반드시 순환 구조(사이클)를 다시 만나게 됨
         → n개의 노드가 있고, 모두 정확히 1개의 다음 노드만 가지므로
           무한히 진행할 수 없고 결국 방문했던 노드로 되돌아올 수밖에 없음

      3) 모든 노드가 반드시 사이클에 속함
         → 순열 구조상 트리 형태의 가지가 존재할 수 없음
         → 즉, 사이클이 여러 개 존재할 수는 있어도, "사이클에 속하지 않는 노드"는 절대 존재하지 않음

    - 따라서 중요한 결론:
      "사이클을 직접 탐지하는 따로 복잡한 코드를 구현할 필요가 없다"
      방문하지 않은 노드에서 DFS/BFS를 시작하면, 순열 특성상 그 탐색은 반드시 하나의 사이클을 포함한 연결 구성요소를 방문하게 되고 종료된다.
      → 즉, DFS를 한 번 시작하면 사이클 하나를 찾은 것과 동일하게 취급할 수 있다.

    - 핵심 아이디어:
      - 방문하지 않은 노드에서 DFS를 시작할 때마다 사이클이 하나 존재한다고 보고 cnt++ 증가
      - DFS는 그 사이클과 그로 이어지는 경로 전체를 방문 처리해주므로, 중복 계산이 발생하지 않음
*/
class Ex10451 {

    static int[] nextNode;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            nextNode = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                nextNode[i] = sc.nextInt();
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i); // 탐색(=하나의 사이클 포함)
                    cnt++;  // 새로운 사이클 발견
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        if (!visited[nextNode[node]]) {
            dfs(nextNode[node]);
        }
    }

}
