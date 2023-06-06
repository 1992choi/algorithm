package programmers.lv1;

// 프로그래머스 Lv1. 최소직사각형 - https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class Ex86491 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // 4000
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); // 133
    }

    public static int solution(int[][] sizes) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] size : sizes) {
            int x = Math.max(size[0], size[1]);
            int y = Math.min(size[0], size[1]);

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        return maxX * maxY;
    }

}
