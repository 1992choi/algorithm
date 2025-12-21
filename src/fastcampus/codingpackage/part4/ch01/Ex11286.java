package fastcampus.codingpackage.part4.ch01;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 절댓값 기준으로 정렬되는 우선순위 큐를 직접 정의
    - 절댓값이 같을 경우 실제 값이 더 작은 수를 우선하도록 비교 기준 설정

  - 우선순위 규칙
    - |x|가 작은 값이 우선
    - |x|가 같다면 음수가 양수보다 우선

  - 구현 방법
    - PriorityQueue에 Comparator를 전달하여 정렬 기준을 커스터마이징
    - 입력 값이 0이면
      - 큐가 비어 있으면 0 출력
      - 비어 있지 않으면 poll 결과 출력
    - 입력 값이 0이 아니면 큐에 삽입

  - 시간 복잡도
    - 삽입, 삭제 모두 O(log N)
*/
class Ex11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 < o2 ? -1 : 1;
            }
            return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
        });

        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                if (pq.isEmpty())
                    ans.append(0).append('\n');
                else
                    ans.append(pq.poll()).append('\n');
            } else {
                pq.offer(x);
            }
        }
        System.out.println(ans);
    }

}
