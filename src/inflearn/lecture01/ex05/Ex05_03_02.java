package inflearn.lecture01.ex05;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_03_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 바구니
        int n = in.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        // 크레인 동작
        int m = in.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = in.nextInt();
        }

        System.out.println(solution(n, board, m, moves));
    }

    public static int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            // 크레인이 위치한 곳에서 위쪽부터 탐색하여 인형이 있으면 뽑기
            int line = moves[i];
            for (int j = 0; j < n; j++) {
                if (board[j][line - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][line - 1]) { // 뽑은 인형을 넣기 전에 가장 위에 있는 인형과 동일하면 인형 터트리기
                        stack.pop();
                        answer += 2;
                    } else { // 가장 위의 인형과 다른 종류면 스택에 넣기
                        stack.push(board[j][line - 1]);
                    }
                    board[j][line - 1] = 0;
                    break;
                }
            }
            // printBoard(board);
        }

        return answer;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; board.length > i; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

}