
package programmers.codingtest;

import java.util.ArrayDeque;
import java.util.Queue;

// 저자 출제 - 제출할 수 없는 문제라서 클로드로 판단했을 때는 올바르게 구현된 것 확인.
public class Ex015 {

    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }

    public static int solution(int N, int K) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    queue.poll();
                    continue;
                }

                queue.add(queue.poll());
            }
        }

        return queue.poll();
    }

}