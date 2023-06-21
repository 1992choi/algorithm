package inflearn.lecture02;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_05 {

    public static void main(String[] args) {
        // TODO: 2023/06/21. 강의 보고 푼 문제
        System.out.println(solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}})); // 7
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}})); // 6
        System.out.println(solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}})); // -1
        System.out.println(solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}})); // -1
    }

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        // 12시부터 시계방향으로의 방향 셋팅
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 거리 계산용 2차원 배열
        int[][] dist = new int[board.length][board.length];

        // 비어있는 땅을 계산하기 위한 기준 변수 (빌딩마다 탐색한 땅을 체크하기 위함)
        int emptyLand = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    int level = 0;
                    int visitCount = 0;
                    while (!queue.isEmpty()) {
                        level++;
                        int len = queue.size();
                        for (int k = 0; k < len; k++) {
                            int[] p = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = p[0] + dx[l];
                                int ny = p[1] + dy[l];
                                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length && board[nx][ny] == emptyLand) {
                                    board[nx][ny] = emptyLand - 1;
                                    queue.offer(new int[]{nx, ny});
                                    dist[nx][ny] += level;
                                    visitCount++;
                                }
                            }
                        }
                    }

                    if (visitCount == 0) { // 해당 빌딩에서는 갈 수 있는 곳이 없을 때(=결국 중간지점을 만들 수 없는 케이스)
                        return -1;
                    }
                    emptyLand--;
                }
            }
        }

        // 최솟값 구하기
        for (int[] d : dist) {
            for (int value : d) {
                if (value != 0) {
                    answer = Math.min(answer, value);
                }
            }
        }

        return answer;
    }

}