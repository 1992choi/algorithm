package inflearn.lecture02.ex07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex07_04 {

    public static void main(String[] args) {
        // TODO: 2023/06/20. 오답. board를 체크하면 최단경로가 아니고 board를 체크하지 않으면 OOM 발생.

        System.out.println(solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}
        })); // 12

//        System.out.println(solution(new int[][]{
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 1, 0},
//                {0, 0, 0, 1, 0, 0, 0},
//                {1, 1, 0, 1, 1, 1, 1},
//                {1, 1, 0, 1, 0, 0, 0},
//                {1, 0, 0, 0, 1, 0, 0},
//                {1, 0, 1, 0, 1, 0, 0}
//        })); // -1
    }

    public static int solution(int[][] board) {
        int answer = 0;

        // 12시부터 시계방향으로의 방향 셋팅
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            System.out.println("current=" + Arrays.toString(current));
            if (current[0] == 6 && current[1] == 6) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && board[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    board[nx][ny] = 1;
                }
            }

            answer++;
        }

        return answer;
    }

}