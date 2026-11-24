
package programmers.codingtest;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061
public class Ex013 {

    public static void main(String[] args) {
        System.out.println(
                solution(
                        new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                        new int[]{1, 5, 3, 5, 1, 2, 1, 4}
                )
        );
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;

            for (int row = 0; row < board.length; row++) {
                int doll = board[row][col];
                if (doll != 0) {
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }

                    board[row][col] = 0;
                    break;
                }
            }

        }

        return answer;
    }

}