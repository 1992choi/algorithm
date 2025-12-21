package fastcampus.codingpackage.part4.ch01;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - Java에서 제공하는 PriorityQueue를 사용하여 최소 힙을 그대로 활용
    - 별도의 자료구조 구현 없이 poll, offer 연산으로 문제 요구사항을 처리

  - 동작 방식
    - 입력 값이 0이 아닌 경우 우선순위 큐에 삽입
    - 입력 값이 0인 경우
      - 큐가 비어 있으면 0 출력
      - 비어 있지 않으면 가장 작은 값(poll 결과) 출력

  - 우선순위 큐 특징
    - 기본 PriorityQueue는 최소 힙 구조
    - poll(): 가장 작은 값 제거 및 반환
    - offer(): 값 삽입 시 내부적으로 힙 구조 유지

  - 시간 복잡도
    - 삽입, 삭제 모두 O(log N)
*/
class Ex1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (pq.isEmpty())
                    ans.append(0).append('\n');
                else
                    ans.append(pq.poll()).append('\n');
            } else pq.offer(x);
        }
        System.out.println(ans);
    }

}
