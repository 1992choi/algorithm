package inflearn;

import java.util.Scanner;

public class Ex022 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt() + 2;
        int[][] arr = new int[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == 0 || i == count - 1 || j == 0 || j == count - 1) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = in.nextInt();
                }
            }
        }

        System.out.println(solution(count, arr));
    }

    public static int solution(int count, int[][] arr) {
        int answer = 0;

        for (int i = 1; i < count - 1; i++) {
            for (int j = 1; j < count - 1; j++) {
                int n = arr[i][j - 1];
                int s = arr[i][j + 1];
                int e = arr[i + 1][j];
                int w = arr[i - 1][j];

                if (arr[i][j] > n && arr[i][j] > s && arr[i][j] > e && arr[i][j] > w) {
                    answer++;
                }
            }
        }

        return answer;
    }

}