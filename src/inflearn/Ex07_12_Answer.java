package inflearn;

import java.util.Scanner;

public class Ex07_12_Answer {

    static int n = 0;
    static int m = 0;
    static int answer = 0;
    static int[][] graph;
    static int[] check;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        graph = new int[n + 1][n + 1];
        check = new int[n + 1];
        for (int i = 0; i < m; i++) {
            graph[in.nextInt()][in.nextInt()] = 1;
        }
        check[1] = 1;
        DFS(1);

        System.out.println(answer);
        /*
            - 입력 값
            5 9
            1 2
            1 3
            1 4
            2 1
            2 3
            2 5
            3 4
            4 2
            4 5
         */
    }

    public static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }
    }

}

