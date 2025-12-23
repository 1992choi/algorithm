package fastcampus.codingpackage.part4.ch02;

import java.util.*;

/*
  풀이

  - 핵심 아이디어
    - 주어진 여러 PD들의 “가수 출연 순서” 조건을 모두 만족하는 전체 순서를 구해야 한다.
    - 이 문제는 선후 관계가 정해져 있으므로 DAG(방향 비순환 그래프) 위상 정렬로 풀 수 있다. :contentReference[oaicite:0]{index=0}

  - 그래프 구성
    - 각 PD가 준 순서 예: 3 5 7 → 3 → 5 → 7 관계 생성
    - 인접 리스트에 from → to 간선을 추가
    - to 노드의 indegree(진입 차수)를 증가

  - 위상 정렬 구현
    - indegree가 0인 노드들을 큐에 넣고 시작
    - 큐에서 꺼낸 노드들을 결과로 추가
    - 해당 노드와 연결된 다음 노드들의 진입 차수를 감소시키고
      0이 되면 큐에 삽입 반복

  - 사이클 여부 처리
    - 위상 정렬 결과에 포함된 개수가 N과 다르면(정점 모두 처리 못함)
      → 사이클 존재 → 출력 0
    - 그렇지 않으면 결과 순서 출력 :contentReference[oaicite:1]{index=1}

  - 시간 복잡도
    - 그래프 구성 및 위상 정렬: O(N + 총 PD 순서의 길이)
*/
class Ex2623 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 가수 수
        int m = sc.nextInt();  // PD 수

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];

        // PD가 정한 순서를 각각 그래프에 추가
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();  // 이 PD가 정한 가수 수
            if (k == 0) continue;  // 없으면 넘어감
            int prev = sc.nextInt();
            for (int j = 1; j < k; j++) {
                int next = sc.nextInt();
                graph[prev].add(next);  // prev → next
                indegree[next]++;       // next는 선행(prev)이 하나 늘어남
                prev = next;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // 진입 차수가 0인 노드들 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            result.append(now).append('\n');
            count++;

            // now와 연결된 다음 노드들의 indegree 감소
            for (int next : graph[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 처리된 노드 개수가 전체와 같지 않으면 사이클 존재 → 불가능
        if (count != n) {
            System.out.println(0);
        } else {
            System.out.print(result);
        }
    }

}
