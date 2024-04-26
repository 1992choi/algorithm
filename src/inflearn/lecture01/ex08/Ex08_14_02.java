package inflearn.lecture01.ex08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex08_14_02 {

    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    solution(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void solution(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] current = queue.poll();
                int currentX = current[1];
                int currentY = current[0];
                arr[currentY][currentX] = 0;

                // 북
                if (currentY > 0 && arr[currentY - 1][currentX] == 1) {
                    queue.offer(new int[]{currentY - 1, currentX});
                }

                // 북동
                if (currentY > 0 && currentX < n - 1 &&  arr[currentY - 1][currentX + 1] == 1) {
                    queue.offer(new int[]{currentY - 1, currentX + 1});
                }

                // 동
                if (currentX < n - 1 &&  arr[currentY][currentX + 1] == 1) {
                    queue.offer(new int[]{currentY, currentX + 1});
                }

                // 남동
                if (currentY < n - 1 && currentX < n - 1 &&  arr[currentY + 1][currentX + 1] == 1) {
                    queue.offer(new int[]{currentY + 1, currentX + 1});
                }

                // 남
                if (currentY < n - 1 &&  arr[currentY + 1][currentX] == 1) {
                    queue.offer(new int[]{currentY + 1, currentX});
                }

                // 남서
                if (currentY < n - 1 && currentX > 0 &&  arr[currentY + 1][currentX - 1] == 1) {
                    queue.offer(new int[]{currentY + 1, currentX - 1});
                }

                // 서
                if (currentX > 0 &&  arr[currentY][currentX - 1] == 1) {
                    queue.offer(new int[]{currentY, currentX - 1});
                }

                // 북서
                if (currentY > 0 && currentX > 0 &&  arr[currentY - 1][currentX - 1] == 1) {
                    queue.offer(new int[]{currentY - 1, currentX - 1});
                }
            }
        }
    }

}