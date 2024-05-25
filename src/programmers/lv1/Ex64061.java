package programmers.lv1;

import java.util.Stack;

// 프로그래머스 Lv1. 크레인 인형뽑기 게임 - https://school.programmers.co.kr/learn/courses/30/lessons/64061
public class Ex64061 {

    public static void main(String[] args) {
        System.out.println(
                solution(
                        new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                        new int[]{1, 5, 3, 5, 1, 2, 1, 4}
                )
        ); // 4
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int crane = move - 1; // 크레인은 1번부터 채번되지만, 배열은 0번부터 채번되므로 -1 연산
            for (int i = 0; i < board.length; i++) { // 행을 0부터 탐색(=기계의 위쪽부터 탐색)하며 인형이 있는지 판단
                if (board[i][crane] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == board[i][crane]) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[i][crane]);
                        }
                    } else {
                        stack.push(board[i][crane]);
                    }

                    board[i][crane] = 0; // 인형을 뽑은 후 처리
                    break;
                }
            }
        }

        return answer;
    }

}
