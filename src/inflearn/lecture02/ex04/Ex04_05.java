package inflearn.lecture02.ex04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex04_05 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}})); // 8
        System.out.println(solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}})); // 8
        System.out.println(solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}})); // 37
    }

    public static int solution(int[][] board) {
        int answer = 0;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    rowList.add(i);
                    colList.add(j);
                    colList.sort(Comparator.naturalOrder());
                }
            }
        }

        int x = rowList.get(rowList.size() / 2);
        int y = colList.get(colList.size() / 2);

        for (int num : rowList) {
            answer += Math.abs(num - x);
        }
        for (int num : colList) {
            answer += Math.abs(num - y);
        }

        return answer;
    }

}
