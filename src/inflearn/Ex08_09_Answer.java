package inflearn;

import java.util.Scanner;

public class Ex08_09_Answer {

    static int[] combi;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        combi = new int[m];

        DFS(0, 1);
    }

    public static void DFS(int level, int startNum) {
        if (level == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = startNum; i <= n; i++) {
                combi[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }

}

