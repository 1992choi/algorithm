package inflearn.lecture02.ex08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex08_04 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}})); // 1
        System.out.println(solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}})); // 2
        System.out.println(solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}})); // 5
        System.out.println(solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}})); // 4
        System.out.println(solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}})); // 5
    }

    public static int solution(int[][] board) {
        // 방향 탐색용 배열 (3, 9, 6, 12시 순으로 셋팅)
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // 비용을 저장할 배열 선언 및 최대값으로 초기화
        int[][] cost = new int[board.length][board[0].length];
        for (int i = 0; i < cost.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        // 다익스트라를 위한 우선순위 큐 선언
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        queue.add(new int[]{0, 0, 0});

        // 탐색 시작
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                // 가고자하는 방향의 값(cost[nx][ny])이 현재의 방향의 값(cur[2]) + 방향전환의 비용(board[cur[0]][cur[1]] - 1 == i ? 0 : 1)보다 클 때 진행
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && cost[nx][ny] > cur[2] + (board[cur[0]][cur[1]] - 1 == i ? 0 : 1)) {
                    cost[nx][ny] = cur[2] + (board[cur[0]][cur[1]] - 1 == i ? 0 : 1);
                    queue.add(new int[]{nx, ny, cost[nx][ny]});
                }
            }
        }

        return cost[board.length - 1][board[0].length - 1];
    }

}