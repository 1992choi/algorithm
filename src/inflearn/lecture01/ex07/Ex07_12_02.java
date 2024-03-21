package inflearn.lecture01.ex07;

import java.util.Scanner;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex07_12_02 {

    static int answer = 0;
    static int n = 0; // 정점의 수
    static int m = 0; // 간선의 수
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

        // 1번부터 5번 정점까지 가지 수 확인
        check[1] = 1;
        dfs(1);

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

    public static void dfs(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    dfs(i); // v에서 i로 탐색
                    check[i] = 0;
                }
            }
        }
    }

}

