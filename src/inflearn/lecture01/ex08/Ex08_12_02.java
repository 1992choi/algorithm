package inflearn.lecture01.ex08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Time Limit Exceeded
 */
public class Ex08_12_02 {

    static int m;
    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        arr = new int[n][m];
        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
                if (arr[i][j] == 1) {
                    queue.offer(new Integer[]{i, j});
                }
            }
        }

        // 탐색
        System.out.println(solution(queue));
    }

    public static int solution(Queue<Integer[]> queue) {
        int answer = 0;

        // 인접한 토마토 익히기
        while (!queue.isEmpty()) {
            answer++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Integer[] current = queue.poll();
                int x = current[1];
                int y = current[0];

                // 동
                if (x < m - 1 && arr[y][x + 1] == 0) {
                    arr[y][x + 1] = 1;
                    queue.offer(new Integer[]{y, x + 1});
                }

                // 서
                if (x > 0 && arr[y][x - 1] == 0) {
                    arr[y][x - 1] = 1;
                    queue.offer(new Integer[]{y, x - 1});
                }

                // 남
                if (y < n - 1 && arr[y + 1][x] == 0) {
                    arr[y + 1][x] = 1;
                    queue.offer(new Integer[]{y + 1, x});
                }

                // 북
                if (y > 0 && arr[y - 1][x] == 0) {
                    arr[y - 1][x] = 1;
                    queue.offer(new Integer[]{y - 1, x});
                }
            }

            // 모두 익었는지 체크
            if (isDone()) {
                break;
            }
        }

        // 익지않은 토마토 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
            }
        }

        return answer;
    }

    static boolean isDone() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

}