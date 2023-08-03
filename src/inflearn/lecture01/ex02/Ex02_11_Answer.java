package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_11_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] arr = new int[count + 1][6];
        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(count, arr));
    }

    public static int solution(int count, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < count + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < count + 1; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }

                if (cnt > max) {
                    max = cnt;
                    answer = i;
                }
            }
        }

        return answer;
    }

}