package fastcampus.codingpackage.part2.ch06;

import java.util.Scanner;

/*
    풀이
    - 10x10 보드에서 1로 표시된 영역을 최소한의 색종이로 덮는 문제.
    - 색종이는 1x1 ~ 5x5까지 각 5개씩 사용할 수 있음.
    - 재귀 탐색을 통해 (row, col) 기준으로 덮을 수 있는 모든 색종이 크기를 시도하며 최소값 갱신.
    - prune: 이미 사용한 색종이 수가 현재 최소보다 많으면 더 이상 탐색하지 않음.
*/
class Ex17136 {

    static int[] paper = {0, 5, 5, 5, 5, 5}; // 1~5 크기 색종이 개수
    static int[][] board = new int[11][11];
    static int result = 26; // 최대 색종이 사용 개수(문제 제한 25보다 1 많음으로 초기화)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solve(0, 0, 0);
        System.out.println(result == 26 ? "-1" : result);
    }

    // (row, col) 위치에서 size x size 색종이 덮기
    static void fill(int row, int col, int size, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[row + i][col + j] = color;
            }
        }
    }

    // size x size 색종이를 (row, col)에 덮을 수 있는지 체크
    static boolean isValid(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) return false;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[row + r][col + c] == 0) return false;
            }
        }
        return true;
    }

    static int nextRow = 0;
    static int nextCol = 0;

    // 아직 덮지 않은 1 위치 찾기
    static void findNext(int row, int col) {
        for (int r = row; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (board[r][c] == 1) {
                    nextRow = r;
                    nextCol = c;
                    return;
                }
            }
        }
        nextRow = -1;
        nextCol = -1;
    }

    static void solve(int row, int col, int cnt) {
        if (result <= cnt) return; // 현재 최소값보다 크면 가지치기

        findNext(row, col);
        if (nextRow == -1 && nextCol == -1) { // 모든 1을 덮었으면
            result = cnt;
            return;
        }

        int r = nextRow;
        int c = nextCol;

        for (int size = 1; size <= 5; size++) {
            if (paper[size] == 0) continue;      // 해당 크기 색종이 없으면 패스
            if (!isValid(r, c, size)) continue;  // 해당 위치에 덮을 수 없으면 패스

            paper[size]--;
            fill(r, c, size, 0);
            solve(r, c, cnt + 1);
            fill(r, c, size, 1);
            paper[size]++;
        }
    }

}
