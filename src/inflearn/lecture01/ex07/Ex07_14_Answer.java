package inflearn.lecture01.ex07;

import java.util.*;

public class Ex07_14_Answer {

    static int n = 0;
    static int m = 0;
    static List<List<Integer>> graph;
    static int[] check;
    static int[] dis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        graph = new ArrayList<>();
        check = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(in.nextInt()).add(in.nextInt());
        }

        BFS(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
        /*
            - 입력 값
            6 9
            1 3
            1 4
            2 1
            2 5
            3 4
            4 5
            4 6
            6 2
            6 5
         */
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        check[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int currentV = queue.poll();
            for (int nextV : graph.get(currentV)) {
                if (check[nextV] == 0) {
                    check[nextV] = 1;
                    queue.offer(nextV);
                    dis[nextV] = dis[currentV] + 1;
                }
            }
        }
    }

}

