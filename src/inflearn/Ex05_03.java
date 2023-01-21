package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[5][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
        int m = in.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = in.nextInt();
        }

        System.out.println(solution(n, board, m, moves));
        /*
            참고
            - 인프런 채점사이트에서는 2번 테스트 케이스부터 런타임 오류 발생
            - 프로그래머스에서는 테스트케이스 전부 통과
         */
    }

    public static int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            int tmp = 0;
            int y = 0;
            while (y < n) {
                tmp = board[y][moves[i] - 1];
                if (tmp != 0) {
                    board[y][moves[i] - 1] = 0;
                    break;
                }
                y++;
            }

            if (stack.isEmpty()) {
                stack.push(tmp);
            } else {
                int peekNum = stack.peek();
                if (peekNum == tmp && tmp != 0) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(tmp);
                }
            }
        }

        return answer;
    }

}
/*
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4



5
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 4 2
1 0 1 0 1
3
2 2 2


 [2, 3, 1, 4, 2, 3] 기댓값 6

4
0 0 0 0
0 0 0 0
0 4 4 0
1 2 2 1
6
2 3 1 4 2 3
 */