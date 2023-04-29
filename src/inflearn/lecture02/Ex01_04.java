package inflearn.lecture02;

import java.util.Arrays;

public class Ex01_04 {

    public static void main(String[] args) {
        // CASE 1.
        System.out.println(Arrays.toString(solution(6, 5, 12))); // [6, 3]

        // CASE 2.
        System.out.println(Arrays.toString(solution(6, 5, 20))); // [2, 3]

        // CASE 3.
        System.out.println(Arrays.toString(solution(6, 5, 30))); // [4, 3]

        // CASE 4.
        System.out.println(Arrays.toString(solution(6, 5, 31))); // [0, 0]
    }

    public static int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        int[][] arr = new int[r][c];

        int count = 0;
        int direction = 12; // 0, 3, 6, 12 (=시계방향)
        int currentX = 0; // 열
        int currentY = r - 1; // 행

        while (true) {
            if (arr[currentY][currentX] == 0) {
                arr[currentY][currentX] = 1;
                count++;
            }

            if (count == k) {
                break;
            } else if (isFull(arr)) {
                return new int[]{0, 0};
            }

            if (direction == 12) {
                if (currentY == 0 || arr[currentY - 1][currentX] == 1) {
                    direction = 3;
                } else {
                    currentY--;
                }
            } else if (direction == 3) {
                if (currentX >= c - 1 || arr[currentY][currentX + 1] == 1) {
                    direction = 6;
                } else {
                    currentX++;
                }
            } else if (direction == 6) {
                if (currentY >= r - 1 || arr[currentY + 1][currentX] == 1) {
                    direction = 9;
                } else {
                    currentY++;
                }
            } else if (direction == 9) {
                if (currentX == 0 || arr[currentY][currentX - 1] == 1) {
                    direction = 12;
                } else {
                    currentX--;
                }
            }
        }

        answer[0] = currentX + 1;
        answer[1] = currentY + 1;
        return answer;
    }

    public static boolean isFull(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
