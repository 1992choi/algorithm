package inflearn.lecture02.ex09;

import java.util.Scanner;

public class Ex09_01_Answer {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            int n = kb.nextInt();
            int m = (int) Math.round(kb.nextDouble() * 100);
            if (n == 0 && m == 0) {
                break;
            }

            int[] dy = new int[m + 1];
            for (int i = 0; i < n; i++) {
                int c = kb.nextInt();
                int p = (int) Math.round(kb.nextDouble() * 100);
                for (int j = p; j <= m; j++) {
                    dy[j] = Math.max(dy[j], dy[j - p] + c);
                }
            }

            System.out.println(dy[m]);
        }
    }

}