package fastcampus.codingpackage.part4.ch01;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - N×N 수 중에서 N번째로 큰 수를 구하는 문제
    - 항상 "현재까지의 상위 N개 값"만 유지하면 된다
    - 최소 힙을 사용하여 힙의 크기를 N으로 제한

  - 접근 방식
    - 우선순위 큐를 최소 힙으로 구성
    - 첫 번째 줄의 N개 수를 모두 힙에 삽입
    - 이후 들어오는 수마다
      - 힙에서 가장 작은 값을 제거
      - 새로운 값을 삽입
    - 이 과정을 반복하면 힙에는 항상 가장 큰 N개의 수만 남게 된다

  - 정답 도출
    - 모든 입력 처리 후 힙의 최솟값이 곧 N번째로 큰 수

  - 시간 복잡도
    - 우선순위 큐 연산: O(log N)
    - 전체 입력 처리: O(N^2 log N)
*/
class Ex2075 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o1 > o2 ? 1 : -1;
        });

        // 첫 번째 줄의 N개 숫자를 힙에 넣어 초기 상태를 만든다
        // 이 시점에서 힙에는 단순히 N개의 값이 들어 있음
        for (int i = 0; i < n; i++) pq.offer(sc.nextInt());

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 힙에서 가장 작은 값 제거
                // → 상위 N개를 유지하기 위해 불필요한 값 제거
                pq.poll();

                // 새로운 값을 삽입
                // → 제거 + 삽입을 반복하면서 항상 "가장 큰 N개"만 유지
                pq.offer(sc.nextInt());
            }
        }

        // 힙에 남아 있는 값 중 최솟값이 N번째로 큰 수
        System.out.println(pq.poll());
    }

}
