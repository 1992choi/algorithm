package inflearn.lecture02.ex07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_06 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[][]{
                {4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}
        })); // 11
        System.out.println(solution(new int[][]{
                {3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}
        })); // 16
        System.out.println(solution(new int[][]{
                {4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}
        })); // 3
    }

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        // 12시부터 시계방향으로의 방향 셋팅
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 거리 계산용 2차원 배열
        int[][] dist = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) { // 영희나 기사일 때 탐색 시작
                    int level = 0;
                    int[][] check = new int[board.length][board[0].length]; // 탐색여부를 확인할 배열
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        level++;
                        int len = queue.size();
                        for (int k = 0; k < len; k++) {
                            int[] p = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = p[0] + dx[l];
                                int ny = p[1] + dy[l];
                                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] != 1 && check[nx][ny] == 0) {
                                    check[nx][ny] = 1;
                                    queue.offer(new int[]{nx, ny});
                                    dist[nx][ny] += level;
                                }
                            }
                        }
                    }
                }
            }
        }

        // 최솟값 구하기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 산딸기이면서 갈 수 있는 구간인 경우에만 최소값을 구함
                if (board[i][j] == 4 && dist[i][j] != 0) {
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }

        return answer;
    }

}