package inflearn.lecture01.ex09;

import java.util.Scanner;

public class Ex09_06_Answer {

    static int[] unf;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            union(a, b);
        }

        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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

}
