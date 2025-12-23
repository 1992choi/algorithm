package fastcampus.codingpackage.part4.ch02;

import java.util.*;

/*
  풀이

  - 핵심 아이디어
    - 그래프가 방향 그래프이며, 주어진 조건은 선후 관계를 의미한다
    - 진입 차수가 0인 노드부터 차례대로 처리하는 위상 정렬을 사용한다
    - 어떤 노드를 처리하면, 해당 노드에서 나가는 간선을 제거하며 다음 노드의 진입 차수를 감소시킨다

  - 그래프 구성
    - list[a]에 b를 추가하여 a → b 관계를 표현
    - indegree[b]를 증가시켜 b로 들어오는 간선 개수를 관리

  - 처리 흐름
    - 진입 차수가 0인 노드를 큐에 삽입
    - 큐에서 하나씩 꺼내며 결과에 출력
    - 해당 노드와 연결된 다음 노드들의 진입 차수를 감소
    - 새롭게 진입 차수가 0이 된 노드를 큐에 추가

  - 특징
    - 사이클이 없는 DAG 구조가 보장되므로 모든 노드를 순서대로 출력 가능
*/
class Ex2252 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        int[] check = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            check[now] = 1;
            System.out.print(now + " ");

            for (int next : list[now]) {
                if (check[next] == 1) continue;
                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }
    }

}
