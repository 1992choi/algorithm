package inflearn.lecture01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex07_13_Answer {

    static int n = 0;
    static int m = 0;
    static int answer = 0;
    static List<List<Integer>> graph;
    static int[] check;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        graph = new ArrayList<>();
        check = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(in.nextInt()).add(in.nextInt());
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
            for (int nextV : graph.get(v)) {
                if (check[nextV] == 0) {
                    check[nextV] = 1;
                    DFS(nextV);
                    check[nextV] = 0;
                }
            }
        }
    }

}

