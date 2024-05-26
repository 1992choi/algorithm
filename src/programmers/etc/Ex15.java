package programmers.etc;

import java.util.LinkedList;
import java.util.Queue;

// 코딩 테스트 합격자 되기 : 07-2
public class Ex15 {

    public static void main(String[] args) {
        System.out.println(solution(5, 2)); // 3
        System.out.println(solution(7, 3)); // 4
    }

    public static int solution(int n, int k) {
        // 최초 셋팅 - 모든 사람 큐에 넣기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 마지막 사람 구하기
        int idx = 0;
        while (queue.size() != 1) {
            int pollValue = queue.poll();
            idx++;

            if (idx % k != 0) {
                queue.add(pollValue);
            }

        }

        return queue.poll();
    }

}
