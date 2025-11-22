package fastcampus.codingpackage.part2.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    풀이
    - 칭찬 수치를 매번 적용하면, 반복해서 트리를 탐색할 수 밖에 없다.
      따라서 칭찬 수치를 한 번에 누적한 후 (= like[child] += like[node];)
      부하직원에게 칭찬을 하도록 (= next(child);) 코드를 작성한다.
 */
class Ex14267 {

    static int[] parent;
    static int[] like;
    static List<Integer>[] tree;

    public static void next(int node) {
        for (int i = 0; i < tree[node].size(); i++) {
            int child = tree[node].get(i);
            like[child] += like[node];
            next(child);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        like = new int[n + 1];
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            parent[i] = sc.nextInt();

            if (parent[i] != -1) {
                tree[parent[i]].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            int employee = sc.nextInt();
            int point = sc.nextInt();
            like[employee] += point;
        }

        next(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(like[i]).append(" ");
        }
        System.out.println(sb);
    }

}