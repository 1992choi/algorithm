package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_10_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] arr = new int[count + 2][count + 2];

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(count, arr));
    }

    public static int solution(int count, int[][] arr) {
        int answer = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                // 상하좌우 봉우리와 비교
                int maxHeight = 0; // 상하좌우 봉우리 중 가장 큰 숫자
                for (int k = 0; k < 4; k++) {
                    maxHeight = Math.max(maxHeight, arr[i + dx[k]][j + dy[k]]);
                }
                if (arr[i][j] > maxHeight) {
                    answer++;
                }
            }
        }

        return answer;
    }

}