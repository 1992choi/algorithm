package inflearn.lecture02.ex08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex08_03 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}})); // 1
        System.out.println(solution(new int[][]{{0, 1, 1, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}})); // 3
        System.out.println(solution(new int[][]{{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}})); // 4
        System.out.println(solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}})); // 7
        System.out.println(solution(new int[][]{{0, 0, 1, 0, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}})); // 5
    }

    public static int solution(int[][] board) {
        // 방향 탐색용 배열
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 비용을 저장할 배열 선언 및 최대값으로 초기화
        int[][] cost = new int[board.length][board[0].length];
        for (int i = 0; i < cost.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        // 다익스트라를 위한 우선순위 큐 선언
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));

        // 탐색 시작
        queue.add(new int[]{0, 0, board[0][0]});
        while (!queue.isEmpty()) {
            int[] curArr = queue.poll();

            // 4방향 탐색
            for (int k = 0; k < 4; k++) {
                int nx = curArr[0] + dx[k];
                int ny = curArr[1] + dy[k];

                // 격자 안쪽이며 가고자 하는 방향의 값이 현재 값 + 비용(0 또는 1)보다 클 경우 수행
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && cost[nx][ny] > board[nx][ny] + curArr[2]) {
                    cost[nx][ny] = board[nx][ny] + curArr[2];
                    queue.add(new int[]{nx, ny, cost[nx][ny]});
                }
            }
        }

        return cost[board.length - 1][board[0].length - 1];
    }

}