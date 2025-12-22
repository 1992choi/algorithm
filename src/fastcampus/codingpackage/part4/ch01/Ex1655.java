package fastcampus.codingpackage.part4.ch01;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 입력되는 수들을 기준으로 항상 "가운데 값"을 빠르게 구해야 한다
    - 두 개의 힙을 사용해 중앙을 기준으로 값을 나눈다
    - 작은 값들을 저장하는 최대 힙(small), 큰 값들을 저장하는 최소 힙(big)을 유지한다

  - 힙 구성 의미
    - small: 현재까지 입력된 수 중에서 작은 절반을 저장 (최대 힙)
    - big: 현재까지 입력된 수 중에서 큰 절반을 저장 (최소 힙)
    - 항상 small의 크기는 big과 같거나 하나 더 많도록 유지한다

  - 유지 조건
    - small.peek() <= big.peek() 이 항상 성립해야 한다
    - 이 조건이 깨지면 두 힙의 루트 값을 서로 교환한다

  - 중간값 출력
    - 문제에서 요구하는 중간값은 항상 small.peek()
*/
class Ex1655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 작은 값들을 담는 최대 힙
        PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> {
            return o1 < o2 ? 1 : -1;
        });

        // 큰 값들을 담는 최소 힙
        PriorityQueue<Integer> big = new PriorityQueue<>();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            // 두 힙의 크기가 같으면 small에 먼저 넣는다
            // → small이 항상 big보다 같거나 하나 더 많게 유지
            if (small.size() == big.size()) small.offer(num);
            else big.offer(num);

            // small의 최대값이 big의 최소값보다 크면 순서가 깨진 상태
            // → 두 힙의 루트 값을 교환하여 정렬 상태 복구
            if (!small.isEmpty() && !big.isEmpty()) {
                int s = small.peek();
                int b = big.peek();
                if (s > b) {
                    small.poll();
                    big.poll();
                    small.offer(b);
                    big.offer(s);
                }
            }

            // 현재 중간값은 항상 small의 루트
            ans.append(small.peek()).append('\n');
        }

        System.out.println(ans);
    }

}
