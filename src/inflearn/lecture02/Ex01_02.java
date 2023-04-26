package inflearn.lecture02;

import java.util.Arrays;

public class Ex01_02 {

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

    public static int[] solution(int[][] arr, int k) {
        int[] answer = {0, 0};

        int direction = 3; // 3, 6, 9, 12 : 시계방향
        int start = 0;
        while (start != k) {
            if (direction == 3) {
                if (answer[1] == arr[0].length - 1 || arr[answer[0]][answer[1] + 1] == 1) {
                    direction = 6;
                } else {
                    answer[1] = answer[1] + 1;
                }
            } else if (direction == 6) {
                if (answer[0] == arr.length - 1 || arr[answer[0] + 1][answer[1]] == 1) {
                    direction = 9;
                } else {
                    answer[0] = answer[0] + 1;
                }
            } else if (direction == 9) {
                if (answer[1] == 0 || arr[answer[0]][answer[1] - 1] == 1) {
                    direction = 12;
                } else {
                    answer[1] = answer[1] - 1;
                }
            } else {
                if (answer[0] == 0 || arr[answer[0] - 1][answer[1]] == 1) {
                    direction = 3;
                } else {
                    answer[0] = answer[0] - 1;
                }
            }

            start++;
        }

        return answer;
    }

}
