package fastcampus.codingpackage.part4.ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 문제 간 선후 관계가 있으므로 위상 정렬을 사용
    - 여러 문제를 동시에 풀 수 있는 경우 번호가 작은 문제를 우선 선택해야 함
    - 이를 위해 큐 대신 최소 힙(PriorityQueue)을 사용

  - 그래프 모델링
    - a → b : a번 문제를 먼저 풀어야 b번 문제를 풀 수 있음
    - indegree[b] : b번 문제의 선행 문제 개수

  - 처리 방식
    - indegree가 0인 문제들을 우선순위 큐에 삽입
    - 큐에서 가장 번호가 작은 문제를 하나씩 꺼내며 위상 정렬 진행
    - 해당 문제와 연결된 다음 문제들의 indegree를 감소
    - indegree가 0이 되면 다시 큐에 삽입

  - 출력
    - 우선순위 큐에서 꺼낸 순서대로 문제 번호를 출력

  - 시간 복잡도
    - O((N + M) log N)
    - 우선순위 큐를 사용하는 위상 정렬
*/

class Ex1766 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] indegree = new int[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            System.out.print(now + " ");

            for (int next : list[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
    }

}
