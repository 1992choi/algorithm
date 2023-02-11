package inflearn;

import java.util.Scanner;

public class Ex08_06_Answer {

    static int[] pm;
    static int[] ch;
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        ch = new int[n];
        pm = new int[m];

        DFS(0);
        /*
            - input case
            3 2
            3 6 9
         */
    }

    public static void DFS(int level) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[level] = arr[i];
                    DFS(level + 1);
                    ch[i] = 0;
                }
            }
        }
    }

}

