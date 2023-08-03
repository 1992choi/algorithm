package inflearn.lecture02.ex06;

import java.util.Stack;

public class Ex06_02_Answer {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(new int[][]{{1, 3}, {5, 7}, {4, 2}})); // 1968
        System.out.println(solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}})); // 864
        System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}})); // 720
        System.out.println(solution(new int[][]{{1, 7}})); // 3600
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}})); // 646
    }

    static int[] ch;
    static int[][] relation;
    static int answer;
    static Stack<Integer> pm;

    public static int solution(int[][] fight) {
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8];
        for (int[] x : fight) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        ch = new int[8];
        DFS(0);
        return answer;
    }

    public static void DFS(int L) {
        if (L == 7) answer++;
        else {
            for (int i = 1; i < 8; i++) {
                if (!pm.empty() && relation[pm.peek()][i] == 1) continue;
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

}