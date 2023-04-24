package inflearn.lecture01;

import java.util.Scanner;

public class Ex08_08_Answer {

    static int[] b;
    static int[] p;
    static int[] ch;
    static int n;
    static int f;
    static boolean flag = false;
    static int[][] dy = new int[35][35];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }

        DFS(0, 0);
    }

    public static void DFS(int level, int sum) {
        if (flag) {
            return;
        }

        if (level == n) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[level] = i;
                    DFS(level + 1, sum + (p[level] * b[level]));
                    ch[i] = 0;
                }
            }
        }

    }

    public static int combi(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

}

