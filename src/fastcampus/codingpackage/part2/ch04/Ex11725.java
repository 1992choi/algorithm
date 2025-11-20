package fastcampus.codingpackage.part2.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    풀이
    - 트리는 사이클이 없는 연결 그래프이며, 각 노드는 단 하나의 부모를 가진다.
    - 문제에서 루트가 1이라고 정해졌으므로, DFS 또는 BFS를 통해 1에서 시작하여 연결된 노드를 탐색하면서 부모를 기록하면 된다.
    - 방문 배열(check)을 사용하여 부모와 자식을 구분하고, 아직 방문하지 않은 노드만 탐색해 부모를 지정한다.
*/
class Ex11725 {
    public static List<Integer>[] tree;  // 인접 리스트
    public static int[] parents;         // 각 노드의 부모 저장
    public static boolean[] check;       // 방문 여부 체크

    public static void find(int node) {
        check[node] = true;              // 현재 노드 방문 처리
        for (int child : tree[node]) {   // 연결된 노드 확인
            if (!check[child]) {         // 방문한 적 없다면 부모 설정 후 DFS 진행
                parents[child] = node;
                find(child);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();

        // 양방향 연결 (트리이므로 n-1개의 간선)
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        parents = new int[n + 1];
        check = new boolean[n + 1];

        find(1);  // 루트에서 시작

        // 부모 출력
        for (int i = 2; i <= n; i++)
            System.out.println(parents[i]);
    }
}
