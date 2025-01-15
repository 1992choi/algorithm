package fastcampus.codingpackage.part1;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1236
public class Ex007 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] inputLine = new String[n];
        for (int i = 0; i < n; i++) {
            inputLine[i] = sc.next();
        }

        // 경비원 셋팅
        boolean[] isExistRow = new boolean[n];
        boolean[] isExistCol = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("X".equals(inputLine[i].split("")[j])) {
                    isExistRow[i] = true;
                    isExistCol[j] = true;
                }
            }
        }

        // row와 col 마다 존재하는 경비원 카운트
        int rowCount = 0;
        for (int i = 0; i < n; i++) {
            if (isExistRow[i]) {
                rowCount++;
            }
        }

        int colCount = 0;
        for (int i = 0; i < m; i++) {
            if (isExistCol[i]) {
                colCount++;
            }
        }

        // 영역대비 모자란 경비원 수 중에 큰 값으로 정답 셋팅
        System.out.println(Math.max(n - rowCount, m - colCount));
    }

}

// 풀이
/*
class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        boolean[] rowExist = new boolean[N];
        boolean[] colExist = new boolean[M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 'X') {
                    rowExist[i] = true;
                    colExist[j] = true;
                }

        int rowNeedCount = N;
        int colNeedCount = M;
        for (int i = 0; i < N; i++)
            if (rowExist[i]) rowNeedCount--;
        for (int i = 0; i < M; i++)
            if (colExist[i]) colNeedCount--;

        System.out.println(Math.max(rowNeedCount, colNeedCount));
    }
}
 */