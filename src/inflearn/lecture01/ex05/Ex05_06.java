package inflearn.lecture01.ex05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_06 {

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
        for (int i = 0; i < n; i++) {
            queue.offer(i + 1);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int tmp = queue.poll();
            if (count != k) {
                queue.offer(tmp);
            } else {
                count = 0;
            }

            if (queue.size() == 1) {
                answer = queue.poll();
            }
        }

        return answer;
    }

}