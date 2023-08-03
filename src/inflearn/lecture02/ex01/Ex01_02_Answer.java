package inflearn.lecture02.ex01;

import java.util.Arrays;

public class Ex01_02_Answer {

    public static void main(String[] args) {
        // CASE 1.
        int[][] arr1 = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(solution(arr1, 10))); // [2, 2]

        // CASE 2.
        int[][] arr2 = {
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(solution(arr2, 20))); // [4, 5]

        // CASE 3.
        int[][] arr3 = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(solution(arr3, 25))); // [0, 1]
    }

    public static int[] solution(int[][] board, int k) {
        int[] answer = new int[2];

        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1, count = 0;

        while (count < k) {
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;

        return answer;
    }

}
