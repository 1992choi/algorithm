package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_10_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] arr = new int[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(count, arr));
    }

    public static int solution(int count, int[][] arr) {
        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < count && ny >= 0 && ny < count && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }

}