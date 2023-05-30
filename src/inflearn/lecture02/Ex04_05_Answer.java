package inflearn.lecture02;

import java.util.ArrayList;

public class Ex04_05_Answer {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}})); // 8
        System.out.println(solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}})); // 8
        System.out.println(solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}})); // 37
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        col.sort((a, b) -> a - b);
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);
        for (int p : row) answer += Math.abs(x - p);
        for (int p : col) answer += Math.abs(y - p);
        return answer;
    }

}
