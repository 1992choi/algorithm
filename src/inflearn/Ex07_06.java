package inflearn;

import java.util.Scanner;

public class Ex07_06 {

    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        check = new int[n];

        DFS(0);
    }

    public static void DFS(int level) {
        if (level == check.length) {
            for (int i = 0; i < check.length; i++) {
                if (check[i] == 1) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        } else {
            check[level] = 1;
            DFS(level + 1);

            check[level] = 0;
            DFS(level + 1);
        }
    }

}