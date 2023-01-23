package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_06_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 초기 셋팅
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) {
                answer = queue.poll();
            }
        }

        return answer;
    }

}