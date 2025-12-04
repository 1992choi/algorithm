package fastcampus.codingpackage.part2.ch07;

import java.util.Scanner;

/*
    풀이
    - 주어진 흑백 영상(0과 1로 구성된 n×n)을 쿼드트리(Quad Tree) 방식으로 압축하는 문제
    - 하나의 구역이 모두 같은 값(0 또는 1)이면 해당 숫자만 출력하고,
      그렇지 않으면 네 부분으로 나누어 재귀적으로 압축 수행
    - 방문 순서는 다음과 같은 고정된 4분할 순서
        1) 좌상단
        2) 우상단
        3) 좌하단
        4) 우하단
    - 압축되지 않는 경우 parentheses "(" + 네 구역 압축 결과 + ")" 형태로 출력됨
    - 시간복잡도: 최악의 경우 모든 칸을 검사해야 하므로 O(n^2)
*/
class Ex1992 {
    static int n;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        // 입력 처리
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        compress(0, 0, n);
    }

    // (r, c)에서 시작하는 length × length 구역 압축
    static void compress(int r, int c, int length) {

        // 구역 전체가 동일한 값인지 검사
        if (isSame(r, c, length)) {
            System.out.print(board[r][c]); // 동일하면 해당 값만 출력
            return;
        }

        // 동일하지 않으면 네 구역으로 쪼개서 압축
        int mid = length / 2;
        System.out.print("(");
        compress(r, c, mid);              // 좌상단
        compress(r, c + mid, mid);        // 우상단
        compress(r + mid, c, mid);        // 좌하단
        compress(r + mid, c + mid, mid);  // 우하단
        System.out.print(")");
    }

    // 구역 전체 값이 동일한지 확인
    static boolean isSame(int r, int c, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                // 하나라도 다르면 false
                if (board[r][c] != board[r + i][c + j]) return false;
            }
        }
        return true;
    }

}
