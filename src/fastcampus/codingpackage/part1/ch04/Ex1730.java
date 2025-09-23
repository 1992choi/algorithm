package fastcampus.codingpackage.part1.ch04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String move = sc.hasNext() ? sc.next() : "";

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int x = 0, y = 0; // 시작 위치 (왼쪽 위)

        for (char c : move.toCharArray()) {
            int nx = x, ny = y;
            if (c == 'U') ny--;
            else if (c == 'D') ny++;
            else if (c == 'L') nx--;
            else if (c == 'R') nx++;

            // 경계 체크
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue; // 무시
            }

            // 현재 위치 선 긋기
            if (c == 'U' || c == 'D') {
                if (board[y][x] == '-') {
                    board[y][x] = '+';
                } else if (board[y][x] == '.') {
                    board[y][x] = '|';
                }
            } else {
                if (board[y][x] == '|') {
                    board[y][x] = '+';
                } else if (board[y][x] == '.') {
                    board[y][x] = '-';
                }
            }

            // 이동
            x = nx;
            y = ny;

            // 이동 후 위치 선 긋기
            if (c == 'U' || c == 'D') {
                if (board[y][x] == '-') {
                    board[y][x] = '+';
                } else if (board[y][x] == '.') {
                    board[y][x] = '|';
                }
            } else {
                if (board[y][x] == '|') {
                    board[y][x] = '+';
                } else if (board[y][x] == '.') {
                    board[y][x] = '-';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(new String(board[i]));
        }
    }
}

/*
    풀이

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String command = sc.hasNext() ? sc.next() : "";

    boolean[][] passVertical = new boolean[N][N];
    boolean[][] passHorizontal = new boolean[N][N];

    int curR = 0, curC = 0;
    for (int i = 0; i < command.length(); i++) {
        char cmd = command.charAt(i);
        if (cmd == 'D') {
            if (curR == N - 1) continue;;
            passVertical[curR][curC] = passVertical[curR + 1][curC] = true;
            curR++;
        }
        else if (cmd == 'U') {
            if (curR == 0) continue;
            passVertical[curR][curC] = passVertical[curR - 1][curC] = true;
            curR--;
        }
        else if (cmd == 'L') {
            if (curC == 0) continue;;
            passHorizontal[curR][curC] = passHorizontal[curR][curC - 1] = true;
            curC--;
        }
        else {
            if (curC == N - 1) continue;;
            passHorizontal[curR][curC] = passHorizontal[curR][curC + 1] = true;
            curC++;
        }
    }

    for (int i = 0; i < N; i++) {
        String ans = "";
        for (int j = 0; j < N; j++) {
            if (passHorizontal[i][j] && passVertical[i][j]) ans += "+";
            else if (passVertical[i][j]) ans += "|";
            else if (passHorizontal[i][j]) ans += "-";
            else ans += ".";
        }
        System.out.println(ans);
    }
 */