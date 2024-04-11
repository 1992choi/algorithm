package inflearn.lecture01.ex08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex08_11_02 {

    static int[][] map;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        map = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = in.nextInt();
            }
        }

        // 탐색
        System.out.println(solution());
    }

    public static int solution() {
        int answer = Integer.MAX_VALUE;
        Queue<Integer[]> queue = new LinkedList<>();
        int level = 0;
        map[0][0] = 1;
        queue.offer(new Integer[]{0, 0});

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Integer[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == 6 && y == 6) {
                    answer = Math.min(answer, level);
                } else {
                    // 동
                    if (x < 6 && map[x + 1][y] == 0) {
                        map[x + 1][y] = 1;
                        queue.offer(new Integer[]{x + 1, y});
                    }

                    // 서
                    if (x > 0 && map[x - 1][y] == 0) {
                        map[x - 1][y] = 1;
                        queue.offer(new Integer[]{x - 1, y});
                    }

                    // 남
                    if (y < 6 && map[x][y + 1] == 0) {
                        map[x][y + 1] = 1;
                        queue.offer(new Integer[]{x, y + 1});
                    }

                    // 북
                    if (y > 0 && map[x][y - 1] == 0) {
                        map[x][y - 1] = 1;
                        queue.offer(new Integer[]{x, y - 1});
                    }
                }
            }

            level++;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

}