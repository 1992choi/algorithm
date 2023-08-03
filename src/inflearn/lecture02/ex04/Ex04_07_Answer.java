package inflearn.lecture02.ex04;

import java.util.ArrayList;

public class Ex04_07_Answer {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}})); // 2
        System.out.println(solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}})); // 5
        System.out.println(solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}})); // 3
        System.out.println(solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}})); // 3
    }

    public static int solution(int[][] meetings) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] x : meetings) {
            list.add(new int[]{x[0], 1});
            list.add(new int[]{x[1], 2});
        }
        list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int answer = 0, cnt = 0;
        for (int[] x : list) {
            if (x[1] == 1) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

}
