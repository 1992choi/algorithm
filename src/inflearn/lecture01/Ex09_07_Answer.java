package inflearn.lecture01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex09_07_Answer {

    static int[] unf;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        List<Edge> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            arr.add(new Edge(kb.nextInt(), kb.nextInt(), kb.nextInt()));
        }

        int answer = 0;
        Collections.sort(arr);

        for (Edge ob : arr) {
            int fv1 = find(ob.v1);
            int fv2 = find(ob.v2);

            if (fv1 != fv2) {
                answer += ob.cost;
                union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);
    }

    public static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    static class Edge implements Comparable<Edge> {
        public int v1;
        public int v2;
        public int cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }

}
