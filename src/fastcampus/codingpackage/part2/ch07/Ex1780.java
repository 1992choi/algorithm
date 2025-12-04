package fastcampus.codingpackage.part2.ch07;

import java.util.Scanner;

/*
    풀이 요약

    - N×N 종이를 -1, 0, 1 값으로 구성된 상태에서,
      동일한 숫자로만 이루어진 부분 종이의 개수를 세는 문제.
    - 분할 정복 사용:
        1) 현재 구간이 모두 같은 값인지 확인
        2) 같다면 해당 값 카운트
        3) 다르면 3×3으로 분할하여 재귀 탐색
    - 값이 -1,0,1 이므로 paper 인덱스는 (값 + 1)로 매핑
 */

class Ex1780 {
    static int n;
    static int[][] board;
    static int[] paper = new int[3]; // 0:-1, 1:0, 2:1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        cut(0, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(paper[i]);
        }
    }

    // 해당 구간이 모두 동일한 숫자인지 체크
    static boolean isSame(int r, int c, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[r][c] != board[r + i][c + j]) return false;
            }
        }
        return true;
    }

    // 분할 정복 핵심 로직
    static void cut(int r, int c, int length) {
        // 구간이 모두 같은 값이면 카운트 후 종료
        if (isSame(r, c, length)) {
            paper[board[r][c] + 1]++;
            return;
        }

        // 3×3 영역으로 분할해야 하므로 행(3개) × 열(3개) = 총 9개 구간을 재귀 호출로 탐색한다. (코드에 직접 9개의 구간에 대한 호출을 할 수 있지만, 코드가 너무 길어지기 때문에 수학식 적용)
        // i 는 '세로(행)' 방향 분할, j 는 '가로(열)' 방향 분할을 의미.
        // 각 구간의 시작 좌표는 (r + next*i, c + next*j)
        int next = length / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cut(r + next * i, c + next * j, next);
            }
        }
    }

}
