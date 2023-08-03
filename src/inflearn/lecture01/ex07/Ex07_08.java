package inflearn.lecture01.ex07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex07_08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();

        System.out.println(bfs(s, e));
    }

    public static int bfs(int s, int e) {
        int answer = 0;
        int[] visit = new int[10_001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visit[s] = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int tmp = queue.poll();
                if (tmp - 1 == e || tmp + 1 == e || tmp + 5 == e) {
                    return answer + 1;
                } else {
                    if (tmp < 1 || tmp > 9995) {
                        continue;
                    }

                    if (visit[tmp - 1] == 0) {
                        visit[tmp - 1] = 1;
                        queue.offer(tmp - 1);
                    }
                    if (visit[tmp + 1] == 0) {
                        visit[tmp + 1] = 1;
                        queue.offer(tmp + 1);
                    }
                    if (visit[tmp + 5] == 0) {
                        visit[tmp + 5] = 1;
                        queue.offer(tmp + 5);
                    }
                }
            }

            answer++;
        }

        return answer;
    }

}

