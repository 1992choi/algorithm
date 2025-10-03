package fastcampus.codingpackage.part1.ch06;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Ex11660 {

    public static void main(String[] args) throws IOException {
        /*
            풀이
            - 누적합을 구한다.
              - 누적합을 구하기 위해서는 이전 누적합들의 덧셈 연산이 필요한데, 이 덧셈연산에는 중복 데이터가 존재하므로 중복된 데이터를 빼주는 작업이 필요하다.
            - 누적합 구간 계산
              - 계산된 누적합을 활용하여 구간에 대한 누적합을 계산한다.
              - 필요한 누적합을 사용하며, 포함되지 않은 구간은 누적합을 빼주는 연산이 필요하다.
                - 이때도 중복 연산이 이뤄지기 때문에 중복으로 뺀 값은 다시 더해주는 작업이 필요하다.

         */
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] acc = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 누적합 구하기. 이전 데이터 + 이전 데이터 - 중복데이터 + 현재 값
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + arr[i][j];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (M-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // 필요한 값이 모두 들어있는 누적합 참조 - 불필요한 값 제거 - 불필요한 값 제거 - 중복으로 제거된 데이터 추가
            bw.write(acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1] + "\n");
        }
        bw.flush();
    }

}