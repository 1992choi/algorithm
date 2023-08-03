package inflearn.lecture02.ex06;

import java.util.Arrays;

public class Ex06_03 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}})); // 2
        System.out.println(solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}})); // 0
        System.out.println(solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}})); // 1
    }

    static int answer;
    static int[] ch;
    static int level;

    public static int solution(int[][] cans) {
        answer = Integer.MAX_VALUE;
        level = cans.length;
        ch = new int[cans.length];

        // 탐색 시작
        dfs(0, cans);

        return answer;
    }

    public static void dfs(int l, int[][] cans) {
        if (l == level) {
            int whiteSum = 0;
            int blackSum = 0;
            for (int i = 0; i < cans.length; i++) {
                whiteSum += ch[i] == 1 ? cans[i][0] : 0;
                blackSum += ch[i] == 2 ? cans[i][1] : 0;
            }
            answer = Math.min(Math.abs(whiteSum - blackSum), answer);
        } else {
            for (int i = 0; i < cans.length; i++) {
                if (ch[i] == 0) {
                    // 흰돌 선택 (체크배열의 값을 1로 셋팅)
                    if (Arrays.stream(ch).filter(x -> x == 1).count() < cans.length / 2) {
                        ch[i] = 1;
                        dfs(l + 1, cans);
                        ch[i] = 0;
                    }

                    // 검은돌 선택 (체크배열의 값을 2로 셋팅)
                    if (Arrays.stream(ch).filter(x -> x == 2).count() < cans.length / 2) {
                        ch[i] = 2;
                        dfs(l + 1, cans);
                        ch[i] = 0;
                    }
                }
            }
        }
    }

}