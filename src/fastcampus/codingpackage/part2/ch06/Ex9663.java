package fastcampus.codingpackage.part2.ch06;

import java.util.Scanner;

/*
    풀이
    - N-Queen 문제: N x N 체스판에 퀸 N개를 서로 공격하지 못하도록 배치하는 경우의 수를 구하는 문제.
    - 행 단위로 재귀적으로 퀸을 배치하며 백트래킹 수행.
    - 각 행(row)에서 가능한 열(col)을 탐색하고, isValid()를 통해 세로, 대각선 공격 여부를 검사.
    - 가능한 위치에 놓으면 다음 행으로 이동. 모든 행에 놓으면 경우 수 1 증가.
    - 백트래킹으로 모든 조합 탐색.
*/
class Ex9663 {

    // queen 배열 사용 이유: 각 행(row)에는 퀸을 1개만 놓을 수 있으므로,
    // queen[row] = col 형태로 해당 행에 놓인 퀸의 열 위치를 저장하면
    // 같은 열 또는 대각선 공격 여부를 검사할 때 배열만 확인하면 되어 O(N)으로 효율적임.
    static int[] queen = new int[15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n, 0));
    }

    // row 행부터 n-1행까지 퀸을 놓는 경우의 수 반환
    static int solve(int n, int row) {
        int count = 0;
        // base case: 모든 행에 퀸을 놓음
        if (row == n) return 1;

        // recursive case: 현재 row에서 가능한 열 탐색
        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queen[row] = col;
                count += solve(n, row + 1);
            }
        }
        return count;
    }

    // row, col 위치에 퀸을 놓을 수 있는지 확인
    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 이미 퀸이 있음
            if (queen[i] == col) return false;
            // 대각선에 이미 퀸이 있음
            if (Math.abs(row - i) == Math.abs(col - queen[i])) return false;
        }
        return true;
    }

}
